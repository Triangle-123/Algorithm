import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] dp = new int[N + 1];
		dp[0] = 1;
		dp[1] = 3;
		for(int i = 2; i <= N; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 1]) % 9901;
		}
		System.out.println(dp[N] % 9901);
	}
}
// 경우의 수를 따져보도록 하자..
// 사자를 안넣었을 때 : 1
// N = 1 : 3
// N = 2 : 7
// N = 3 : 17
// N = 4 : 41
// N = 5 : 99??