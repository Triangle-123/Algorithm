import java.util.*;
import java.io.*;

public class Main {
	
	static int[][] board;
	static boolean[][] visited;
	static int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
	static int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};
	static int M, N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		board = new int[M][N];
		visited = new boolean[M][N];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int cnt = 0;
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				if(board[i][j] == 1 && !visited[i][j]) {
					BFS(i, j);
					cnt++;
				}
			}
		}
		System.out.println(cnt);
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
				if(nr < M && nr >= 0 && nc < N && nc >= 0 && board[nr][nc] == 1 && !visited[nr][nc]) {
					q.offer(new int[] {nr, nc});
					visited[nr][nc] = true;
				}
			}
		}
	}
}
