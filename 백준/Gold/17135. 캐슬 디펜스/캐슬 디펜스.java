import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int N, M, D, R;
	static int[][] board;
	static boolean[][] visited;
	static int[][] game;
	static int maxSum;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		D = sc.nextInt();
		R = 3;
		board = new int[N + 1][M];
		visited = new boolean[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		maxSum = 0;
		combi(0, 0);
		System.out.println(maxSum);
	}

	private static void combi(int idx, int sidx) {
		if(sidx == R) {
			game = new int[N][];
			for(int i = 0; i < N; i++) {
				game[i] = Arrays.copyOf(board[i], M);
			}
			int sum = 0;
			while(true) {
				boolean notEnd = false;
				out: for(int i = 0; i < N; i++) {
					for(int j = 0; j < M; j++) {
						if(game[i][j] == 1) {
							notEnd = true;
							break out;
						}
					}
				}
				if(!notEnd) break;
				for(int i = 0; i < N; i++) {
					Arrays.fill(visited[i], false);
				}
				for(int i = 0; i < M; i++) {
					if(board[N][i] == 1) {
						sum += BFS(N - 1, i, 1);
					}
				}
				for(int i = N - 1; i > 0; i--) {
					game[i] = game[i - 1];
					game[i - 1] = new int[M];
				}
			}
			maxSum = Math.max(maxSum, sum);
			return;
		}
		if(idx == M) return;
		
		board[N][idx] = 1;
		combi(idx + 1, sidx + 1);
		board[N][idx] = 0;
		combi(idx + 1, sidx);
		
	}

	static int[] dr = {0, -1, 0};
	static int[] dc = {-1, 0, 1};
	static Queue<Integer> q = new LinkedList<>();
	
	private static int BFS(int x, int y, int dis) {
		
		q.clear();
		q.offer(x);
		q.offer(y);
		
		while(!q.isEmpty()) {
			
			int qSize = q.size();
			for(int i = 0; i < qSize; i += 2) {
				int r = q.poll();
				int c = q.poll();
				
				if(visited[r][c]) return 0;
				else if(game[r][c] == 1) {
					game[r][c] = 0;
					visited[r][c] = true;
					return 1;
				}
				
				if(dis >= D) continue;
				
				for(int d = 0; d < 3; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					
					if(nr < N && nr >= 0 && nc < M && nc >= 0) {
						q.offer(nr);
						q.offer(nc);
					}
				}
			}
			dis++;
		}
		return 0;
	}
}
