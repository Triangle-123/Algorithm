import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] graph = new int[N + 1][N + 1];
		int[] degree = new int[N + 1];
		boolean[] visited = new boolean[N + 1];
		for(int i = 0; i < M; i++) {
			int prev = sc.nextInt();
			int next = sc.nextInt();
			graph[prev][next] = 1;
			degree[next]++;
		}
		Queue<Integer> q = new ArrayDeque<>();
		for(int i = 1; i <= N; i++) {
			if(!visited[i] && degree[i] == 0) {
				q.offer(i);
				visited[i] = true;
			}
		}
		
		int cnt = 1;
		int[] term = new int[N + 1];
		while(!q.isEmpty()) {
			int qSize = q.size();
			for(int j = 0; j < qSize; j++) {
				int node = q.poll();
				term[node] = cnt;
				for(int i = 1; i <= N; i++) {
					if(graph[node][i] == 1) {
						graph[node][i] = 0;
						degree[i]--;
					}
				}
				for(int i = 1; i <= N; i++) {
					if(!visited[i] && degree[i] == 0) {
						q.offer(i);
						visited[i] = true;
					}
				}
			}
			cnt++;
		}
		
		for(int i = 1; i <= N; i++) {
			System.out.print(term[i] + " ");
		}
	}
}
