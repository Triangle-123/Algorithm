import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int N, L, R, day, sum;
	static List<int[]> list = new ArrayList<>();
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int[][] board;
	static boolean[][] visited;
	static boolean moved;
	static Queue<Integer> q = new ArrayDeque<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		L = sc.nextInt();
		R = sc.nextInt();
		
		board = new int[N][N];
		visited = new boolean[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		
		while(true) {
			moved = false;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(visited[i][j]) continue; 
					BFS(i, j);
					int size = list.size();
					while(!list.isEmpty()) {
						int[] node = list.remove(0);
						board[node[0]][node[1]] = sum / size;
					}
					sum = 0;
				}
			}
			for(int i = 0; i < N; i++) {
				Arrays.fill(visited[i], false);
			}
			if(!moved) break;
			day++;
		}
		
		System.out.println(day);
		
	}

	private static void BFS(int i, int j) {
		visited[i][j] = true;
		q.clear();
		q.offer(i);
		q.offer(j);
		list.add(new int[] {i, j});
		sum += board[i][j];
		while(!q.isEmpty()) {
			int r = q.poll();
			int c = q.poll();
			
			for(int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(nr < N && nr >= 0 && nc < N && nc >= 0 && !visited[nr][nc] && Math.abs(board[r][c] - board[nr][nc]) >= L && Math.abs(board[r][c] - board[nr][nc]) <= R) {
					visited[nr][nc] = true;
					q.offer(nr);
					q.offer(nc);
					list.add(new int[] {nr, nc});
					sum += board[nr][nc];
					moved = true;
				}
			}
		}
		
	}
}
// 상하좌우 탐색해서 허용범위 내라면
// 리스트에 위치값 넣어주고
// 사이즈 미리 받은뒤 리스트에서 뽑으면서 그 위치에 값 수정
// for문으로 다른 땅들도 탐색해준뒤
// 모든 탐색 끝나고 방문배열 초기화
// 그 후 하루 지난다.