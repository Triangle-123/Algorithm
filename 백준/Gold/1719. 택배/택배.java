import java.util.ArrayList;
import java.util.Arrays;
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
	static int N, M;
	static List<Node>[] graph;
	static int[] dist;
	static boolean[] visited;
	static int[] p;
	static PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.W - o2.W);
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		graph = new ArrayList[N + 1];
		dist = new int[N + 1];
		visited = new boolean[N + 1];
		p = new int[N + 1];
		
		for(int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int W = sc.nextInt();
			
			graph[A].add(new Node(B, W));
			graph[B].add(new Node(A, W));
		}
		
		int[][] route = new int[N + 1][N + 1];
		for(int i = 1; i <= N; i++) {
			dijkstra(i);
			Arrays.fill(visited, false);
			for(int j = 1; j <= N; j++) {
				route[i][j] = find(j, i);
			}
		}
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if(route[i][j] == 0) System.out.print("-" + " ");
				else System.out.print(route[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	
	
	private static int find(int x, int i) {
		
		if(x != p[x]) {
			if(p[x] == i) p[x] = x;
			else p[x] = find(p[x], i);
		}
		return p[x];
	}



	private static void dijkstra(int start) {
		for(int i = 1; i <= N; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		Arrays.fill(p, 0);
		dist[start] = 0;
		pq.offer(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
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
