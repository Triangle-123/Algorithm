import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int[] weight = new int[N + 1];
		int[] value = new int[N + 1];
		
		for(int i = 1; i <= N; i++) {
			weight[i] = sc.nextInt();
			value[i] = sc.nextInt();
		}
		
		int[][] dp = new int[N + 1][K + 1]; // 물건의 개수와 용량 만큼의 dp배열 생성
		
		for(int i = 1; i <= N; i++) {
			
			for(int j = 0; j <= K; j++) {
				if(weight[i] <= j) { // 이 물건을 넣을 수 있다면
					
					// 이전값과 이 물건을 넣기전 최적해 + 이 물건의 값을 비교
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
				} else { // 이 물건을 넣을 수 없다면
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		
		System.out.println(dp[N][K]); // 이전값과 비교해 갱신하므로 최대값은 항상 끝에
	}
}
