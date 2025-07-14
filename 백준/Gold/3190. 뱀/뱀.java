import java.util.*;
import java.io.*;

public class Main {
	
	static int[] tail;
	static Queue<int[]> next = new ArrayDeque<>();
	static int time = 0;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	static int d = 0;
	static int N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		int[][] board = new int[N + 2][N + 2];
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			board[x][y] = 1;
		}
		int L = Integer.parseInt(br.readLine());
		Map<Integer, String> direction = new HashMap<>();
		for(int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			direction.put(Integer.parseInt(st.nextToken()), st.nextToken());
		}
		board[1][1] = -1;
		snake(1, 1, board, direction);
		System.out.println(time);
	}
	
	private static void snake(int x, int y, int[][] board, Map<Integer, String> direction) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {x, y});
		int[] head = new int[] {x, y};
		tail = new int[] {x, y};
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			int r = poll[0];
			int c = poll[1];
			if(direction.containsKey(time)) {
				if(direction.get(time).equals("D")) d = (d + 1) % 4;
				else {
					d--;
					if(d < 0) d += 4;
				}
			}
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(nr > N || nc > N || nr <= 0 || nc <= 0 || board[nr][nc] == -1) {
				time++;
				return;
			}
			if(board[nr][nc] == 1) {
				q.offer(new int[] {nr, nc});
				head[0] = nr;
				head[1] = nc;
				board[nr][nc] = -1;
				next.offer(new int[] {nr, nc});
			} else {
				q.offer(new int[] {nr, nc});
				if(next.isEmpty()) {
					board[tail[0]][tail[1]] = 0;
					head[0] = tail[0] = nr;
					head[1] = tail[1] = nc;
					board[nr][nc] = -1;
				} else {
					board[tail[0]][tail[1]] = 0;
					tail = next.poll();
					next.offer(new int[] {nr, nc});
					head[0] = nr;
					head[1] = nc;
					board[nr][nc] = -1;
				}
			}
			time++;
		}
	}
}
