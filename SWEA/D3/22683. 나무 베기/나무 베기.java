import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	
	static Queue<int[]> q = new ArrayDeque<>();
	static int N, K;
	static char[][] board;
	static int[][][] minRoute;
	static boolean[][][] visited;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tCase = sc.nextInt();
		for(int t = 1; t <= tCase; t++) {
			N = sc.nextInt();
			K = sc.nextInt();
			board = new char[N][N];
			minRoute = new int[N][N][K + 1];
			q.clear();
			int[] end = null;
			for(int i = 0; i < N; i++) {
				char[] arr = sc.next().toCharArray();
				for(int j = 0; j < N; j++) {
					board[i][j] = arr[j];
					if(board[i][j] == 'X') q.offer(new int[] {i, j, 0, 0, 0});
					if(board[i][j] == 'Y') end = new int[] {i, j};
				}
			}
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					Arrays.fill(minRoute[i][j], Integer.MAX_VALUE);
				}
			}
			visited = new boolean[N][N][K + 1];
			BFS(t);
			int ans = Integer.MAX_VALUE;
			for(int i = 0; i <= K; i++) {
				ans = Math.min(ans, minRoute[end[0]][end[1]][i]);
			}
			System.out.print("#" + t + " ");
			if(ans == Integer.MAX_VALUE) System.out.println(-1);
			else System.out.println(ans);
		}
	}

	private static void BFS(int t) {
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			int r = poll[0];
			int c = poll[1];
			int b = poll[2];
			int delta = poll[3];
			int move = poll[4];
			visited[r][c][b] = true;
			for(int d = 0; d < 4; d++) {
				int cnt = 1;
				if(d != delta) {
					cnt += 4 - Math.abs(d - delta);
					if(cnt == 4) {
						cnt = 2;
					}
				}
				int nr = r + dr[d];
				int nc = c + dc[d];
				if(nr < N && nr >= 0 && nc < N && nc >= 0) {
					if(!visited[nr][nc][b]) {
						if(board[nr][nc] == 'T') {
							if(b < K) {
								visited[nr][nc][b] = true;
								minRoute[nr][nc][b] = Math.min(move + cnt, minRoute[nr][nc][b]);
								q.offer(new int[] {nr, nc, b + 1, d, move + cnt});
							}
						} else {
							visited[nr][nc][b] = true;
							minRoute[nr][nc][b] = Math.min(move + cnt, minRoute[nr][nc][b]);
							q.offer(new int[] {nr, nc, b, d, move + cnt});
						}
					} else if(minRoute[nr][nc][b] > move + cnt) {
						if(board[nr][nc] == 'T') {
							if(b < K) {
								visited[nr][nc][b] = true;
								minRoute[nr][nc][b] = Math.min(move + cnt, minRoute[nr][nc][b]);
								q.offer(new int[] {nr, nc, b + 1, d, move + cnt});
							}
						} else {
							visited[nr][nc][b] = true;
							minRoute[nr][nc][b] = Math.min(move + cnt, minRoute[nr][nc][b]);
							q.offer(new int[] {nr, nc, b, d, move + cnt});
						}
					}
				}
			}
		}
	}
}
