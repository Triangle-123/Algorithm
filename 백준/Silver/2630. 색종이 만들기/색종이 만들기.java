import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] board;
	static int bCnt = 0;
	static int wCnt = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		board = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		cut(0, 0, n);
		System.out.println(wCnt);
		System.out.println(bCnt);
	}

	static int[] dr = {0, 0, 1, 1};
	static int[] dc = {0, 1, 0, 1};
	
	private static void cut(int r, int c, int N) {
		
		
		boolean isblue = false;
		boolean iswhite = false;
		
		if(N == 0) {
			if(board[r][c] == 1) bCnt++;
			else wCnt++;
			return;
		}
		
		for(int i = r; i < r + N; i++) {
			for(int j = c; j < c + N; j++) {
				if(board[i][j] == 1) isblue = true;
				else iswhite = true;
			}
		}
		
		if(isblue && iswhite) {
			for(int d = 0; d < 4; d++) {
				cut(r + (dr[d] * (N / 2)), c + (dc[d] * (N / 2)), N / 2);
			}
		} else if(isblue) {
			bCnt++;
		} else {
			wCnt++;
		}
	}
}
