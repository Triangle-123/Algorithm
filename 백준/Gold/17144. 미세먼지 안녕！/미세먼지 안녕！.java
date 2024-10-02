import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int R, C, T;
	static int[][] board, air, after;
	static Queue<int[]> q;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int[][] ar = {{-1, 0, 1, 0}, {1, 0, -1, 0}};
	static int[][] ac = {{0, 1, 0,-1}, {0, 1, 0, -1}};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		T = sc.nextInt();
		
		board = new int[R][C];
		air = new int[2][2];
		after = new int[R][C];
 		q = new ArrayDeque<>();
		int idx = 0;
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				int num = sc.nextInt();
				board[i][j] = num;
				if(num == -1) {
					air[idx++] = new int[] {i, j};
				} else if(num != 0) {
					q.offer(new int[] {i, j});
				}
			}
		}
		BFS();
		int sum = 0;
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(board[i][j] > 0) sum += board[i][j];
			}
		}
		System.out.println(sum);
	}

	private static void BFS() {
		int time = 0;
		while(!q.isEmpty()) {
			if(time == T) return;
			int qSize = q.size();
			for(int i = 0; i < qSize; i++) {
				int[] poll = q.poll();
				int r = poll[0];
				int c = poll[1];
				after[r][c] += board[r][c];
				if(board[r][c] < 5) continue;
				for(int d = 0; d < 4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					
					if(nr < R && nr >= 0 && nc < C && nc >= 0 && board[nr][nc] != -1) {
						int dust = board[r][c] / 5;
						after[nr][nc] += dust;
						after[r][c] -= dust;
					}
				}
			}
			for(int i = 0; i < 2; i++) {
				int d = 0;
				int r = air[i][0];
				int c = air[i][1];
				after[r][c] = -1;
				while(true) {
					int nr = r + ar[i][d];
					int nc = c + ac[i][d];
					if(nr >= R || nr < 0 || nc >= C || nc < 0 || (i == 0 && nr == air[i][0] + 1) || (i == 1 && nr == air[i][0] - 1)) {
						d = (d + 1) % 4; 
					} else {
						r = nr;
						c = nc;
						if(after[r][c] == -1) break;
						if(after[r][c] > 0) {
							if(after[r - ar[i][d]][c - ac[i][d]] == -1) {
								after[r][c] = 0;
							} else {
								after[r - ar[i][d]][c - ac[i][d]] += after[r][c];
								after[r][c] = 0;
							}
						}
					}
				}
			}
			for(int i = 0; i < R; i++) {
				for(int j = 0; j < C; j++) {
					board[i][j] = after[i][j];
					after[i][j] = 0;
					if(board[i][j] > 0) {
						q.offer(new int[] {i, j});
					}
				}
			}
			time++;
		}
		
	}
}