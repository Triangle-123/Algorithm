import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int[][][] box;
	static boolean[][][] visited;
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int h = sc.nextInt();
		
		box = new int[h][m][n];
		visited = new boolean[h][m][n];
		
		for(int i = 0; i < h; i++) {
			for(int j = 0; j < m; j++) {
				for(int k = 0; k < n; k++) {
					box[i][j][k] = sc.nextInt();
					if(box[i][j][k] == 1) {
						q.offer(i);
						q.offer(j);
						q.offer(k);
					}
				}
			}
		}
		
		if(!q.isEmpty()) BFS(q.poll(), q.poll(), q.poll());
		
		out: for(int i = 0; i < h; i++) {
			for(int j = 0; j < m; j++) {
				for(int k = 0; k < n; k++) {
					if(box[i][j][k] == 0) {
						day = -1;
						break out;
					}
				}
			}
		}
		
		System.out.println(day);
	}
	
	static Queue<Integer> q = new LinkedList<>();
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int day = 0;
	
	static void BFS(int i, int j, int k) {
		visited[i][j][k] = true;
		q.offer(i);
		q.offer(j);
		q.offer(k);
		
		while(!q.isEmpty()) {
			int qSize = q.size();
			
			for(int t = 0; t < qSize; t += 3) {
				int pi = q.poll();
				int pj = q.poll();
				int pk = q.poll();
				
				for(int z = -1; z < 2; z++) {
					if(z == 0) continue;
					int nz = pi + z;
					if(nz >= 0 && nz < box.length && box[nz][pj][pk] == 0 && !visited[nz][pj][pk]) {
						q.offer(nz);
						q.offer(pj);
						q.offer(pk);
						box[nz][pj][pk] = 1;
						visited[nz][pj][pk] = true;
					}
				}
				for(int d = 0; d < 4; d++) {
					int nr = pj + dr[d];
					int nc = pk + dc[d];
					
					if(nr >= 0 && nc >= 0 && nr < box[i].length && nc < box[i][j].length && box[pi][nr][nc] == 0 && !visited[pi][nr][nc]) {
						q.offer(pi);
						q.offer(nr);
						q.offer(nc);
						box[pi][nr][nc] = 1;
						visited[pi][nr][nc] = true;
					}
				}
			}
			day++;
		}
		day--;
	}
}