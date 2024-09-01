import java.util.Scanner;

public class Main {
	static int N, M;
	static int cnt;
	static int[][] dp;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tCase = sc.nextInt();
		for(int t = 1; t <= tCase; t++) {
			N = sc.nextInt();
			M = sc.nextInt();
			dp = new int[M + 1][N + 1]; // DP 배열 선언하는 법.. 배워두자
			cnt = 0;
//			combi(0, 0);
			cnt = combi(M, N);
			System.out.println(cnt);
		}
		
	}

	
	
	private static int combi(int idx, int sidx) {
		int cnt = 0;
		
		// 조합의 성질 : nCr = n-1Cr-1 + n-1Cr
        //             nCn == nC0 == 1
		
		
		if(sidx == 0) return 1;
		if(idx == sidx) return 1;
		if(dp[idx][sidx] != 0) return dp[idx][sidx]; // 이게 DP, 해결한 값을 저장해놓고(메모이제이션) 이미 해결한 문제면 바로 돌아가는것(백트래킹)
		dp[idx][sidx] = combi(idx - 1, sidx - 1) + combi(idx - 1, sidx); 
		cnt += dp[idx][sidx];
		// 조합의 성질을 이용한 DP (성질 모르면 어떻게 풀어..?)
		
		return cnt;
		
//		if(sidx == N) {
//			cnt++;
//			return;
//		}
//		if(idx == M) return;
//		
//		combi(idx + 1, sidx + 1);
//		combi(idx + 1, sidx);
	}
}
