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
		for(int i = 1; i <= K; i++) {
			int min = 500000;
			for(int j = 0; j < N; j++) {
				if(i >= coin[j]) {
					min = Math.min(dp[i - coin[j]] + 1, min);
				}
			}
			dp[i] = min;
		}
		if(dp[K] < 0 || dp[K] > K) dp[K] = -1;
		System.out.println(dp[K]);
	}
}

// 동전 배열을 돌며 해당 동전을 쓰지않은 상태를 가정해야 하므로
// 동전 개수가 아닌 만들어야하는 합을 크기로 dp 배열을 만들어
// 동전을 쓰지않은 상태를 가정하고 최소를 구한다.