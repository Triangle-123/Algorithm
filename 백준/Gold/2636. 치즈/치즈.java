import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int[][] arr;
	static boolean[][] visited;
	static Queue<Integer> q = new LinkedList<>();
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		int c = sc.nextInt();
		arr = new int[r][c];
		visited = new boolean[r][c];
		int day = 0;
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				arr[i][j] = sc.nextInt();						
			}
		}
		int lastHour = 0;
		while(true) {
			int cnt = 0;
			for(int i = 0; i < arr.length; i++) {
				for(int j = 0; j < arr[i].length; j++) {
					if(arr[i][j] == 1) cnt++;
				}
			}
			if(cnt == 0) break;
			else {
				lastHour = cnt;
			}
			BFS(0, 0);
			for(int i = 0; i < r; i++) {
				Arrays.fill(visited[i], false);
			}
			day++;
		}
		System.out.println(day);
		System.out.println(lastHour);
	}
	
	static void BFS(int i, int j) {
		visited[i][j] = true;
		q.clear();
		
		q.offer(i);
		q.offer(j);
		
		while(!q.isEmpty()) {
			int r = q.poll();
			int c = q.poll();
			for(int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(nr >= 0 && nc >= 0 && nr < arr.length && nc < arr[r].length && !visited[nr][nc]) {
					if(arr[nr][nc] == 1) {
						arr[nr][nc] = 0;
						visited[nr][nc] = true;
					} else {
						q.offer(nr);
						q.offer(nc);
						visited[nr][nc] = true;
					}
				}
			}
		}
	}
}
