import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tCase = sc.nextInt();
		for(int t = 1; t <= tCase; t++) {
			int N = sc.nextInt();
			int[][] dp = new int[N + 1][2];
			
			dp[0][0] = 1;
			if(N >= 1) dp[1][1] = 1;
			
			for(int i = 2; i <= N; i++) {
				dp[i][0] = dp[i - 2][0] + dp[i - 1][0];
				dp[i][1] = dp[i - 2][1] + dp[i - 1][1];
			}
			
			System.out.println(dp[N][0] + " " +dp[N][1]);
		}
	}
}
