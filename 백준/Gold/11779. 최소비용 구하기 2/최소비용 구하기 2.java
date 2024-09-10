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
	
	static List<Node>[] graph;
	static int[] dist;
	static int[] p;
	static boolean[] visited;
	static int N, M;
	static PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.W - o2.W);
	static List<Integer> route = new ArrayList<>();
	static int end;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		graph = new ArrayList[N + 1];
		dist = new int[N + 1];
		p = new int[N + 1];
		visited = new boolean[N + 1];
		for(int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			graph[sc.nextInt()].add(new Node(sc.nextInt(), sc.nextInt()));
		}
		
		int start = sc.nextInt();
		end = sc.nextInt();
		
		dijkstra(start);
		System.out.println(dist[end]);
		route.add(end);
		int v = end;
		while(p[v] != -1) {
			route.add(p[v]);
			v = p[v];
		}
		System.out.println(route.size());
		for(int i = route.size() - 1; i >= 0; i--) {
			System.out.print(route.get(i) + " ");
		}
	}

	private static void dijkstra(int start) {
		for(int i = 1; i <= N; i++) {
			dist[i] = Integer.MAX_VALUE;
			p[i] = -1;
		}
		dist[start] = 0;
		pq.offer(new Node(start, 0));
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			if(node.V == end) return;
			if(visited[node.V]) continue;
			visited[node.V] = true;
			for(Node next : graph[node.V]) {
				if(!visited[next.V] && dist[next.V] > dist[node.V] + next.W) {
					dist[next.V] = dist[node.V] + next.W;
					p[next.V] = node.V;
					pq.offer(new Node(next.V, dist[next.V]));
				}
			}
		}
		
	}
}
