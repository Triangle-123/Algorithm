import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] dp = new int[N + 1];
		int[] arr = new int[N + 1];
		for(int i = 1; i <= N; i++) {
			arr[i] = sc.nextInt();
		}
		
		
		for(int n = 1; n <= N; n++) { // 2칸 전과 1칸전(인데 연속3칸이 되지않으려면 직전 1칸이 2칸을 넘어 온 곳이어야 함)
			if(n < 3) dp[n] = arr[n] + dp[n - 1];
			else dp[n] = Math.max(dp[n - 2], dp[n - 3] + arr[n - 1]) + arr[n];
		}
		System.out.println(dp[N]);
	}
}