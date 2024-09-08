import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, M;
	static int minDis = Integer.MAX_VALUE;
	static int[][] map;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static boolean[][][] visited;
	static Queue<Integer> q = new ArrayDeque<>();
 	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		map = new int[N][M];
		visited = new boolean[N][M][2];
		for(int i = 0; i < N; i++) {
			char[] c = sc.next().toCharArray();
			for(int j = 0; j < M; j++) {
				int num = c[j] - '0';
				map[i][j] = num;
			}
		}
		brakeBFS(0, 0, 0);
		if(minDis == Integer.MAX_VALUE) minDis = -1;
		System.out.println(minDis);
	}

	private static void brakeBFS(int x, int y, int broken) {
		visited[x][y][broken] = true;
		q.clear();
		q.offer(x);
		q.offer(y);
		q.offer(broken);
		int len = 1;
		
		while(!q.isEmpty()) {
			int qSize = q.size();
			for(int i = 0; i < qSize; i += 3) {
				int r = q.poll();
				int c = q.poll();
				int b = q.poll();
				
				if(r == N - 1 && c == M - 1) {
					minDis = Math.min(minDis, len);
					return;
				}
				for(int d = 0; d < 4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					if(nr < N && nr >= 0 && nc < M && nc >= 0) {
						if(map[nr][nc] == 0 && !visited[nr][nc][b]) {
							q.offer(nr);
							q.offer(nc);	
							q.offer(b);
							visited[nr][nc][b] = true;
						}
						
						else if(!visited[nr][nc][b] && map[r][c] != 1 && b == 0) {
							visited[nr][nc][b] = true;
							q.offer(nr);
							q.offer(nc);	
							q.offer(1);	
						}
						
					}
					
				}
			}
			len++;
		}
	}
}
