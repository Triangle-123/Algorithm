import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tCase = sc.nextInt();
		for(int t = 1; t <= tCase; t++) {
			int N = sc.nextInt();
			int[] dp = new int[N + 1];
			dp[0] = 1;
			if(N >= 1) dp[1] = 1;
			if(N >= 2) dp[2] = 2;
			for(int n = 3; n <= N; n++) {
				dp[n] = dp[n - 1] + dp[n - 2] + dp[n - 3];
				
			}
			System.out.println(dp[N]);
		}
	}
}
//1 1 1 1 1
//1 1 2 1
//1 2 1 1
//2 1 1 1
//1 1 1 2
//2 2 1
//1 2 2
//2 1 2
//1 3 1
//1 1 3
//3 1 1
//3 2
//2 3