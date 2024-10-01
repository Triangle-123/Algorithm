import java.util.Scanner;

public class Main {
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int N, M;
	static int[][] board, dp;
	static boolean[][] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		board = new int[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		
		dp = new int[N][M];
		visited = new boolean[N][M];
		dp[0][0] = 1;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(!visited[i][j]) DFS(i, j);
			}
		}
		System.out.println(dp[N - 1][M - 1]);
	}

	private static void DFS(int r, int c) {
		visited[r][c] = true;
		
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr < N && nr >= 0 && nc < M && nc >= 0 && board[r][c] < board[nr][nc]) {
				if(!visited[nr][nc]) {
					DFS(nr, nc);
				}
				dp[r][c] += dp[nr][nc];
			}
		}
		
	}
}
