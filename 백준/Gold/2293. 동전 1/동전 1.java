import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int[] coin = new int[N];
		for(int i = 0; i < N; i++) {
			coin[i] = sc.nextInt();
		}
		
		int[] dp = new int[K + 1];
		dp[0] = 1;
		for(int j = 0; j < N; j++) {
			for(int i = 1; i <= K; i++) {
				if(i >= coin[j]) dp[i] += dp[i - coin[j]];
			}
		}
		System.out.println(dp[K]);
	}
}
