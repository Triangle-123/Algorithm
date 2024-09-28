import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tCase = sc.nextInt();
		for(int t = 1; t <= tCase; t++) {
			int[] price = new int[4];
			for(int i = 0; i < 4; i++) {
				price[i] = sc.nextInt();
			}
			int[] plan = new int[14];
			for(int i = 1; i <= 12; i++) {
				plan[i] = sc.nextInt();
			}
			int[][] dp = new int[14][3];
			for(int i = 12; i >= 1; i--) {
				
				dp[i][0] = plan[i] * price[0];
				dp[i][1] = price[1];
				dp[i][2] = price[2];
			
				if(i <= 9) dp[i][2] += Math.min(Math.min(dp[i + 3][0], dp[i + 3][1]), dp[i + 3][2]);
				dp[i][0] += Math.min(Math.min(dp[i + 1][0], dp[i + 1][1]), dp[i + 1][2]);
				dp[i][1] += Math.min(Math.min(dp[i + 1][0], dp[i + 1][1]), dp[i + 1][2]);
			}
			
			int ans = Math.min(Math.min(dp[1][0], dp[1][1]), Math.min(dp[1][2], price[3]));
			System.out.println("#" + t + " " + ans);
		}
	}
}