import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr = new int[N][2];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < 2; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		int[] dp = new int[N + 1];
		
		for(int i = N - 1; i >= 0; i--) {
			if(arr[i][0] + i > N) {
				dp[i] = dp[i + 1];
				continue;
			}
			dp[i] = Math.max(dp[i + 1], dp[arr[i][0] + i] + arr[i][1]);
		}
		
		System.out.println(dp[0]);
	}
}
