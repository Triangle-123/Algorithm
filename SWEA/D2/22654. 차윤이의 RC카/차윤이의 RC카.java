import java.util.Scanner;

public class Solution {
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tCase = sc.nextInt();
		for(int t = 1; t <= tCase; t++) {
			int N = sc.nextInt();
			char[][] board = new char[N][N];
			int[] start = null;
			for(int i = 0; i < N; i++) {
				char[] arr = sc.next().toCharArray();
				for(int j = 0; j < N; j++) {
					board[i][j] = arr[j];
					if(board[i][j] == 'X') start = new int[] {i, j};
				}
			}
			int Q = sc.nextInt();
			StringBuilder sb = new StringBuilder();
			sb.append("#" + t + " ");
			for(int i = 0; i < Q; i++) {
				int r = start[0];
				int c = start[1];
				int d = 0;
				int C = sc.nextInt();
				char[] command = sc.next().toCharArray();
				for(int j = 0; j < C; j++) {
					switch(command[j]) {
					case 'A':
						int nr = r + dr[d];
						int nc = c + dc[d];
						if(nr < N && nr >= 0 && nc < N && nc >= 0 && board[nr][nc] != 'T') {
							r = nr;
							c = nc;
						}
						break;
					case 'L':
						d--;
						if(d < 0) d += 4;
						break;
					case 'R':
						d = (d + 1) % 4;
						break;
					}
				}
				if(board[r][c] == 'Y') sb.append(1 + " ");
				else sb.append(0 + " ");
			}
			System.out.println(sb);
		}
	}
}
