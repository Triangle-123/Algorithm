import java.util.*;
import java.io.*;

public class Main {
	
	static class Node {
		int V;
		int W;
		
		Node(int v, int w) {
			V = v;
			W = w;
		}
	}
	
	static List<Node>[] graph;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		graph = new ArrayList[N + 1];
		for(int i = 0; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		List<Integer> list = new ArrayList<>();
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int prev = Integer.parseInt(st.nextToken());
			int next = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			graph[prev].add(new Node(next, weight));
			graph[next].add(new Node(prev, weight));
			list.add(weight);
		}
		Collections.sort(list);
		int left = 0;
		int right = list.size() - 1;
		int max = 0;
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		while(left <= right) {
			int mid = (left + right) / 2;
			if(BFS(new boolean[N + 1], start, end, list.get(mid))) {
				max = Math.max(max, list.get(mid));
				left = mid + 1;
			} else right = mid - 1;
		}
		System.out.println(max);
		
	}

	private static boolean BFS(boolean[] visited, int start, int end, int mid) {
		Queue<Integer> q = new ArrayDeque<>();
		visited[start] = true;
		q.offer(start);
		while(!q.isEmpty()) {
			int poll = q.poll();
			if(poll == end) return true;
			for(Node node : graph[poll]) {
				if(!visited[node.V] && mid <= node.W) {
					visited[node.V] = true;
					q.offer(node.V);
				}
			}
		}
		return false;
	}
}
