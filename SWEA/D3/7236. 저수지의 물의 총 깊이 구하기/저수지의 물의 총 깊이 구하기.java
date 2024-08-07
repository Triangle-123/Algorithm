import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.FileInputStream;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
		int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};
		
		int tCase = Integer.parseInt(br.readLine());
		for(int t = 1; t <= tCase; t++) {
			int n = Integer.parseInt(br.readLine());
			String[][] board = new String[n][n];
			
			for(int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j++) {
					board[i][j] = st.nextToken();
				}
			}
			
			int max = 0;
			for(int r = 0; r < n; r++) {
				for(int c = 0; c < n; c++) {
					int cnt = 0;
					for(int d = 0; d < 8; d++) {
						int nr = r + dr[d];
						int nc = c + dc[d];
						
						if(nr >= 0 && nc >= 0 && nr < n && nc < n && board[nr][nc].equals("W")) {
							cnt++;
						}
					}
					if(cnt == 0) cnt++;
					max = Math.max(max, cnt);
				}
			}
			
			System.out.printf("#%d %d\n", t, max);
			
		}
	}
}