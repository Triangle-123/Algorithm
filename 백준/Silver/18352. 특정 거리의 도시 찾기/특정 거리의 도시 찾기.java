import java.util.*;
import java.io.*;

public class Main {
	
	static class Node {
		int v;
		int w;
		
		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}
	
	static int N, M, K, X;
	static List<Node>[] graph;
	static int[] dist;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N + 1];
		dist = new int[N + 1];
		visited = new boolean[N + 1];
		for(int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
			dist[i] = Integer.MAX_VALUE;
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int prev = Integer.parseInt(st.nextToken());
			int next = Integer.parseInt(st.nextToken());
			graph[prev].add(new Node(next, 1));
		}
		
		dijkstra(X);
		
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= N; i++) {
			if(dist[i] == K) sb.append(i + "\n");
		}
		if(sb.toString().equals("")) {
			sb.append(-1);
		}
		System.out.println(sb);
	}

	private static void dijkstra(int x) {
		
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
		dist[x] = 0;
		pq.offer(new Node(x, 0));
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			if(visited[node.v]) continue;
			visited[node.v] = true;
			
			for(Node next : graph[node.v]) {
				if(!visited[next.v] && dist[next.v] > dist[node.v] + next.w) {
					dist[next.v] = dist[node.v] + next.w;
					pq.offer(new Node(next.v, dist[next.v]));
				}
			}
		}
	}
}
