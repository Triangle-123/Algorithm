import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N + 1];
		Arrays.fill(dp, 100001);
		dp[0] = 0;
		dp[1] = 1;
		for(int i = 2; i <= N; i++) {
			int num = (int) Math.sqrt(i);
			for(int j = num; j >= 1; j--) {
				dp[i] = Math.min(dp[i - (int)Math.pow(j, 2)] + 1, dp[i]);
			}
		}
		System.out.println(dp[N]);
	}
}
