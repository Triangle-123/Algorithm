import java.util.ArrayList;
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
	
	static int N, M;
	
	static List<Node>[] graph;
	static int[] dist;
	static boolean[] visited;
	static PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.W - o2.W);
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		graph = new ArrayList[N + 1];
		dist = new int[N + 1];
		visited = new boolean[N + 1];
		for(int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		for(int i = 0; i < M; i++) {
			graph[sc.nextInt()].add(new Node(sc.nextInt(), sc.nextInt()));
		}
		int start = sc.nextInt();
		int end = sc.nextInt();
		
		dijkstra(start);
		System.out.println(dist[end]);
	}

	private static void dijkstra(int start) {
		for(int i = 1; i <= N; i++) {
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
