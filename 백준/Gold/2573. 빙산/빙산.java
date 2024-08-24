import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] arr;
	static boolean[][] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		visited = new boolean[n][m];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int year = 0;
		StringBuilder sb = new StringBuilder();
		out: while(true) {
			int cnt = 0;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if(arr[i][j] == 0 || visited[i][j]) continue;
					BFS(i, j);
					cnt++;
					if(cnt > 1) break out;
				}
			}
			if(cnt == 0) {
				sb.append("0");
				break out;
			}
			year++;
			for(int i = 0; i < n; i++) {
				Arrays.fill(visited[i], false);
			}
		}
		if(sb.length() == 0) sb.append(year);
		System.out.println(sb);
	}
	
	static Queue<Integer> q = new LinkedList<>();
	
	static void BFS(int i, int j) {
		visited[i][j] = true;
		q.offer(i);
		q.offer(j);
		
		while(!q.isEmpty()) {
			int r = q.poll();
			int c = q.poll();
			for(int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(nr < arr.length && nr >= 0 && nc < arr[nr].length && nc >= 0 && !visited[nr][nc]) {
					if(arr[nr][nc] == 0) {
						arr[r][c] = arr[r][c] - 1 < 0 ? 0 : arr[r][c] - 1;
					}
					else {
						q.offer(nr);
						q.offer(nc);
						visited[nr][nc] = true;
					}
				}
			}
		}
		
	}
}
