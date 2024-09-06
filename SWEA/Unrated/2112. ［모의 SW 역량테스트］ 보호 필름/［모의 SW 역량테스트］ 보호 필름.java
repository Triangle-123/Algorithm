import java.util.Scanner;

public class Solution {
	
	static int D, W, K;
	static int ans;
	static int[][] board;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tCase = sc.nextInt();
		for(int t = 1; t <= tCase; t++) {
			D = sc.nextInt();
			W = sc.nextInt();
			K = sc.nextInt();
			
			board = new int[D][W];
			for(int i = 0; i < D; i++) {
				for(int j = 0; j < W; j++) {
					board[i][j] = sc.nextInt();
				}
			}
			ans = K;
			combi(0, 0);
			
			System.out.println("#" + t + " " + ans);
		}
	}

	private static void combi(int idx, int sCnt) {
		
		if(check()) {
			ans = Math.min(ans, sCnt);
			return;
		}
		if(idx == D) return;
		if(sCnt == K) return;
		
		int[] temp = new int[W];
		for(int i = 0; i < W; i++) {
			temp[i] = board[idx][i];
		}
		
		combi(idx + 1, sCnt);
		
		for(int i = 0; i < W; i++) {
			board[idx][i] = 0;
		}
		combi(idx + 1, sCnt + 1);
		
		
		for(int i = 0; i < W; i++) {
			board[idx][i] = 1;
		}
		combi(idx + 1, sCnt + 1);
		
		
		for(int i = 0; i < W; i++) {
			board[idx][i] = temp[i];
		}
		
		
	}

	private static boolean check() {
		
		loop : for(int c = 0; c < W; c++) {
			int cnt = 1;
			for(int r = 1; r < D; r++) {
				if(board[r][c] == board[r - 1][c]) {
					cnt++;
				} else {
					cnt = 1;
				}
				if(cnt == K) continue loop;
			}
			if(cnt < K) {
				return false;
			}
		}
		
		return true;
	}
}
