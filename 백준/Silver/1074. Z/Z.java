import java.util.Scanner;

public class Main {
	
	static int N, row, col;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = (int)Math.pow(2, sc.nextInt());
		row = sc.nextInt();
		col = sc.nextInt();
		
		int start = 0;
		
		Z(0, 0, N, start);
	}

	static int[] dr = {0, 0, 1, 1};
	static int[] dc = {0, 1, 0, 1};
	
	private static void Z(int r, int c, int n, int start) {
		
//		if(row < r || col < c) return;
		if(n == 1) {
			for(int i = r; i < r + n; i++) {
				for(int j = c; j < c + n; j++) {
					if(r == row && c == col) { 
						System.out.println(start);
						System.exit(0);
					}
					start++;
				}
			}
			return;
		}
		
		int s = start;
		for(int d = 0; d < 4; d++) {
			int nr = r + (dr[d] * (n / 2));
			int nc = c + (dc[d] * (n / 2));	
			if(nr <= row && nc <= col && nr + n / 2 >= row && nc + n / 2 >= col) {
				Z(nr, nc, n / 2, s);				
			}
			s += (n / 2) * (n / 2);
		}
		
	}	
}
