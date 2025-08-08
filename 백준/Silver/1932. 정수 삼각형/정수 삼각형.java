import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] triangle = new int[N][N];
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j <= i; j++) {
				triangle[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[][] dp = new int[N][N];
		dp[0][0] = triangle[0][0];
		for(int i = 1; i < N; i++) {
			for(int j = 0; j <= i; j++) {
				dp[i][j] = triangle[i][j];
				if(j == 0) {
					dp[i][j] += dp[i - 1][j];
				} else if(j == i) {
					dp[i][j] += dp[i - 1][j - 1];
				} else {
					dp[i][j] += Math.max(dp[i - 1][j], dp[i - 1][j - 1]);
				}
			}
		}
		int max = 0;
		for(int i = 0; i < N; i++) {
			max = Math.max(max, dp[N - 1][i]);
		}
		System.out.println(max);
	}
}
