import java.util.*;
import java.io.*;

public class Main {
	
	static boolean[] visited;
	static boolean[] isCycle;
	static List<Integer>[] graph;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		
		graph = new ArrayList[N + 1];
		
		for(int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int prev = Integer.parseInt(st.nextToken());
			int next = Integer.parseInt(st.nextToken());
			graph[prev].add(next);
			graph[next].add(prev);
		}
		
		visited = new boolean[N + 1];
		isCycle = new boolean[N + 1];
		
		for(int i = 1; i <= N; i++) {
			if(isCycle[i]) continue;
			isCycle(i, i, i);
			Arrays.fill(visited, false);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= N; i++) {
			Arrays.fill(visited, false);
			sb.append(getDistance(i) + " ");
		}
		System.out.println(sb);
	}

	private static int getDistance(int i) {
		visited[i] = true;
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(i);
		int distance = 0;
		while(!q.isEmpty()) {
			int qSize = q.size();
			for(int s = 0; s < qSize; s++) {
				int poll = q.poll();
				visited[poll] = true;
				if(isCycle[poll]) return distance;
				for(int d : graph[poll]) {
					if(!visited[d]) {
						q.offer(d);
					}
				}		
			}
			distance++;
		}
		return -1;
	}

	private static boolean isCycle(int i, int num, int before) {
		
		visited[i] = true;
		
		for(int d : graph[i]) {
			if(visited[d] && d == num && d != before) {
				isCycle[i] = true;
				return true;
			}
			if(!visited[d]) {
				if(isCycle(d, num, i)) {
					isCycle[i] = true;
					return true;
				};
			}
		}
		
		return false;
		
	}
}
