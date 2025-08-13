import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tCase = 0; tCase < T; tCase++) {
			int N = Integer.parseInt(br.readLine());
			int[][] weight = new int[2][N];
			int[][] dp = new int[2][N];
			for(int j = 0; j < 2; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int i = 0; i < N; i++) {
					weight[j][i] = Integer.parseInt(st.nextToken());
				}
			}
			for(int i = 0; i < N; i++) {
				dp[0][i] = weight[0][i];
				dp[1][i] = weight[1][i];
				int max1 = 0;
				int max2 = 0;
				if(i >= 1) {
					max1 = Math.max(dp[0][i - 1], max1);
					max2 = Math.max(dp[1][i - 1], max2);
				}
				if(i >= 2) {
					max1 = Math.max(dp[0][i - 2], max1);
					max2 = Math.max(dp[1][i - 2], max2);
				}
				dp[0][i] += max2;
				dp[1][i] += max1;
			}
			
			System.out.println(Math.max(dp[1][N - 1], dp[0][N - 1]));
		}
	}
}
// 스티커의 끝에서부터
// 어떤 위치로 부터 해당 위치로 올 수 있는지 판별
// 왼쪽 대각선 위(또는 아래) 아니면 자신의 두칸 왼쪽에서 올 수 있으나
// 자신의 두칸 왼쪽을 선택한 경로는 왼쪽 대각선 위에서 이미 최대값을 계산할때 잡힘 -> 이게 맹점
// 그러므로 왼쪽 대각선과 두칸 왼쪽을 고르지 않은 경우인 -1행 -2열 스티커를 뗀 경우와 비교
// dp[n][i]라면
// dp[n - 1][i - 2] vs dp[n - 1][i - 1]