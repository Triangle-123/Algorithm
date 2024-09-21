import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr = new int[N + 1][2];
		int[][] dp = new int[N + 1][2];
		for(int i = 0; i < N; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
			dp[i][0] = arr[i][1];
		}
		for(int i = 0; i < N + 1; i++) {
			int t = arr[i][0] + i;
			if(t < N + 1) {
				dp[i][1] += dp[i][0];
			}
			for(int j = arr[i][0] + i; j <= N; j++) {
				dp[j][1] = Math.max(dp[j][1], dp[i][1]);
			}
		}
		System.out.println(dp[N][1]);
	}
}
