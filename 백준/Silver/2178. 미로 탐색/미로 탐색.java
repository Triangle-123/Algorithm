import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	
	static int[][] board;
	static int[][] distance;
	static boolean[][] visited;
	static Queue<Integer> q = new LinkedList<>();
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int n, m;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		board = new int[n + 1][m + 1];
		distance = new int[n + 1][m + 1];
		visited = new boolean[n + 1][m + 1];
		for(int i = 1; i <= n; i++) {
			String[] str = br.readLine().split("");
			for(int j = 1; j <= m; j++) {
				board[i][j] = Integer.parseInt(str[j - 1]);
			}
		}
		
		distance[1][1] = 1;
		BFS(1, 1);
		System.out.println(distance[n][m]);
		
 	}
	
	static boolean escape = false;

	static void BFS(int i, int j) {
		visited[i][j] = true;
		
		if(i == n && j == m) return;
		
		for(int d = 0; d < 4; d++) {
			int nr = i + dr[d];
			int nc = j + dc[d];
			
			if(nr >= 1 && nc >= 1 && nr < board.length && nc < board[i].length && board[nr][nc] != 0 && !visited[nr][nc]) {
				q.offer(nr);
				q.offer(nc);
				visited[nr][nc] = true;
				distance[nr][nc] = distance[i][j] + 1;
			}
		}
		
		while(!q.isEmpty()) {
			BFS(q.poll(), q.poll());
		}
	
	}
}