import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[] dp = new int[N + 2];
		boolean[] vip = new boolean[N + 2];
		for(int i = 0; i < M; i++) {
			int num = Integer.parseInt(br.readLine());
			vip[num] = true;
		}
		dp[0] = 1;
		int sum = 1;
		for(int i = 1; i <= N + 1; i++) {
			if(vip[i] || i == N + 1) {
				dp[i] = 1;
				sum *= dp[i - 1];
			}
			else if(i == 1 || vip[i - 1]) dp[i] = 1;
			else dp[i] = dp[i - 1] + dp[i - 2]; 
		}
		System.out.println(sum);
	}
}