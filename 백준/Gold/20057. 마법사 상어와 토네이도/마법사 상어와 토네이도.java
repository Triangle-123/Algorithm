import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {-1, 0, 1, 0};
	
	static int[][] tornadoR = {{-1, 1, -1, 1, -1, 1, -2, 2, 0, 0},
			{1, 1, 0, 0, -1, -1, 0, 0, 2, 1},
			{1, -1, 1, -1, 1, -1, 2, -2, 0, 0},
			{-1, -1, 0, 0, 1, 1, 0, 0, -2, -1}
	};
	static int[][] tornadoC = {{-1, -1, 0, 0, 1, 1, 0, 0, -2, -1},
			{-1, 1, -1, 1, -1, 1, -2, 2, 0, 0},
			{1, 1, 0, 0, -1, -1, 0, 0, 2, 1},
			{1, -1, 1, -1, 1, -1, 2, -2, 0, 0}
	};
	static double[] storm = {0.1, 0.1, 0.07, 0.07, 0.01, 0.01, 0.02, 0.02, 0.05};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] board = new int[n][n];
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int r = n / 2;
		int c = n / 2;
		int d = 0;
		int distance = 1; 
		int currDis = 0;
		int rotateCnt = 0;
		int sandSum = 0;
		int sand = 0;
		while(r != 0 || c != 0) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr < 0 || nr >= board.length || nc < 0 || nc >= board.length || currDis == distance) {
				d = (d + 1) % 4;
				rotateCnt++;
				currDis = 0;
				if(rotateCnt == 2) {
					distance++;
					rotateCnt = 0;
				}
			} else {
				if(board[nr][nc] != 0) {
					int totalSand = 0;
					for(int i = 0; i < 10; i++) {
						if(i == 9) {
							board[nr][nc] -= totalSand;
							sand = board[nr][nc];
						}
						else {
							sand = (int)(board[nr][nc] * storm[i]);
						}
						int sr = nr + tornadoR[d][i];
						int sc = nc + tornadoC[d][i];
						if(sr >= 0 && sr < board.length && sc >= 0 && sc < board[sr].length) {
							board[sr][sc] += sand;
							totalSand += sand;
						} else {
							sandSum += sand;
							totalSand += sand;
						}
					}
				}
				r = nr;
				c = nc;
				currDis++;
			}
		}
		
		System.out.println(sandSum);
	}
}
