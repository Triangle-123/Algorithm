import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int[][] board;
	static boolean visited[][];
	static int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
	static int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};
	static int N, M;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		
		while(N != 0) {
			board = new int[N][M];
			visited = new boolean[N][M];
			int cnt = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					board[i][j] = sc.nextInt();
				}
			}
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(!visited[i][j] && board[i][j] == 1) {
						BFS(i, j);
						cnt++;
					}
				}
			}
			System.out.println(cnt);
			M = sc.nextInt();
			N = sc.nextInt();
		}
	}

	private static void BFS(int i, int j) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {i, j});
		visited[i][j] = true;
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			int r = poll[0];
			int c = poll[1];
			
			for(int d = 0; d < 8; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(nr < N && nr >= 0 && nc < M && nc >= 0 && !visited[nr][nc] && board[nr][nc] == 1) {
					visited[nr][nc] = true;
					q.offer(new int[] {nr, nc});
				}
			}
			
		}
		
	}
}
