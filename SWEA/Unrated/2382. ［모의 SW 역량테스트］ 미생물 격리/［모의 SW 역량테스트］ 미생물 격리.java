import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	
	static int N, M, K;
	
	static int[] dr = {0, -1, 1, 0, 0};
	static int[] dc = {0, 0, 0, -1, 1};
	static boolean[][] visited;
	static Micro[][] board;
	static Micro[][] saved;
	static int[][] com;
	static Queue<Integer> q = new LinkedList<>();
	
	static class Micro {
		int C, D;

		public Micro() {}
		
		public Micro(int c, int d) {
			super();
			C = c;
			D = d;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tCase = sc.nextInt();
		for(int t = 1; t <= tCase; t++) {
			N = sc.nextInt();
			M = sc.nextInt();
			K = sc.nextInt();
			
			board = new Micro[N][N];
			visited = new boolean[N][N];
			saved = new Micro[N][N];
			com = new int[N][N];
			q.clear();
			for(int i = 0; i < K; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				board[x][y] = new Micro(sc.nextInt(), sc.nextInt());
				q.offer(x);
				q.offer(y);
			}
			
			
			BFS(0);
			int sum = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					sum += board[i][j].C;
//					System.out.println(i + " " + j + " " + board[i][j].C);
				}
			}
			System.out.println("#" + t + " " + sum);
		}
	}

	private static void BFS(int time) {
		
		while(!q.isEmpty()) {
			if(time == M) break;
			for(int i = 0; i < N; i++) {
				Arrays.fill(saved[i], new Micro());
				Arrays.fill(visited[i], false);
				Arrays.fill(com[i], 0);
			}
			int qSize = q.size();
			for(int i = 0; i < qSize; i += 2) {
				int r = q.poll();
				int c = q.poll();
				int dir = board[r][c].D;
				int nr = r + dr[dir];
				int nc = c + dc[dir];
				
				if(nr == 0 || nr == N - 1 || nc == 0 || nc == N - 1) {
					board[r][c].C /= 2;
					if(dir % 2 == 0) board[r][c].D--;
					else board[r][c].D++;
					saved[nr][nc] = board[r][c];
					com[nr][nc] = board[r][c].C;
					board[r][c] = null;
					q.offer(nr);
					q.offer(nc);
				} else {
					if(visited[nr][nc]) {
						if(com[nr][nc] < board[r][c].C) {
							saved[nr][nc].C += board[r][c].C;
							saved[nr][nc].D = board[r][c].D;
							com[nr][nc] = board[r][c].C;
							board[r][c] = null;
						} else {
							saved[nr][nc].C += board[r][c].C;
							board[r][c] = null;
						}
					}
					else {
						saved[nr][nc] = board[r][c];
						com[nr][nc] = board[r][c].C;
						visited[nr][nc] = true;
						q.offer(nr);
						q.offer(nc);
						board[r][c] = null;
					}
				}
				
				
			}
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					board[i][j] = saved[i][j];
				}
			}
			time++;
		}
		
	}
}