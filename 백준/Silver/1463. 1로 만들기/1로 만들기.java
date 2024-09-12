import java.util.Scanner;

public class Main {
	
	static int N;
	
	public static void main(String[] args) { // 굉장히 어렵다..
		// 경우의 수를 나열하여 생각해보는게 좋다
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		int[] dp = new int[N + 1];
		
		for(int n = 2; n <= N; n++) {
			
			dp[n] = dp[n - 1] + 1;
			if(n % 2 == 0) {
				dp[n] = Math.min(dp[n / 2] + 1, dp[n]); 
			}
			if(n % 3 == 0) {
				dp[n] = Math.min(dp[n / 3] + 1, dp[n]);  
			}
		}
		System.out.println(dp[N]);
	}
	
}