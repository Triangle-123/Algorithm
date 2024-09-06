import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	
	static boolean[][] visited;
	static int[][] board;
	static int[][] dr = {{}, {-1, 1, 0, 0}, {-1, 1}, {0, 0}, {-1, 0}, {1, 0}, {1, 0}, {-1, 0}};
	static int[][] dc = {{}, {0, 0, -1, 1}, {0, 0}, {-1, 1}, {0, 1}, {0, 1}, {0, -1}, {0, -1}};
	
	static int N, M, L;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tCase = sc.nextInt();
		for(int t = 1; t <= tCase; t++) {
			N = sc.nextInt();
			M = sc.nextInt();
			int R = sc.nextInt();
			int C = sc.nextInt();
			L = sc.nextInt();
			
			board = new int[N][M];
			visited = new boolean[N][M];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					board[i][j] = sc.nextInt();
				}
			}
			
			BFS(R, C, board[R][C], 1); 
			
			int cnt = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(visited[i][j]) cnt++;
				}
			}
			System.out.println("#" + t + " " + cnt);
		}
	}

	private static void BFS(int x, int y, int status, int time) {
		
		visited[x][y] = true;
		Queue<Integer> q = new LinkedList<>();
		
		q.offer(x);
		q.offer(y);
		q.offer(status);
		
		while(!q.isEmpty()) {
			if(time == L) break;
			int qSize = q.size();
			for(int i = 0; i < qSize; i += 3) {
				int r = q.poll();
				int c = q.poll();
				int st = q.poll();
				
				for(int d = 0; d < dr[st].length; d++) {
					int nr = r + dr[st][d];
					int nc = c + dc[st][d];
					
					if(nr < N && nr >= 0 && nc < M && nc >= 0 && !visited[nr][nc] && board[nr][nc] != 0) {
						boolean isconnect = false;
						for(int k = 0; k < dr[board[nr][nc]].length; k++) {
							int com1 = dr[st][d] + dr[board[nr][nc]][k];
							int com2 = dc[st][d] + dc[board[nr][nc]][k];
							if(com1 == 0 && com2 == 0) {
								isconnect = true;
								break;
							}
						}
						if(isconnect) {
							q.offer(nr);
							q.offer(nc);
							q.offer(board[nr][nc]);
							visited[nr][nc] = true;		
						}
					}
				}
				
			}
			time++;
		}
		
	}
}