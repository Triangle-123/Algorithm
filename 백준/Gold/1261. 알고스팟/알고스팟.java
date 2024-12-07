import java.util.*;
import java.io.*;

public class Main {
	
	static int M, N;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static char[][] board;
	static int[][] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		board = new char[N][M];
		visited = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			board[i] = br.readLine().toCharArray();
			for(int j = 0; j < M; j++) {
				visited[i][j] = -1;			
			}
		}
		
		BFS(0, 0);
		System.out.println(visited[N - 1][M - 1]);
	}

	private static void BFS(int i, int j) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {i, j});
		visited[i][j] = 0;
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			int r = poll[0];
			int c = poll[1];
			for(int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(nr < N && nr >= 0 && nc < M && nc >= 0) {
					if(board[nr][nc] == '1') {
						if(visited[nr][nc] == -1 || visited[nr][nc] > visited[r][c] + 1) {
							visited[nr][nc] = visited[r][c] + 1;
							q.offer(new int[] {nr, nc});
						}
					} else {
						if(visited[nr][nc] == -1 || visited[nr][nc] > visited[r][c]) {
							visited[nr][nc] = visited[r][c];
							q.offer(new int[] {nr, nc});		
						}
					}
				}
			}
		}
		
	}
}
