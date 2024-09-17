import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int N, M, K, max;
	static int[][] board;
	static boolean[][] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static Queue<Integer> q = new ArrayDeque<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		
		board = new int[N + 1][M + 1];
		visited = new boolean[N + 1][M + 1];
		for(int i = 0; i < K; i++) {
			board[sc.nextInt()][sc.nextInt()] = 1;
		}
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= M; j++) {
				if(!visited[i][j] && board[i][j] == 1) BFS(i, j);
			}
		}
		System.out.println(max);
	}

	private static void BFS(int i, int j) {
		visited[i][j] = true;
		q.clear();
		q.offer(i);
		q.offer(j);
		
		int cnt = 1;
		
		while(!q.isEmpty()) {
			int r = q.poll();
			int c = q.poll();
			
			for(int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(nr <= N && nr >= 0 && nc <= M && nc >= 0 && !visited[nr][nc] && board[nr][nc] == 1) {
					visited[nr][nc] = true;
					q.offer(nr);
					q.offer(nc);
					cnt++;
				}
			}
		}
		max = Math.max(max, cnt);
	}
}
