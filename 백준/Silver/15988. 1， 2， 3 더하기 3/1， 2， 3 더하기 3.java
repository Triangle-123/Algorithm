import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tCase = Integer.parseInt(br.readLine());
		int mod = 1000000009;
		long[] dp = new long[1000001];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for(int i = 4; i <= 1000000; i++) {
			dp[i] = (dp[i - 3] + dp[i - 2] + dp[i - 1]) % mod;
		}
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < tCase; t++) {
			int N = Integer.parseInt(br.readLine());
			sb.append((dp[N] % mod) + "\n");
		}
		System.out.println(sb);
	}
}
// 1 = 1
// 2 = 2
// 3 = 4
// 4 = 7
// 5 = 13
// 6 = 24
// 7 = 44