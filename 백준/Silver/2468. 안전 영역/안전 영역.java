import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] arr;
	static boolean[][] visited; 
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int n;
	static Queue<Integer> q = new LinkedList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n][n];
		
		int min = 100;
		int max = 0;
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, arr[i][j]);
				min = Math.min(min, arr[i][j]);
			}
		}
		
		int safety = 0;
		int maxSafety = 0;
		
		for(int rain = min - 1; rain < max; rain++) {
			visited = new boolean[n][n];
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(visited[i][j] || arr[i][j] <= rain) continue;
					safety += BFS(rain, i, j);
				}
			}
			maxSafety = Math.max(maxSafety, safety);
			safety = 0;
		}
		
		System.out.println(maxSafety);
	}

	static int BFS(int rain, int i, int j) {
		visited[i][j] = true;
		
		for(int d = 0; d < 4; d++) {
			int nr = i + dr[d];
			int nc = j + dc[d];
			
			if(nr >= 0 && nc >= 0 && nr < arr.length && nc < arr[i].length && arr[nr][nc] > rain && !visited[nr][nc]) {
				q.offer(nr);
				q.offer(nc);
				visited[nr][nc] = true;
			}
		}
		
		while(!q.isEmpty()) {
			BFS(rain, q.poll(), q.poll());
		}
		
		return 1;
	
	}
}
