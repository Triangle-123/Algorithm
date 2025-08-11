import java.util.*;
import java.io.*;

public class Main {
	
	static int[] dr = {-1, 0, -1};
	static int[] dc = {0, -1, -1};
	static int[][] board;
	static int[][] dp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		board = new int[N][M];
		dp = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			Arrays.fill(dp[i], -1);
			for(int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(candy(N - 1, M - 1));
	}
	private static int candy(int r, int c) {
		if(dp[r][c] == -1) {
			dp[r][c] = board[r][c];
			int max = 0;
			for(int d = 0; d < 3; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if(nr >= 0 && nc >= 0) {
					max = Math.max(max, candy(nr, nc)); 					
				}
			}
			dp[r][c] += max;
		}
		return dp[r][c];
	}
}
