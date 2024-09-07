import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	
	static class Node {
		int X, Y, TIME;

		public Node(int x, int y, int time) {
			super();
			X = x;
			Y = y;
			TIME = time;
		}
		
		
	}
	
	static int N;
	static int[][] board;
	static boolean[][] visited;
	static PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {

		@Override
		public int compare(Node o1, Node o2) {
			if(o1.TIME == o2.TIME) {
				if(o1.X == o2.X) {
					return o1.Y - o2.Y;
				}
				return o1.X - o2.X;				
			}
			return o1.TIME - o2.TIME;
		}
		
	});
	
	static int time = 0;
	static int realTime = 0;
	static int eat = 0;
	static int shark = 2;
	
	static int[] dr = {-1, 0, 0, 1};
	static int[] dc = {0, -1, 1, 0};
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		board = new int[N][N];
		visited = new boolean[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				int num = sc.nextInt();
				if(num == 9) {
					num = 0;
					pq.offer(new Node(i, j, time));
					visited[i][j] = true;
				}
				board[i][j] = num;
			}
		}
		
		BFS();
		if(shark == 2 && eat == 0) time = 0;
		System.out.println(realTime);
		
	}

	private static void BFS() {
		
		loop: while(!pq.isEmpty()) {
			int qSize = pq.size();
			boolean move = false;
			for(int i = 0; i < qSize; i++) {
				Node node = pq.poll();
				int r = node.X;
				int c = node.Y;
				if(board[r][c] < shark && board[r][c] != 0) {
					pq.clear();
					for(int j = 0; j < N; j++) {
						Arrays.fill(visited[j], false);
					}
					visited[r][c] = true;
					board[r][c] = 0;
					eat++;
					realTime = time;
					if(eat == shark) {
						eat = 0;
						shark++;
					}
					qSize = 1;
				}
				
				for(int d = 0; d < 4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					
					if(nr < N && nr >= 0 && nc < N && nc >= 0 && !visited[nr][nc] && board[nr][nc] <= shark) {
						pq.offer(new Node(nr, nc, time));
						visited[nr][nc] = true;
						move = true;
					}
				}
			
			}
			boolean possible = false;
			out: for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(board[i][j] < shark && board[i][j] != 0) {
						for(int d = 0; d < 4; d++) {
							int nr = i + dr[d];
							int nc = j + dc[d];
							
							if(nr < N && nr >= 0 && nc < N && nc >= 0 && board[nr][nc] <= shark) {
								possible = true;
								break out;								
							}
						}
					}
				}
			}
			if(possible && move) time++;
			else return;
		}
		
	}
}