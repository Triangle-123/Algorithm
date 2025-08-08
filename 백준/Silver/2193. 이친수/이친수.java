import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] dp = new long[N + 1];
		
		if(N >= 1) dp[1] = 1;
		if(N >= 2) dp[2] = 1;
		for(int i = 0; i <= N; i++) {
			if(i >= 3) {
				dp[i] = dp[i - 2] + dp[i - 1];
			}
		}
		System.out.println(dp[N]);
	}
}