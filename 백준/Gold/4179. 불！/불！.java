import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static boolean[][] visited;
	static Queue<int[]> q = new ArrayDeque<>();
	static int R, C;
	static char[][] board;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		board = new char[R][C];
		visited = new boolean[R][C];
		for(int i = 0; i < R; i++) {
			board[i] = sc.next().toCharArray();
		}
		int[] start = null;
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(board[i][j] == 'J') {
					start = new int[] {i, j};
				} else if(board[i][j] == 'F') {
					q.offer(new int[] {i, j});
				}
			}
		}
		BFS(start);
	}

	private static void BFS(int[] start) {
		int x = start[0];
		int y = start[1];
		visited[x][y] = true;
		q.offer(start);
		int time = 0;
		while(!q.isEmpty()) {
			int qSize = q.size();
			for(int i = 0; i < qSize; i++) {
				int[] poll = q.poll();
				int r = poll[0];
				int c = poll[1];
				if((r == 0 || r == R - 1 || c == 0 || c == C - 1) && visited[r][c]) {
					System.out.println(time + 1);
					return;
				}
				for(int d = 0; d < 4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					if(nr < R && nr >= 0 && nc < C && nc >= 0) {
						if(board[r][c] == 'F' && board[nr][nc] != '#' && board[nr][nc] != 'F' && board[nr][nc] != 'N') {
							board[nr][nc] = 'N';
							q.offer(new int[] {nr, nc});
						} else if(board[r][c] != 'F' && !visited[nr][nc] && board[nr][nc] != '#' && board[nr][nc] != 'F' && board[nr][nc] != 'N') {
							board[nr][nc] = 'J';
							visited[nr][nc] = true;
							q.offer(new int[] {nr, nc});
						}
						
					}
				}
			}
			for(int i = 0; i < R; i++) {
				for(int j = 0; j < C; j++) {
					if(board[i][j] == 'N') {
						board[i][j] = 'F';
					}
				}
			}
			time++;
		}
		System.out.println("IMPOSSIBLE");
	}
}
