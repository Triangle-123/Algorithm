import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int[][] tomato;
	static boolean[][] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static Queue<Integer> q = new LinkedList<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		tomato = new int[n][m];
		visited = new boolean[n][m];
		boolean ripe = true;
		boolean notRipe = false;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				int num = sc.nextInt();
				tomato[i][j] = num;
				if(num == 1) {
					q.offer(i);
					q.offer(j);
					visited[i][j] = true;
				} else if(num == 0) ripe = false;
			}
		}
		if(ripe) {
			System.out.println(0);
		} else {
			BFS();
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if(tomato[i][j] == 0) {
						notRipe = true;
					}
				}
			}
			if(notRipe) System.out.println(-1);
			else System.out.println(day);
		}
		
	}

	static int day = -1;
	
	static void BFS() {
		while(!q.isEmpty()) {
			int qSize = q.size();
			for(int i = 0; i < qSize; i += 2) {
				int r = q.poll();
				int c = q.poll();
				
				for(int d = 0; d < 4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					if(nr < tomato.length && nr >= 0 && nc < tomato[nr].length && nc >= 0 && !visited[nr][nc] && tomato[nr][nc] != -1) {
						q.offer(nr);
						q.offer(nc);
						tomato[nr][nc] = 1;
						visited[nr][nc] = true;
					}
				}
			}
			day++;
		}
	}
}