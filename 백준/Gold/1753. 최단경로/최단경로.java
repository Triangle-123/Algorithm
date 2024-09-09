import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	static class Node {
		int V, W;

		public Node(int v, int w) {
			super();
			V = v;
			W = w;
		}	
	}
	
	static List<Node>[] graph;
	static boolean[] visited;
	static int[] dist;
	static int V, E;
	static PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.W - o2.W);
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();
		int K = sc.nextInt();
		
		graph = new ArrayList[V + 1];
		for(int i = 1; i <= V; i++) {
			graph[i] = new ArrayList<>();
		}
		
		dist = new int[V + 1];
		visited = new boolean[V + 1];
		
		for(int i = 0; i < E; i++) {
			graph[sc.nextInt()].add(new Node(sc.nextInt(), sc.nextInt()));
		}
		
		dijkstra(K);
        StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= V; i++) {
			if(dist[i] == Integer.MAX_VALUE) sb.append("INF\n");
			else sb.append(dist[i]).append("\n");
		}
        System.out.println(sb);
	}

	private static void dijkstra(int start) {
		for(int i = 1; i <= V; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		dist[start] = 0;
		pq.offer(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			if(visited[node.V]) continue;
			visited[node.V] = true;
			
			for(Node next : graph[node.V]) {
				if(!visited[next.V] && dist[next.V] > dist[node.V] + next.W) {
					dist[next.V] = dist[node.V] + next.W;
					pq.offer(new Node(next.V, dist[next.V]));
				}
			}
		}
		
	}
}
