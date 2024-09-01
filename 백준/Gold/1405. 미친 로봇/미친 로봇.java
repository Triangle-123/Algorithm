import java.util.Scanner;

public class Main {
	
	static int[][] graph;
	static boolean[][] visited;
	static int[] dr = {0, 0, 1, -1};
	static int[] dc = {1, -1, 0, 0};
	static int N;
	static double[] percent = new double[4]; 
	static double result;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		for(int i = 0; i < 4; i++) {
			percent[i] = sc.nextInt() / 100.0;
		}
		
		graph = new int[2 * N + 1][2 * N + 1];
		visited = new boolean[2 * N + 1][2 * N + 1];
		
		int startX = graph.length / 2;
		int startY = graph.length / 2;
		int depth = 0;
		result = 0.0;
		DFS(startX, startY, depth, 1.0);
		System.out.println(result);
	}

	private static void DFS(int r, int c, int depth, double pro) {
		visited[r][c] = true;
		
		if(depth == N) {
			result += pro;
			return;
		}
		
		for(int d = 0; d < 4; d++) {
			if(percent[d] == 0.0) continue;
			int nr = r + dr[d];
			int nc = c + dc[d];

			
			if(!visited[nr][nc]) {
				visited[nr][nc] = true; // 백트래킹
				DFS(nr, nc, depth + 1, pro * percent[d]); // 확률을 계속 곱해준다
				visited[nr][nc] = false; // 돌아왔으니 방문처리 해제
			}

		}
	}
}
