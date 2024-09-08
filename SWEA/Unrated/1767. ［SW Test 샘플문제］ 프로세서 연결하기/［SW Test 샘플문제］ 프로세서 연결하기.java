import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
	
	static int N; 
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int maxCore, minLine;
	static int[][] board;
	static boolean[][] visited;
	static List<int[]> list;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tCase = sc.nextInt();
		for(int t = 1; t <= tCase; t++) {
			N = sc.nextInt();
			board = new int[N][N];
			visited = new boolean[N][N];
			list = new ArrayList<>();
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					board[i][j] = sc.nextInt();
				}
			}
			
			for(int i = 1; i < N - 1; i++) {
				for(int j = 1; j < N - 1; j++) {
					if(board[i][j] == 1) list.add(new int[] {i, j});
				}
			}
			
			maxCore = 0;
			minLine = Integer.MAX_VALUE;
			DFS(0, 0, 0);
			
			System.out.println("#" + t + " " + minLine);
			
		}
	
	}

	private static void DFS(int idx, int Line, int Core) {
		
		if(idx == list.size()) {
			if(maxCore < Core) {
				maxCore = Core;
				minLine = Line;
			} else if(maxCore == Core) {
				minLine = Math.min(minLine, Line);
			}
			return;
		}
		boolean isConnected = false;
		int r = list.get(idx)[0];
		int c = list.get(idx)[1];
		
		for(int d = 0; d < 4; d++) {
			int cnt = 0;
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			boolean[][] temp = new boolean[N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					temp[i][j] = visited[i][j];
				}
			}
			
			while(nr < N && nr >= 0 && nc < N && nc >= 0 && !visited[nr][nc] && board[nr][nc] != 1) {
				visited[nr][nc] = true;
				nr += dr[d];
				nc += dc[d];
				cnt++;
			}
			
			if(nr < 0 || nc < 0 || nr >= N || nc >= N) {
				DFS(idx + 1, Line + cnt, Core + 1);
				isConnected = true;
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					visited[i][j] = temp[i][j];
				}
			}
			
		}
		DFS(idx + 1, Line, Core);
	}
}