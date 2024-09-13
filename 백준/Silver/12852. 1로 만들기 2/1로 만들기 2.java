import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] dp = new int[N + 1][2];
		for(int n = 2; n <= N; n++) {
			int trans = 1;
			dp[n][0] = dp[n - 1][0] + 1;
			if(n % 2 == 0 && dp[n][0] > dp[n / 2][0] + 1) {
				dp[n][0] = dp[n / 2][0] + 1;
				trans = 2;
			}
			if(n % 3 == 0 && dp[n][0] > dp[n / 3][0] + 1) {
				dp[n][0] = dp[n / 3][0] + 1;
				trans = 3;
			}
			switch(trans) {
			case 1:
				dp[n][1] = n - 1;
				break;
			case 2:
				dp[n][1] = n / 2;
				break;
			case 3:
				dp[n][1] = n / 3;
				break;
			}
			
		}
		int idx = dp[N][1];
		System.out.println(dp[N][0]);
		System.out.print(N + " ");
		while(idx >= 1) {
			System.out.print(idx + " ");
			idx = dp[idx][1];
		}
	}
}
