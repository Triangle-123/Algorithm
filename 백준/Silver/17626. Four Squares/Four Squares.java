import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] dp = new int[N + 1];
		for(int i = 1; i <= N; i++) {
			int idx = 1;
			while((int)(i / Math.pow(idx, 2)) != 0) {
				idx++;
			}
			idx--;
			dp[i] = dp[i - (int)Math.pow((int)Math.sqrt(i), 2)] + 1;
			while(idx >= 1) {
				dp[i] = Math.min(dp[i], dp[i - (int)Math.pow(idx, 2)] + 1);
				idx--;
			}
		}
		System.out.println(dp[N]);
	}
}