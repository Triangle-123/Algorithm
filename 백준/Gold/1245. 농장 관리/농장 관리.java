import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int cnt;
	static int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
	static int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};
	static int[][] board;
	static boolean[][] visited;
	static Queue<Integer> q = new LinkedList<>();
	static boolean ismountain = true;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		board = new int[n][m];
		visited = new boolean[n][m];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(board[i][j] != 0 && !visited[i][j]) {
					BFS(i, j);					
				}
			}
		}
		System.out.println(cnt);
	}

	private static void BFS(int i, int j) {
		visited[i][j] = true;
		ismountain = true;
		q.clear();
		q.offer(i);
		q.offer(j);
		
		
		while(!q.isEmpty()) {
			int r = q.poll();
			int c = q.poll();
			
			for(int d = 0; d < 8; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(nr < board.length && nr >= 0 && nc < board[nr].length && nc >= 0 && board[nr][nc] != 0) {
					if(board[nr][nc] > board[r][c]) ismountain = false;
					else if(board[nr][nc] == board[r][c] && !visited[nr][nc]) {
						q.offer(nr);
						q.offer(nc);
						visited[nr][nc] = true;
					}
				}
			}
		}
		if(ismountain) cnt++;
	}
}
