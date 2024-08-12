import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int c = sc.nextInt() + 1;
		int r = sc.nextInt() + 1;
		
		int[][] arr = new int[r][c];
		
		int n = sc.nextInt();
		int me = n + 1;
		int row = 0;
		int col = 0;
		int[] dr_clock = null;
		int[] dc_clock = null;
		for(int i = 1; i <= n + 1; i++) {
			int direction = sc.nextInt();
			int distance = sc.nextInt();
			
			switch(direction) {
			case 1:
				arr[0][distance] = i;
				if(i == me) {
					row = 0;
					col = distance;
					dr_clock = new int[] {0, 1, 0, -1};
					dc_clock = new int[] {1, 0, -1, 0};
				}
				break;
			case 2:
				arr[r - 1][distance] = i;
				if(i == me) {
					row = r - 1;
					col = distance;
					dr_clock = new int[] {0, -1, 0, 1};
					dc_clock = new int[] {-1, 0, 1, 0};
				}
				break;
			case 3:
				arr[distance][0] = i;
				if(i == me) {
					row = distance;
					col = 0;
					dr_clock = new int[] {-1, 0, 1, 0};
					dc_clock = new int[] {0, 1, 0, -1};
				}
				break;
			case 4:
				arr[distance][c - 1] = i;
				if(i == me) {
					row = distance;
					col = c - 1;
					dr_clock = new int[] {1, 0, -1, 0};
					dc_clock = new int[] {0, -1, 0, 1};
				}
				break;
			}
		}
		
		int cnt_clock = 0;
		int cnt_anti = 0;
		int min = 0;
		int sum = 0;
		int d = 0;
		
		int dongR = row;
		int	dongC = col;
		
		for(int i = 1; i <= n; i++) {
			while(true) {
				int nr = dongR + dr_clock[d];
				int nc = dongC + dc_clock[d];
				
				if(nr < 0 || nc < 0 || nr >= r || nc >= c) {
					d = (d + 1) % 4;
				} else {
					cnt_clock++;
					dongR = nr;
					dongC = nc;
				}
				
				if(nr >= 0 && nc >= 0 && nr < r && nc < c && arr[nr][nc] == i) {
					break;
				}
				
			}
			
			dongR = row;
			dongC = col;
			d = 0;
			while(true) {
				int nr = dongR - dr_clock[d];
				int nc = dongC - dc_clock[d];
				
				if(nr < 0 || nc < 0 || nr >= r || nc >= c) {
					d--;
					if(d < 0) d = 3;
				} else {
					cnt_anti++;
					dongR = nr;
					dongC = nc;
				}
				

				if(nr >= 0 && nc >= 0 && nr < r && nc < c && arr[nr][nc] == i) {
					break;
				}
			}
			
			sum += Math.min(cnt_anti, cnt_clock);
			
			cnt_clock = 0;
			cnt_anti = 0;
			dongR = row;
			dongC = col;
			d = 0;
			
		}
		
		System.out.println(sum);
	}
}
