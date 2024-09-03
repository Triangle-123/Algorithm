import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int[] dr = {-2, -2, -1, -1, 1, 1, 2, 2};
	static int[] dc = {-1, 1, -2, 2, -2, 2, -1, 1};
	static int resultR, resultC, N;
	static boolean[][] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tCase = sc.nextInt();
		for(int t = 1; t <= tCase; t++) {
			N = sc.nextInt();
			int currR = sc.nextInt();
			int currC = sc.nextInt();
			
			resultR = sc.nextInt();
			resultC = sc.nextInt();
			
			
			visited = new boolean[N][N];
			
			BFS(currR, currC);
		}
	}


	private static void BFS(int currR, int currC) {
		
		visited[currR][currC] = true;
		Queue<Integer> q = new LinkedList<>();
		
		q.offer(currR);
		q.offer(currC);
		int cnt = 0;
		while(!q.isEmpty()) {
			int qSize = q.size();
			for(int i = 0; i < qSize; i += 2) {
				int r = q.poll();
				int c = q.poll();
				
				if(r == resultR && c == resultC) {
					System.out.println(cnt);
					return;
				}
				
				for(int d = 0; d < dr.length; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					
					if(nr < N && nr >= 0 && nc < N && nc >= 0 && !visited[nr][nc]) {
						visited[nr][nc] = true;
						q.offer(nr);
						q.offer(nc);
					}
				}
			}
			cnt++;
		}
	}
}
