import java.util.*;
import java.io.*;

public class Main {
	static int cnt;
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		long result = 0;
		long[][] dp = new long[N + 1][10];
		long mod = 1000000000;
		
		for(int i = 0; i <= 9; i++) {
			dp[1][i] = 1;
		}
		
		for(int i = 2; i <= N; i++) {
			for(int j = 0; j <= 9; j++) {
				if(j == 0) {
					dp[i][j] = dp[i - 1][j + 1] % mod; 
				} else if(j == 9) {
					dp[i][j] = dp[i - 1][j - 1] % mod;
				} else {
					dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j + 1] % mod;
				}
			}
		}
		
		for(int i = 1; i <= 9; i++) {
			result += dp[N][i] % mod;
		}
		
		System.out.println(result % mod);
		
	}
}
// 길이가 i이고 마지막 자릿수가 j인 계단수를 dp[i][j]에 기록..
// dp[i][j]는 dp[i - 1][j - 1]과 dp[i - 1][j + 1]의 합..