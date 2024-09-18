import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int K, W, H;
	static int[][] board;
	static boolean[][][] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int[] hr = {-2, -2, -1, -1, 1, 1, 2, 2};
	static int[] hc = {-1, 1, -2, 2, -2, 2, -1, 1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		K = sc.nextInt();
		W = sc.nextInt();
		H = sc.nextInt();
		board = new int[H][W];
		visited = new boolean[H][W][K + 1];
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < W; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		
		if(!horse(0, 0, 0)) System.out.println(-1);;
	}

	private static boolean horse(int i, int j, int k) {
		Queue<Integer> q = new ArrayDeque<>();
		visited[i][j][k] = true;
		q.offer(i);
		q.offer(j);
		q.offer(k);
		int move = 0;
		while(!q.isEmpty()) {
			int qSize = q.size();
			for(int s = 0; s < qSize; s += 3) {
				int r = q.poll();
				int c = q.poll();
				int b = q.poll();
				
				if(r == H - 1 && c == W - 1) {
					System.out.println(move);
					return true;
				}
				if(b < K) {
					for(int d = 0; d < 8; d++) {
						int nr = r + hr[d];
						int nc = c + hc[d];
						
						if(nr < H && nr >= 0 && nc < W && nc >= 0 && !visited[nr][nc][b + 1] && board[nr][nc] != 1) {
							visited[nr][nc][b + 1] = true;
							q.offer(nr);
							q.offer(nc);
							q.offer(b + 1);
						}
					}
				}
				for(int d = 0; d < 4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					
					if(nr < H && nr >= 0 && nc < W && nc >= 0 && !visited[nr][nc][b] && board[nr][nc] != 1) {
						visited[nr][nc][b] = true;
						q.offer(nr);
						q.offer(nc);
						q.offer(b);
					}
				}
			}
			move++;
		}
		return false;
	}
}
