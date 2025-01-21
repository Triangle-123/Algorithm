import java.util.*;
import java.io.*;

public class Main {

	static int[][] dr = { { -1, 1, 0, 0 }, { -1, 1 }, { -1, -1, 1, 1 }, { 1, -1, 1, 1 }, { -1, 1, 0, 0 } };
	static int[][] dc = { { 0, 0, -1, 1 }, { -1, 1 }, { -1, 1, -1, 1 }, { 1, 1, 1, -1 }, { 0, 0, -1, 1 } };
	static int N, M, minCount;
	static int[][] office;
	static List<int[]> cctvs;
	static boolean[][][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		office = new int[N][M];
		cctvs = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				office[i][j] = Integer.parseInt(st.nextToken());
				if (office[i][j] > 0 && office[i][j] < 6) {
					cctvs.add(new int[] { i, j });
				}
			}
		}

		visited = new boolean[N][M][cctvs.size()];

		minCount = Integer.MAX_VALUE;

		DFS(0);
		System.out.println(minCount);
	}

	private static void DFS(int idx) {

		if (idx == cctvs.size()) {
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (office[i][j] == 0) {
						cnt++;
					}
				}
			}
			minCount = Math.min(minCount, cnt);
			return;
		}

		int[] cctv = cctvs.get(idx);
		int r = cctv[0];
		int c = cctv[1];
		switch (office[cctv[0]][cctv[1]]) {
		case 1: {
			for (int d = 0; d < dr[0].length; d++) {
				int nr = r + dr[0][d];
				int nc = c + dc[0][d];
				while (nr < N && nr >= 0 && nc < M && nc >= 0 && office[nr][nc] != 6) {
					if (office[nr][nc] == 0 && !visited[nr][nc][idx]) {
						office[nr][nc] = -1;
						visited[nr][nc][idx] = true;
					}
					nr += dr[0][d];
					nc += dc[0][d];
				}
				DFS(idx + 1);
				nr = r + dr[0][d];
				nc = c + dc[0][d];
				while (nr < N && nr >= 0 && nc < M && nc >= 0 && office[nr][nc] != 6) {
					if (office[nr][nc] == -1 && visited[nr][nc][idx]) {
						office[nr][nc] = 0;
						visited[nr][nc][idx] = false;
					}
					nr += dr[0][d];
					nc += dc[0][d];
				}
			}
			break;
		}
		case 2: {
			for (int d = 0; d < dr[1].length; d++) {
				int nr = r + dr[1][d];
				while (nr < N && nr >= 0 && office[nr][c] != 6) {
					if (office[nr][c] == 0 && !visited[nr][c][idx]) {
						office[nr][c] = -1;
						visited[nr][c][idx] = true;
					}
					nr += dr[1][d];
				}
			}
			DFS(idx + 1);
			for (int d = 0; d < dr[1].length; d++) {
				int nr = r + dr[1][d];
				while (nr < N && nr >= 0 && office[nr][c] != 6) {
					if (office[nr][c] == -1 && visited[nr][c][idx]) {
						office[nr][c] = 0;
						visited[nr][c][idx] = false;
					}
					
					nr += dr[1][d];
				}
			}
			for (int d = 0; d < dr[1].length; d++) {
				int nc = c + dc[1][d];
				while (nc < M && nc >= 0 && office[r][nc] != 6) {
					if (office[r][nc] == 0 && !visited[r][nc][idx]) {
						office[r][nc] = -1;						
						visited[r][nc][idx] = true;
					}
					nc += dc[1][d];
				}
			}
			DFS(idx + 1);
			for (int d = 0; d < dr[1].length; d++) {
				int nc = c + dc[1][d];
				while (nc < M && nc >= 0 && office[r][nc] != 6) {
					if (office[r][nc] == -1 && visited[r][nc][idx]) {
						office[r][nc] = 0;
						visited[r][nc][idx] = false;
					}
					nc += dc[1][d];
				}
			}
			break;
		}
		case 3: {
			for(int d = 0; d < dr[2].length; d++) {
				int nr = r + dr[2][d];
				while (nr < N && nr >= 0 && office[nr][c] != 6) {
					if (office[nr][c] == 0 && !visited[nr][c][idx]) {
						office[nr][c] = -1;
						visited[nr][c][idx] = true;
					}
					nr += dr[2][d];
				}
				int nc = c + dc[2][d];
				while (nc < M && nc >= 0 && office[r][nc] != 6) {
					if (office[r][nc] == 0 && !visited[r][nc][idx]) {
						office[r][nc] = -1;						
						visited[r][nc][idx] = true;
					}
					nc += dc[2][d];
				}
				DFS(idx + 1);
				nr = r + dr[2][d];
				while (nr < N && nr >= 0 && office[nr][c] != 6) {
					if (office[nr][c] == -1 && visited[nr][c][idx]) {
						office[nr][c] = 0;
						visited[nr][c][idx] = false;
					}
					
					nr += dr[2][d];
				}
				nc = c + dc[2][d];
				while (nc < M && nc >= 0 && office[r][nc] != 6) {
					if (office[r][nc] == -1 && visited[r][nc][idx]) {
						office[r][nc] = 0;
						visited[r][nc][idx] = false;
					}
					nc += dc[2][d];
				}
			}
			
			break;
		}
		case 4: {
			for(int d = 0; d < dr[3].length; d++) {
				if(d < 2) {
					int nr = r + dr[3][d];
					while (nr < N && nr >= 0 && office[nr][c] != 6) {
						if (office[nr][c] == 0 && !visited[nr][c][idx]) {
							office[nr][c] = -1;
							visited[nr][c][idx] = true;
						}
						nr += dr[3][d];
					}
					int nc = c + dc[3][d];
					while (nc < M && nc >= 0 && office[r][nc] != 6) {
						if (office[r][nc] == 0 && !visited[r][nc][idx]) {
							office[r][nc] = -1;						
							visited[r][nc][idx] = true;
						}
						nc += dc[3][d];
					}
					nc = c - dc[3][d];
					while (nc < M && nc >= 0 && office[r][nc] != 6) {
						if (office[r][nc] == 0 && !visited[r][nc][idx]) {
							office[r][nc] = -1;						
							visited[r][nc][idx] = true;
						}
						nc -= dc[3][d];
					}
					DFS(idx + 1);
					nr = r + dr[3][d];
					while (nr < N && nr >= 0 && office[nr][c] != 6) {
						if (office[nr][c] == -1 && visited[nr][c][idx]) {
							office[nr][c] = 0;
							visited[nr][c][idx] = false;
						}
						nr += dr[3][d];
					}
					nc = c + dc[3][d];
					while (nc < M && nc >= 0 && office[r][nc] != 6) {
						if (office[r][nc] == -1 && visited[r][nc][idx]) {
							office[r][nc] = 0;						
							visited[r][nc][idx] = false;
						}
						nc += dc[3][d];
					}
					nc = c - dc[3][d];
					while (nc < M && nc >= 0 && office[r][nc] != 6) {
						if (office[r][nc] == -1 && visited[r][nc][idx]) {
							office[r][nc] = 0;						
							visited[r][nc][idx] = false;
						}
						nc -= dc[3][d];
					}
				}
				else {
					int nc = c + dc[3][d];
					while (nc < M && nc >= 0 && office[r][nc] != 6) {
						if (office[r][nc] == 0 && !visited[r][nc][idx]) {
							office[r][nc] = -1;						
							visited[r][nc][idx] = true;
						}
						nc += dc[3][d];
					}
					int nr = r + dr[3][d];
					while (nr < N && nr >= 0 && office[nr][c] != 6) {
						if (office[nr][c] == 0 && !visited[nr][c][idx]) {
							office[nr][c] = -1;
							visited[nr][c][idx] = true;
						}
						nr += dr[3][d];
					}
					nr = r - dr[3][d];
					while (nr < N && nr >= 0 && office[nr][c] != 6) {
						if (office[nr][c] == 0 && !visited[nr][c][idx]) {
							office[nr][c] = -1;
							visited[nr][c][idx] = true;
						}
						nr -= dr[3][d];
					}
					DFS(idx + 1);
					nc = c + dc[3][d];
					while (nc < M && nc >= 0 && office[r][nc] != 6) {
						if (office[r][nc] == -1 && visited[r][nc][idx]) {
							office[r][nc] = 0;						
							visited[r][nc][idx] = false;
						}
						nc += dc[3][d];
					}
					nr = r + dr[3][d];
					while (nr < N && nr >= 0 && office[nr][c] != 6) {
						if (office[nr][c] == -1 && visited[nr][c][idx]) {
							office[nr][c] = 0;
							visited[nr][c][idx] = false;
						}
						nr += dr[3][d];
					}
					nr = r - dr[3][d];
					while (nr < N && nr >= 0 && office[nr][c] != 6) {
						if (office[nr][c] == -1 && visited[nr][c][idx]) {
							office[nr][c] = 0;
							visited[nr][c][idx] = false;
						}
						nr -= dr[3][d];
					}
				}
			}
			break;
		}
		case 5: {
			for (int d = 0; d < dr[4].length; d++) {
				int nr = r + dr[4][d];
				int nc = c + dc[4][d];
				while (nr < N && nr >= 0 && nc < M && nc >= 0 && office[nr][nc] != 6) {
					if (office[nr][nc] == 0 && !visited[nr][nc][idx]) {
						office[nr][nc] = -1;
						visited[nr][nc][idx] = true;
					}
					nr += dr[4][d];
					nc += dc[4][d];
				}
			}
			DFS(idx + 1);
			for (int d = 0; d < dr[4].length; d++) {
				int nr = r + dr[4][d];
				int nc = c + dc[4][d];
				while (nr < N && nr >= 0 && nc < M && nc >= 0 && office[nr][nc] != 6) {
					if (office[nr][nc] == -1 && visited[nr][nc][idx]) {
						office[nr][nc] = 0;
						visited[nr][nc][idx] = false;
					}
					nr += dr[4][d];
					nc += dc[4][d];
				}
			}
			break;
		}
		}

	}
}
