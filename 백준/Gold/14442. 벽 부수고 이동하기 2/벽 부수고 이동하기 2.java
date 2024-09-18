import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int N, M, K;
	static char[][] board;
	static boolean[][][] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		
		board = new char[N][M];
		visited = new boolean[N][M][K + 1];
		
		for(int i = 0; i < N; i++) {
			board[i] = sc.next().toCharArray();
		}
		
		if(!BFS(0, 0, 0)) System.out.println(-1);
	}

	private static boolean BFS(int i, int j, int brake) {
		visited[i][j][brake] = true;
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(i);
		q.offer(j);
		q.offer(brake);
		
		int distance = 1;
		while(!q.isEmpty()) {
			int qSize = q.size();
			for(int s = 0; s < qSize; s += 3) {
				int r = q.poll();
				int c = q.poll();
				int b = q.poll();
				if(r == N - 1 && c == M - 1) {
					System.out.println(distance);
					return true;
				}
				for(int d = 0; d < 4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					
					if(nr < N && nr >= 0 && nc < M && nc >= 0 && !visited[nr][nc][b]) {
						if(board[nr][nc] == '1' && b < K) {
							visited[nr][nc][b] = true;
							q.offer(nr);
							q.offer(nc);
							q.offer(b + 1);
						} else if(board[nr][nc] == '0'){
							visited[nr][nc][b] = true;
							q.offer(nr);
							q.offer(nc);
							q.offer(b);
						}
					}
				}
			}
			distance++;
		}
		return false;
		
	}
}
