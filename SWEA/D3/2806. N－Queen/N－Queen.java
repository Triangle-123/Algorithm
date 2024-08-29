import java.util.Scanner;

public class Solution {
	static int[][] arr;
	static int N;
	static int qCnt;
	static boolean[][] visited;
	static int[] dr = {0, 0, -1, -1, 1, 1};
	static int[] dc = {-1, 1, -1, 1, -1, 1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tCase = sc.nextInt();
		for(int t = 1; t <= tCase; t++) {
			N = sc.nextInt();
			arr = new int[N][N];
			visited = new boolean[N][N];
			
			qCnt = 0;
			
			perm(0);
			
			System.out.println("#" + t + " " + qCnt);
			
		}
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
