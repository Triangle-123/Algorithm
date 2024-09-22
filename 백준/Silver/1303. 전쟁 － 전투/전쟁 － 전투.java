import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static boolean[][] visited;
	static char[][] board;
	static int N, M, wCnt, bCnt;
	static Queue<Integer> q = new ArrayDeque<>();
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		board = new char[M][N];
		visited = new boolean[M][N];
		for(int i = 0; i < M; i++) {
			board[i] = sc.next().toCharArray();
		}
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					BFS(i, j, board[i][j]);
				}
			}
		}
		System.out.println(wCnt + " " + bCnt);
	}
	private static void BFS(int i, int j, char team) {
		visited[i][j] = true;
		q.clear();
		q.offer(i);
		q.offer(j);
		int cnt = 1;
		while(!q.isEmpty()) {
			int r = q.poll();
			int c = q.poll();
			
			for(int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(nr < M && nr >= 0 && nc < N && nc >= 0 && !visited[nr][nc] && board[nr][nc] == team) {
					visited[nr][nc] = true;
					q.offer(nr);
					q.offer(nc);
					cnt++;
				}
			}
		}
		if(team == 'W') {
			wCnt += cnt * cnt;
		} else bCnt += cnt * cnt;
	}
}
