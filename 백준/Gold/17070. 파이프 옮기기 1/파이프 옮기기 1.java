import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int N;
	static int[][] board;
	static int[] dr = {0, 1, 1};
	static int[] dc = {1, 0, 1};
	static int cnt = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		board = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		
		DFS(0, 1, 0);
		System.out.println(cnt);
	}
	private static void DFS(int r, int c, int state) {
		
		if(r == N - 1 && c == N - 1) {
			cnt++;
			return;
		}
		
		boolean[] posible = new boolean[3];
		Arrays.fill(posible, true);
		for(int d = 0; d < 3; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(!(nr < N && nc < N && board[nr][nc] == 0)) {
				posible[d] = false;
				posible[2] = false;
			}
		}
		switch(state) {
		case 0:
			for(int d = 0; d < 3; d++) {
				if(posible[d] && d != 1) {
					DFS(r + dr[d], c + dc[d], d);
				}
			}
			break;
		case 1:
			for(int d = 0; d < 3; d++) {
				if(posible[d] && d != 0) {
					DFS(r + dr[d], c + dc[d], d);
				}
			}
			break;
		case 2:
			for(int d = 0; d < 3; d++) {
				if(posible[d]) {
					DFS(r + dr[d], c + dc[d], d);
				}
			}
			break;
		}
		
	}
}
