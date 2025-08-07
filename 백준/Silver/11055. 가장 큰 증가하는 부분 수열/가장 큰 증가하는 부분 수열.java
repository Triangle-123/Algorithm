import java.util.*;
import java.io.*;

public class Main {
	
	static int[] dp;
	static int[] arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N];
		dp = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		solve(N - 1);
		
		int max = 0;
		for(int i = 0; i < N; i++) {
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}

	private static int solve(int n) {
		if(dp[n] == 0) {
			dp[n] = arr[n];
			for(int i = n - 1; i >= 0; i--) {
				if(arr[n] > arr[i]) {
					dp[n] = Math.max(solve(i) + arr[n], dp[n]);
				} else solve(i);
			}
		}
		return dp[n];
	}
}