import java.io.*;
import java.util.*;

public class Main {
	
	static class Node {
		int V;
		int W;
		Node(int v, int w) {
			V = v;
			W = w;
		}
	}
	
	static class Path {
		int prev;
		int next;
		Path(int prev, int next) {
			this.prev = prev;
			this.next = next;
		}
	}
	
	static List<Node>[] graph;
	static int[] dist;
	static boolean[] visited;
	static List<Integer>[] parent;
	static List<Path> path;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		while(true) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 장소의 수
			int M = Integer.parseInt(st.nextToken()); // 도로의 수
			if(N == 0 && M == 0) break;
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			graph = new ArrayList[N];
			dist = new int[N];
			visited = new boolean[N];
			parent = new ArrayList[N];
			path = new ArrayList<>();
			for(int i = 0; i < N; i++) {
				graph[i] = new ArrayList<>();
				parent[i] = new ArrayList<>();
			}
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int prev = Integer.parseInt(st.nextToken());
				int next = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				graph[prev].add(new Node(next, weight));
			}

			dijkstra(start, end);

			removePath(start, end);
			Arrays.fill(visited, false);
			dijkstra(start, end);				
			if(dist[end] == Integer.MAX_VALUE) dist[end] = -1; 
			sb.append(dist[end] + "\n");
		}
		System.out.println(sb);
	}

	private static void dijkstra(int start, int end) {
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.W - o2.W);
		for(int i = 0; i < dist.length; i++) {
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
					parent[next.V].clear();
					parent[next.V].add(node.V);
				} else if(dist[next.V] == dist[node.V] + next.W) {
					parent[next.V].add(node.V);
				}
			}
		}
	}

	private static void removePath(int start, int end) {
		Queue<Integer> q = new ArrayDeque<>();
		boolean[] visit = new boolean[graph.length];
		q.offer(end);
		
		while(!q.isEmpty()) {
			int poll = q.poll();
			if(poll == start) continue;
			
			for(int p : parent[poll]) {
				for(int i = 0; i < graph[p].size(); i++) {
					Node node = graph[p].get(i);
					if(node.V == poll) {
						graph[p].remove(i--);
					}
				}
					
				if(!visit[p]) {
					visit[p] = true;
					q.offer(p);
				}
			}
		}
		
	}
}