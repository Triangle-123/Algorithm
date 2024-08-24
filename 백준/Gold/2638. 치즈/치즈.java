import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static boolean[][] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int[][] board;
	static int n, m;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		board = new int[n][m];
		visited = new boolean[n][m];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				int num = sc.nextInt();
				board[i][j] = num == 1 ? 2 : 0;
			}
		}
		int hour = 0;
		
		while(true) {
			int cnt = 0;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if(board[i][j] > 0) {
						cnt++;
						board[i][j] = 2;
					}
				}
			}
			if(cnt == 0) break;
			else {
				BFS(0, 0);
				for(int i = 0; i < n; i++) {
					Arrays.fill(visited[i], false);
				}
				hour++;
			}
		}
		System.out.println(hour);
		
	}

	static Queue<Integer> q = new LinkedList<>();
	static void BFS(int i, int j) {
		visited[i][j] = true;
		q.clear();
		q.offer(i);
		q.offer(j);
		
		while(!q.isEmpty()) {
			int r = q.poll();
			int c = q.poll();
			for(int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if(nr < n && nc < m && nr >= 0 && nc >= 0 && !visited[nr][nc]) {
					if(board[nr][nc] > 0) {
						board[nr][nc]--;
						if(board[nr][nc] == 0) {
							visited[nr][nc] = true;
						}
					} else {
						q.offer(nr);
						q.offer(nc);
						visited[nr][nc] = true;					
					}
				}
			}
		}
		
	}
}
