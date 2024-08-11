import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int c = sc.nextInt();
		int r = sc.nextInt();
		int k = sc.nextInt();
		
		int[][] arr = new int[r][c];
		
		int[] dr = {-1, 0, 1, 0};
		int[] dc = {0, 1, 0, -1};
		int d = 0;
		
		int num = 1;
		
		int rStart = arr.length;
		int cStart = 0;
		
		while(num <= r * c) {
			int nr = rStart + dr[d];
			int nc = cStart + dc[d];
			
			if(nr >= r || nc >= c || nr < 0 || nc < 0 || arr[nr][nc] != 0) {
				d = (d + 1) % 4;
			}
			else {
				rStart = nr;
				cStart = nc;
				arr[rStart][cStart] = num++;				
			}
		}
		
		boolean reserved = false;
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				if(arr[i][j] == k) {
					System.out.println((j + 1) + " " + (r - i));
					reserved = true;
				}
			}
		}
		
		if(!reserved) System.out.println(0);
		
	}
}