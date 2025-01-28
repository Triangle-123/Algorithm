import java.util.*;
import java.io.*;

public class Main {
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static boolean[][][] visited;
	static char[][] maze;
	static int N, M;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		maze = new char[N][M];
		visited = new boolean[N][M][65];
		int[] start = {};
		for(int i = 0; i < N; i++) {
			maze[i] = br.readLine().toCharArray();
			for(int j = 0; j < M; j++) {
				if(maze[i][j] == '0') {
					start = new int[] {i, j};
				}
			}
		}
		
		escape(start);
		
	}

	private static void escape(int[] start) {
		Queue<int[]> q = new ArrayDeque<>();
		int set = 0;
		q.offer(new int[] {start[0], start[1], set});
		visited[start[0]][start[1]][set] = true;
		int cnt = 0;
		while(!q.isEmpty()) {
			int qSize = q.size();
			for(int i = 0; i < qSize; i++) {
				int[] poll = q.poll();
				int r = poll[0];
				int c = poll[1];
				int s = poll[2];
				if(maze[r][c] == '1') {
					System.out.println(cnt);
					return;
				} else if(maze[r][c] >= 'a' && maze[r][c] <= 'f') {
					s |= 1 << (maze[r][c] - 'a');
				} else if(maze[r][c] >= 'A' && maze[r][c] <= 'F') {
					if((s & (1 << (maze[r][c] - 'A'))) == 0) {
						continue;
					}
				}
				for(int d = 0; d < 4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					if(nr >= 0 && nr < N && nc >= 0 && nc < M && maze[nr][nc] != '#' && !visited[nr][nc][s]) {
						q.offer(new int[] {nr, nc, s});
						visited[nr][nc][s] = true;
					}
				}
			}
			cnt++;
		}
		System.out.println(-1);
		
	}
}
