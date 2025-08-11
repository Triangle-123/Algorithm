import java.util.*;
import java.io.*;

public class Main {
	
	static int[][] board;
	static long[][] dp;
	static int[] dr = {1, 0};
	static int[] dc = {0, 1};
	static int N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		dp = new long[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			Arrays.fill(dp[i], -1);
			for(int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(jump(0, 0));
	}

	private static long jump(int r, int c) {
		if(r == N - 1 && c == N - 1) return 1;
		if(dp[r][c] == -1) {
			dp[r][c] = 0;
			for(int d = 0; d < 2; d++) {
				int nr = r + (dr[d] * board[r][c]);
				int nc = c + (dc[d] * board[r][c]);
				if(nr < N && nc < N) {
					dp[r][c] += jump(nr, nc);
				}
			}
		}
		return dp[r][c];
	}
}
