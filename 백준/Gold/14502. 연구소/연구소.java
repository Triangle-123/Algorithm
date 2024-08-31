import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int N, M;
	static int[][] board;
	static int[][] simul;
	static List<Integer> list;
	static int maxCnt;
	static Queue<Integer> q = new LinkedList<>();
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
 	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		board = new int[N][M];
		simul = new int[N][M];
		list = new ArrayList<>();
		
		for(int i = 0 ; i < N; i++) {
			for(int j = 0; j < M; j++) {
				int num = sc.nextInt();
				if(num == 2) {
					list.add(i);
					list.add(j);
				}
				board[i][j] = num;
			}
		}
		maxCnt = 0;
		combi(0, 0, 0);
		System.out.println(maxCnt);
		
	}

	private static void combi(int r, int c, int sCnt) {
		
		if(sCnt == 3) {
			for(int i = 0; i < N; i++) {
				simul[i] = Arrays.copyOf(board[i], M);
			}
			q.clear();
			for(int i = 0; i < list.size(); i++) {
				q.offer(list.get(i));
			}
			BFS();
			int cnt = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(simul[i][j] == 0) cnt++;
				}
			}
			maxCnt = Math.max(maxCnt, cnt);
			return;
		}
		
		
		while(true) {
			if(c == M) {
				c = 0;
				r++;
			}
			if(r == N) return;
			if(board[r][c] == 0) {
				board[r][c] = 1;
				combi(r, c + 1, sCnt + 1);
				board[r][c] = 0;
			}
			c++;
			
		}
	}

	private static void BFS() {
		
		while(!q.isEmpty()) {
			int r = q.poll();
			int c = q.poll();
			
			for(int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(nr < N && nr >= 0 && nc < M && nc >= 0 && simul[nr][nc] == 0) {
					q.offer(nr);
					q.offer(nc);
					simul[nr][nc] = 2;
				}
			}
		}
		
	}
}
