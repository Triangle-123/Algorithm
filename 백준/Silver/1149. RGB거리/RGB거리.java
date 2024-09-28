import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] RGB = new int[N + 2][3];
		for(int i = 1; i <= N; i++) {
			for(int j = 0; j < 3; j++) {
				RGB[i][j] = sc.nextInt();
			}
		}
		
		int[][] dp = new int[N + 2][3];
		
		for(int i = 1; i <= N; i++) {
			
			for(int j = 0; j < 3; j++) {
				dp[i][j] = RGB[i][j];
				int min = Integer.MAX_VALUE;
				for(int k = 0; k < 3; k++) {
					if(k == j) continue;
					min = Math.min(min, dp[i - 1][k]);
				}
				dp[i][j] += min;
			}		
		}
		
		int ans = Integer.MAX_VALUE;
		for(int j = 0; j < 3; j++) {
			ans = Math.min(dp[N][j], ans);
		}
		System.out.println(ans);
	}
}
// 내 현재 값에는 이전에 넣을 수 있는 최소값을 넣으면 된다.
// 한 가지의 경우만 구하려 애를 쓰면 풀리지 않음
// 세 가지 모두 구해버리면 됨