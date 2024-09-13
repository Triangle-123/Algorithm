import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static Queue<Integer> q = new ArrayDeque<>();
	static boolean[][] visited;
	static char[][] board;
	static int N, M, cnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		board = new char[N][M];
		visited = new boolean[N][M];
		for(int i = 0; i < N; i++) {
			board[i] = sc.next().toCharArray();
			for(int j = 0; j < M; j++) {
				if(board[i][j] == 'I') {
					q.offer(i);
					q.offer(j);
					visited[i][j] = true;
				}
			}
		}
		
		BFS();
		
		if(cnt == 0) System.out.println("TT");
		else System.out.println(cnt);
	}
	private static void BFS() {
		
		while(!q.isEmpty()) {
			int r = q.poll();
			int c = q.poll();
			for(int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(nr < N && nr >= 0 && nc < M && nc >= 0 && !visited[nr][nc] && board[nr][nc] != 'X') {
					q.offer(nr);
					q.offer(nc);
					visited[nr][nc] = true;
					if(board[nr][nc] == 'P') {
						cnt++;
					}
				}
			}
		}
		
	}
}
