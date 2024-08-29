import java.util.Scanner;

public class Main {
	static int[][] arr;
	static boolean[][] visited;
	static int N;
	static int qCnt;
	static int[] dr = {0, 0, -1, 1, -1, 1};
	static int[] dc = {-1, 1, -1, -1, 1, 1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		arr = new int[N][N];
		visited = new boolean[N][N];
		
		qCnt = 0;
		perm(0);
		
		System.out.println(qCnt);
	}

	private static void perm(int idx) {
		if(idx == N) {
			qCnt++;
			return;
		}
		
		
		loop: for(int r = 0; r < N; r++) {
			if(!visited[r][idx]) {
				for(int d = 0; d < 6; d++) {
					int nr = r + dr[d];
					int nc = idx + dc[d];
					
					while(nr < N && nr >= 0 && nc < N && nc >= 0) {
						if(visited[nr][nc]) {
							continue loop;
						}
						nr += dr[d];
						nc += dc[d];
					}
				}
				visited[r][idx] = true;
				perm(idx + 1);
				visited[r][idx] = false;
			}
		}
	}
}
