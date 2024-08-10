import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		String[][] arr = new String[n][m];
 		
		for(int i = 0; i < n; i++) {
			arr[i] = br.readLine().split("");
		}
		
		int wCnt = 0;
		int bCnt = 0;
		int minCnt = 30000;
		for(int i = 0; i <= n - 8; i++) {
			for(int j = 0; j <= m - 8; j++) {
				for(int k = 0; k < 8; k++) {
					for(int l = 0; l < 8; l++) {
						if(k % 2 == 0) { // "W"가 가장 왼쪽 위일때
							if(l % 2 == 0) {
								if(!arr[i + k][j + l].equals("W")) wCnt++;
							}
							else {
								if(!arr[i + k][j + l].equals("B")) wCnt++;
							}
						}
						else {
							if(l % 2 == 0) {
								if(!arr[i + k][j + l].equals("B")) wCnt++;
							}
							else {
								if(!arr[i + k][j + l].equals("W")) wCnt++;
							}
						}
					}
				}
				
				for(int k = 0; k < 8; k++) {
					for(int l = 0; l < 8; l++) {
						if(k % 2 == 0) { // "B"가 가장 왼쪽 위일때
							if(l % 2 == 0) {
								if(!arr[i + k][j + l].equals("B")) bCnt++;
							}
							else {
								if(!arr[i + k][j + l].equals("W")) bCnt++;
							}
						}
						else {
							if(l % 2 == 0) {
								if(!arr[i + k][j + l].equals("W")) bCnt++;
							}
							else {
								if(!arr[i + k][j + l].equals("B")) bCnt++;
							}
						}
					}
				}
				
				minCnt = Math.min(minCnt, Math.min(wCnt, bCnt));
				wCnt = 0;
				bCnt = 0;
			}
		}
		
		System.out.println(minCnt);
	}
}