import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	
	static class Node {
		int V, W;
		
		public Node(int v, int w) {
			V = v;
			W = w;
		}
	}
	
	static int V, E;
	static List<Node>[] graph;
	static int[] dist;
	static PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.W - o2.W);
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();
		graph = new ArrayList[V + 1];
		dist = new int[V + 1];
		for(int i = 1; i <= V; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int W = sc.nextInt();
			graph[A].add(new Node(B, W));
			graph[B].add(new Node(A, W));
		}
		
		int u = sc.nextInt();
		int v = sc.nextInt();
		
		long distance = 0;
		int com1 = 0;
		int com2 = 0;
		dijkstra(1);
		com1 += dist[u];
		dijkstra(u);
		com1 += dist[v];
		dijkstra(v);
		if(dist[V] == Integer.MAX_VALUE) {
			System.out.println(-1);
			System.exit(0);
		}
		com1 += dist[V];
		
		dijkstra(1);
		com2 += dist[v];
		dijkstra(v);
		com2 += dist[u];
		dijkstra(u);
		if(dist[V] == Integer.MAX_VALUE) {
			System.out.println(-1);
			System.exit(0);
		}
		com2 += dist[V];
		
		distance = Math.min(com1, com2);
		System.out.println(distance);
	
		
	}


	private static void dijkstra(int start) {
		for(int i = 1; i <= V; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		dist[start] = 0;
		pq.offer(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			
			for(Node next : graph[node.V]) {
				if(dist[next.V] > dist[node.V] + next.W) {
					dist[next.V] = dist[node.V] + next.W;
					pq.offer(new Node(next.V, dist[next.V]));
				}
			}
		}
		
	}
}
