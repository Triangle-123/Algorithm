import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int t = 1; t <= 10; t++) {
			int V = sc.nextInt();
			int E = sc.nextInt();
			int[][] graph = new int[V + 1][V + 1];
			int[] degree = new int[V + 1];
			boolean[] visited = new boolean[V + 1];
			for(int i = 0; i < E; i++) {
				int prev = sc.nextInt();
				int next = sc.nextInt();
				graph[prev][next] = 1;
				degree[next]++;
			}
			
			Queue<Integer> q = new ArrayDeque<>();
			for(int i = 1; i <= V; i++) {
				if(degree[i] == 0) {
					q.offer(i);
					visited[i] = true;
				}
			}
			StringBuilder sb = new StringBuilder();
			sb.append("#" + t + " ");
			while(!q.isEmpty()) {
				int node = q.poll();
				sb.append(node + " ");
				for(int i = 1; i <= V; i++) {
					if(graph[node][i] == 1) {
						graph[node][i] = 0;
						degree[i]--;
					}
				}
				for(int i = 1; i <= V; i++) {
					if(degree[i] == 0 && !visited[i]) {
						q.offer(i);
						visited[i] = true;
					}
				}
			}
			System.out.println(sb);
		}
	}
}
