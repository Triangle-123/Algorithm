import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int R, C;
	static char[][] board;
	static boolean[][] visited;
	static Queue<int[]> q = new ArrayDeque<>();
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
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
				if(board[i][j] == '*') {
					q.offer(new int[] {i, j});
				}
				if(board[i][j] == 'S') {
					start = new int[] {i, j};
					break;
				}
			}
		}
		BFS(start);
	}

	private static void BFS(int[] start) {
		int i = start[0];
		int j = start[1];
		visited[i][j] = true;
		q.offer(start);
		int time = 1;
		while(!q.isEmpty()) {
			int qSize = q.size();
			for(int k = 0; k < qSize; k++) {
				int[] poll = q.poll();
				int r = poll[0];
				int c = poll[1];
				for(int d = 0; d < 4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					
					if(nr < R && nr >= 0 && nc < C && nc >= 0) {
						if(board[r][c] == '*' && (board[nr][nc] == '.' || board[nr][nc] == 'S')) {
							if(board[nr][nc] == '.') board[nr][nc] = '*';
							visited[nr][nc] = true;
							q.offer(new int[] {nr, nc});
						}
						else if(board[r][c] != '*' && !visited[nr][nc] && board[nr][nc] != 'X' && board[nr][nc] != '*') {
							if(board[nr][nc] == 'D') {
								System.out.println(time);
								return;
							}
							visited[nr][nc] = true;
							board[nr][nc] = 'S';
							q.offer(new int[] {nr, nc});
						}
					}
				}
			}
			time++;
		}
		System.out.println("KAKTUS");
	}
}
