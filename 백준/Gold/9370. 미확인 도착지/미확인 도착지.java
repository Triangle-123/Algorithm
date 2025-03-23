import java.util.*;
import java.io.*;

public class Main {
	
	static class Node {
		int V;
		int W;
		boolean passed;
		Node(int v, int w) {
			V = v;
			W = w;
		}
		Node(int v, int w, boolean passed) {
			V = v;
			W = w;
			this.passed = passed;
		}
	}
	
	static boolean[] visited;
	static int[] dist;
	static List<Node>[] graph;
	static List<Integer> result;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tCase = 1; tCase <= T; tCase++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); // 교차로(정점) 개수
			int m = Integer.parseInt(st.nextToken()); // 도로(간선) 개수
			int t = Integer.parseInt(st.nextToken()); // 목적지 후보 개수
			
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()); // 출발지점
			int g = Integer.parseInt(st.nextToken()); // 반드시 지나는 도로의 정점 1
			int h = Integer.parseInt(st.nextToken()); // 반드시 지나는 도로의 정점 2
			
			graph = new ArrayList[n + 1];
			for(int i = 1; i <= n; i++) {
				graph[i] = new ArrayList<>();
			}
			dist = new int[n + 1];
			visited = new boolean[n + 1];
			for(int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int prev = Integer.parseInt(st.nextToken());
				int next = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				weight *= 2;
				if((prev == g && next == h) || (prev == h && next == g)) {
					weight -= 1;
				}
				graph[prev].add(new Node(next, weight));
				graph[next].add(new Node(prev, weight));
			}
			List<Integer> target = new ArrayList<>();
			for(int i = 0; i < t; i++) {
				target.add(Integer.parseInt(br.readLine()));
			}
			result = new ArrayList<>();
			dijkstra(s, g, h);
			result.sort((o1, o2) -> o1 - o2);
			for(int i = 0; i < result.size(); i++) {
				if(target.contains(result.get(i))) {
					sb.append(result.get(i) + " ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static void dijkstra(int start, int g, int h) {
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
			if(node.passed) {
				result.add(node.V);
			}
			for(Node next : graph[node.V]) {
				if(dist[next.V] >= dist[node.V] + next.W) {
					dist[next.V] = dist[node.V] + next.W;
					if((node.V == g && next.V == h) || (node.V == h && next.V == g)) {
						pq.offer(new Node(next.V, dist[next.V], true));
					}
					else pq.offer(new Node(next.V, dist[next.V], node.passed));
				}
			}
		}
	}
}