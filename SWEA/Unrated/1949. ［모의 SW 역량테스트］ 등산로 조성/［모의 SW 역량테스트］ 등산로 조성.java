import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int N, K, maxLen;
	static int[][] board;
	static boolean[][] visited;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tCase = sc.nextInt();
		for(int t = 1; t <= tCase; t++) {
			N = sc.nextInt();
			K = sc.nextInt();
			
			board = new int[N][N];
			visited = new boolean[N][N];
			int max = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					int num = sc.nextInt();
					board[i][j] = num;
					max = Math.max(max, num);
				}
			}
			List<int[]> list = new ArrayList<>();
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(board[i][j] == max) {
						list.add(new int[] {i, j});
					}
				}
			}
			maxLen = 0;
			for(int i = 0; i < list.size(); i++) {
				DFS(list.get(i)[0], list.get(i)[1], false, 1);
			}
			
			System.out.println("#" + t + " " + maxLen);
		}
	}


	private static void DFS(int r, int c, boolean skill, int depth) {
		visited[r][c] = true;
		
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr < N && nr >= 0 && nc < N && nc >= 0 && !visited[nr][nc]) {
				visited[nr][nc] = true;
				if(board[nr][nc] >= board[r][c] && !skill) {
					if(board[nr][nc] - board[r][c] < K) {
						int temp = board[nr][nc];
						board[nr][nc] = board[r][c] - 1;
						DFS(nr, nc, true, depth + 1);
						board[nr][nc] = temp;
					}
				} else if(board[nr][nc] < board[r][c]){
					DFS(nr, nc, skill, depth + 1);
				}
				visited[nr][nc] = false;
			}
		}
		maxLen = Math.max(maxLen, depth);
		visited[r][c] = false;
		
	}
}