import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static int[][] arr;
	static boolean[][] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tCase = sc.nextInt();
		for(int t = 1; t <= tCase; t++) {
			int n = sc.nextInt();
			
			arr = new int[n][n];
			visited = new boolean[n][n];
			
			int max = 0;
			int min = Integer.MAX_VALUE;
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					int num = sc.nextInt();
					arr[i][j] = num;
					max = Math.max(max, num);
					min = Math.min(min, num);
				}
			}
			int cnt = 0;
			int maxCnt = 0;
			for(int i = min - 1; i < max; i++) {
				for(int j = 0; j < n; j++) {
					for(int k = 0; k < n; k++) {
						if(!visited[j][k] && arr[j][k] > i) {
							BFS(i, j, k);
							cnt++;
						}
					}
				}
				maxCnt = Math.max(maxCnt, cnt);
				cnt = 0;
				for(int j = 0; j < n; j++) {
					Arrays.fill(visited[j], false);
				}
			}
			
			System.out.println("#" + t + " " + maxCnt);
		}
	}
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static Queue<Integer> q = new LinkedList<>();

	private static void BFS(int i, int j, int k) {
		
		visited[j][k] = true;
		q.offer(j);
		q.offer(k);
		
		while(!q.isEmpty()) {
			int r = q.poll();
			int c = q.poll();
					
			for(int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(nr < arr.length && nr >= 0 && nc < arr[nr].length && nc >= 0 && !visited[nr][nc] && arr[nr][nc] > i) {
					visited[nr][nc] = true;
					q.offer(nr);
					q.offer(nc);
				}
			}
		}
		
	}
}
