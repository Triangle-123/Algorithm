import java.util.*;
import java.io.*;

public class Main {
	
	static int[] arr;
	static int[] dp;
	static int[] trace;
	static int max = 1;
	static int maxIdx = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		dp = new int[N];
		trace = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.fill(trace, -1);
		solve(N - 1);
		
		System.out.println(max);
		Stack<Integer> stack = new Stack<>();
		int idx = maxIdx;
		while(idx > -1) {
			stack.push(arr[idx]);
			idx = trace[idx];
		}
		StringBuilder sb = new StringBuilder();
		while(!stack.isEmpty()) {
			sb.append(stack.pop() + " ");
		}
		System.out.println(sb);
	}

	private static int solve(int n) {
		if(dp[n] == 0) {
			dp[n] = 1;
			for(int i = n - 1; i >= 0; i--) {
				if(arr[n] > arr[i]) {
					int s = solve(i) + 1;
					if(dp[n] < s) {
						dp[n] = s;
						trace[n] = i;
					}
					if(dp[n] > max) {
						max = dp[n];
						maxIdx = n;
					}
				} else {
					solve(i);
				}
			}
		}
		return dp[n];
	}
}
