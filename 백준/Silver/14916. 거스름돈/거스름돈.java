import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] dp = new int[N + 1];
		for(int i = 1; i <= N; i++) {
			int min = 100001;
			if(i >= 2) {
				min = Math.min(dp[i - 2] + 1, min);
			}
			if(i >= 5) {
				min = Math.min(dp[i - 5] + 1, min) ;
			}
			dp[i] = min;
		}
		if(dp[N] < 0 || dp[N] > N) dp[N] = -1;
		System.out.println(dp[N]);
	}
}
