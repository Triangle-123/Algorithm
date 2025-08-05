import java.util.*;
import java.io.*;

public class Main {
	
	static List<int[]> blank = new ArrayList<>();
	
	static boolean solved = false;
	
	static int[][] board = new int[9][9];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[][] row = new boolean[9][10];
		boolean[][] col = new boolean[9][10];
		boolean[][][] box = new boolean[3][3][10];
		StringTokenizer st;
		for(int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 9; j++) {
				int num = Integer.parseInt(st.nextToken());
				if(num == 0) {
					blank.add(new int[] {i, j});
				} else {
					row[i][num] = true;
					col[j][num] = true;
					box[i / 3][j / 3][num] = true;
				}
				board[i][j] = num;
			}
		}
		solve(row, col, box, 0);
	}

	private static void solve(boolean[][] row, boolean[][] col, boolean[][][] box, int idx) {
		if(idx == blank.size()) return;
		if(solved) return;
		
		int r = blank.get(idx)[0];
		int c = blank.get(idx)[1];
		
		for(int i = 1; i <= 9; i++) {
			if(!row[r][i] && !col[c][i] && !box[r / 3][c / 3][i]) {
				board[r][c] = i;
				row[r][i] = true;
				col[c][i] = true;
				box[r / 3][c / 3][i] = true;
				if(idx == blank.size() - 1) {
					print();
					solved = true;
					return;
				} else solve(row, col, box, idx + 1);
				board[r][c] = 0;
				row[r][i] = false;
				col[c][i] = false;
				box[r / 3][c / 3][i] = false;
			}
		}
		
	}

	private static void print() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				sb.append(board[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
// 박스검사 빼먹음 ㅋ;