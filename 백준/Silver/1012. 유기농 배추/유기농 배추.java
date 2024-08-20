import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int[][] arr;
	static boolean[][] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tCase = sc.nextInt();
		for(int t = 1; t <= tCase; t++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int k = sc.nextInt();
			
			arr = new int[n][m];
			visited = new boolean[n][m];
			
			for(int i = 0; i < k; i++) {
				int r = sc.nextInt();
				int c = sc.nextInt();
				arr[r][c] = 1;
			}
			
			int cnt = 0;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if(!visited[i][j] && arr[i][j] != 0) {
						BFS(i, j);
						cnt++;
					}
				}
			}
			
			System.out.println(cnt);
		}
	}
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static void BFS(int i, int j) {
		visited[i][j] = true;
		Queue<Integer> q = new LinkedList<>();
		q.offer(i);
		q.offer(j);
		
		while(!q.isEmpty()) {
			int r = q.poll();
			int c = q.poll();
			for(int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(nr >= 0 && nc >= 0 && nr < arr.length && nc < arr[i].length && !visited[nr][nc] && arr[nr][nc] != 0) {
					q.offer(nr);
					q.offer(nc);
					visited[nr][nc] = true;
				}
			}
		}
	}
}
