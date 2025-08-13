import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] dp = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		for(int i = 0; i < N; i++) {
			dp[i] = arr[i];
			int max = 0;
			if(i >= 1) {
				max = Math.max(arr[i - 1], max);
			}
			if(i >= 2) {
				max = Math.max(dp[i - 2], max);
			}
			if(i >= 3) {
				max = Math.max(dp[i - 3] + arr[i - 1], max);
			}
			if(i >= 4) {
				max = Math.max(dp[i - 4] + arr[i - 1], max);
			}
			dp[i] += max;
		}
		int max = 0;
		for(int i = 0; i < N; i++) {
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}
}
