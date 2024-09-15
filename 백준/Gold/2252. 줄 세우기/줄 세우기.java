import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<Integer>[] graph = new ArrayList[N + 1];
		for(int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		int[] degree = new int[N + 1];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int prev = Integer.parseInt(st.nextToken());
			int next = Integer.parseInt(st.nextToken());
			graph[prev].add(next);
			degree[next]++;
		}
		
		Queue<Integer> q = new ArrayDeque<>();
		boolean[] visited = new boolean[N + 1];
		for(int i = 1; i <= N; i++) {
			if(degree[i] == 0) {
				q.offer(i);
				visited[i] = true;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		while(!q.isEmpty()) {
			int node = q.poll();
			sb.append(node + " ");
			while(!graph[node].isEmpty()) {
				int next = graph[node].remove(0);
				degree[next]--;
				if(degree[next] == 0 && !visited[next]) {
					q.offer(next);
					visited[next] = true;
				}
			}
		}
		System.out.println(sb);
	}
}
