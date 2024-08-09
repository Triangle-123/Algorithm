import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tCase = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= tCase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			String[][] arr = new String[n][m];
			
			for(int i = 0; i < n; i++) {
				arr[i] = br.readLine().split("");
			}
			
			int cnt = 0;
		
			int wStart = 1;
			int bStart = 1;
			int rStart = 2;
			
			int wCnt = 0;
			int bCnt = 0;
			int rCnt = 0;
			int maxCnt = 0;
			
			for(int r = 0; bStart + r < n - 1; r++) {
				for(int i = 1; i < n; i++) {
					wCnt = 0;
					bCnt = 0;
					rCnt = 0;
					for(int j = wStart; j < bStart && j < n - 2; j++) {
						for(int p = 0; p < m; p++) {
							if(arr[j][p].equals("W")) {
								wCnt++;
							} 
						}
					}
					for(int k = bStart; k < rStart + r && k < n - 1; k++) {
						for(int p = 0; p < m; p++) {
							if(arr[k][p].equals("B")) {
								bCnt++;
							} 
						}
					}
					for(int l = rStart + r; l < n - 1; l++) {
						for(int p = 0; p < m; p++) {
							if(arr[l][p].equals("R")) {
								rCnt++;
							} 
						}
					}
					
					maxCnt = Math.max(maxCnt, bCnt + wCnt + rCnt);
					
					bStart++;
					rStart++;
				}
				bStart = 1;
				rStart = 2;
			}
			
			for(int i = n - 1; i >= 0; i--) {
				wCnt = 0;
				bCnt = 0;
				rCnt = 0;
				for(int j = 0; j < m; j++) {
					switch(arr[i][j]) {
					case "W":
						wCnt++;
						break;
					case "B":
						bCnt++;
						break;
					case "R":
						rCnt++;
						break;
					}
				}
				
				if(i == 0) {
					cnt += m - wCnt;
				} else if(i == n - 1) {
					cnt += m - rCnt;
				}
			}
			
			cnt += ((n - 2) * m) - maxCnt;
			System.out.println("#" + t + " " + cnt);

		}
	}
}
