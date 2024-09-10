import java.util.Scanner;

public class Main {
	
	static char[][] arr;
	static boolean[][] visited;
	static boolean[] alpha = new boolean[100];
	static int maxCnt = 0;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		int c = sc.nextInt();
		arr = new char[r][c];
		visited = new boolean[r][c];
		for(int i = 0; i < r; i++) {
			arr[i] = sc.next().toCharArray();
		}
		
		DFS(0, 0, 1);
		System.out.println(maxCnt);
	}
	private static void DFS(int i, int j, int cnt) {
		if(visited[i][j] || alpha[arr[i][j]]) return;
		visited[i][j] = true;
		alpha[arr[i][j]] = true;
		
		for(int d = 0; d < 4; d++) {
			int nr = i + dr[d];
			int nc = j + dc[d];
			
			if(nr < arr.length && nr >= 0 && nc < arr[nr].length && nc >= 0 && !visited[nr][nc] && !alpha[arr[nr][nc]]) {
				DFS(nr, nc, cnt + 1);
			}
		}
		maxCnt = Math.max(maxCnt, cnt);
		visited[i][j] = false;
		alpha[arr[i][j]] = false;
	}
}
