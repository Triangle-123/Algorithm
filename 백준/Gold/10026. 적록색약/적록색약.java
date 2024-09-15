import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int N, cnt, blindCnt;
	static boolean blinded;
	static char[][] board;
	static boolean[][] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		board = new char[N][N];
		visited = new boolean[N][N];
		for(int i = 0; i < N; i++) {
			board[i] = sc.next().toCharArray();
		}
		cnt = 0;
		blindCnt = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					BFS(i, j);
					cnt++;
				}
			}
		}
		for(int i = 0; i < N; i++) {
			Arrays.fill(visited[i], false);
		}
		blinded = true;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					BFS(i, j);
					blindCnt++;
				}
			}
		}
		System.out.println(cnt + " " + blindCnt);
	}

	private static void BFS(int i, int j) {
		Queue<Integer> q = new ArrayDeque<>();
		visited[i][j] = true;
		q.offer(i);
		q.offer(j);
		
		if(blinded) {
			while(!q.isEmpty()) {
				int r = q.poll();
				int c = q.poll();
				for(int d = 0; d < 4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					
					if(nr < N && nr >= 0 && nc < N && nc >= 0 && !visited[nr][nc]) {
						if((board[r][c] != 'B' && board[nr][nc] != 'B') || (board[r][c] == 'B'  && board[nr][nc] == board[r][c])) {
							visited[nr][nc] = true;
							q.offer(nr);
							q.offer(nc);							
						}
					}
				}
				
			}
		} else {
			while(!q.isEmpty()) {
				int r = q.poll();
				int c = q.poll();
				for(int d = 0; d < 4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					
					if(nr < N && nr >= 0 && nc < N && nc >= 0 && !visited[nr][nc] && board[nr][nc] == board[r][c]) {
						visited[nr][nc] = true;
						q.offer(nr);
						q.offer(nc);
					}
				}
				
			}
			
		}
	}
}
