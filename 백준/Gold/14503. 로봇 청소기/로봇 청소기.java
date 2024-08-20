import java.util.Scanner;

public class Main {
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int r = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();
		
		int[][] arr = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		int cnt = 0;
		boolean notCleaned = false;
		while(arr[r][c] != 1) {
			if(arr[r][c] == 0) {
				arr[r][c] = 2;
				cnt++;
			}
			
			for(int delta = 0; delta < 4; delta++) {
				int nr = r + dr[delta];
				int nc = c + dc[delta];
				
				if(arr[nr][nc] == 0) {
					notCleaned = true;
				}
			}
			
			if(notCleaned) {
				while(true) {
					d--;
					if(d < 0) d = 3;
					int nr = r + dr[d];
					int nc = c + dc[d];
					
					if(arr[nr][nc] == 0) {
						r = nr;
						c = nc;
						break;
					}
				}
			} else {
				r = r - dr[d];
				c = c - dc[d];
			}
			
			notCleaned = false;
		}
		
		System.out.println(cnt);
		
	}
}
