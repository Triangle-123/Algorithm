import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tCase = sc.nextInt();
		for(int t = 1; t <= tCase; t++) {
			int N = sc.nextInt();
			long[] dp = new long[N + 1];
			for(int i = 1; i <= N; i++) {
				if(i < 4) dp[i] = 1;
				else if(i < 6) dp[i] = 2;
				else dp[i] = dp[i - 1] + dp[i - 5];
			}
			System.out.println(dp[N]);
		}
	}
}
