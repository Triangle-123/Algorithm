import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tCase = sc.nextInt();
		
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		
		int[] tr = {-1, -1, 1, 1};
		int[] tc = {-1, 1, -1, 1};
		
		for(int t = 1; t <= tCase; t++) {
			int n = sc.nextInt();
			int m = sc.nextInt() - 1;
			int[][] arr = new int[n][n];
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			int dSum = 0;
			int tSum = 0;
			int max = 0;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					dSum = arr[i][j];
					tSum = arr[i][j];
					for(int k = 1; k <= m; k++) {
						for(int d = 0; d < 4; d++) {
							int nr = i + (dr[d] * k);
							int nc = j + (dc[d] * k);
							
							int nr2 = i + (tr[d] * k);
							int nc2 = j + (tc[d] * k);
							
							if(nr < n && nc < n && nr >= 0 && nc >= 0) {
								dSum += arr[nr][nc];
							}
							
							if(nr2 < n && nc2 < n && nr2 >= 0 && nc2 >= 0) {
								tSum += arr[nr2][nc2];
							}
						}
					}
					max = Math.max(max, Math.max(dSum, tSum));
						
				}
			}
			
			System.out.println("#" + t + " " + max);
			
		}
	}
}