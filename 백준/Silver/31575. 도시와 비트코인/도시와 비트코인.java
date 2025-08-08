import java.util.*;
import java.io.*;

public class Main {
	
	static int[] dr = {1, 0};
	static int[] dc = {0, 1};
	static int[][] board;
	static boolean[][] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		visited = new boolean[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		BFS(0, 0);
	}

	private static void BFS(int i, int j) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {i, j});
		visited[i][j] = true;
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			int r = poll[0];
			int c = poll[1];
			if(r == board.length - 1 && c == board[r].length - 1) {
				System.out.println("Yes");
				return;
			}
			for(int d = 0; d < 2; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if(nr < board.length && nc < board[nr].length && board[nr][nc] == 1 && !visited[nr][nc]) {
					q.offer(new int[] {nr, nc});
					visited[nr][nc] = true;
				}
			}
		}
        System.out.println("No");
		
	}
}
