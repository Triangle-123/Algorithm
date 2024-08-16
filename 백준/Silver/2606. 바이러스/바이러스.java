import java.util.*;
import java.io.*;

public class Main {
	
	static List<List<Integer>> graph;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int l = Integer.parseInt(br.readLine());
		
		graph = new LinkedList<>();
		visited = new boolean[n + 1];
		
		for(int i = 0; i <= n; i++) {
			graph.add(new LinkedList<>());
		}
		for(int i = 0; i < l; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int prev = Integer.parseInt(st.nextToken());
			int next = Integer.parseInt(st.nextToken());
			graph.get(prev).add(next);
			graph.get(next).add(prev);
		}
		
		BFS(1);
		System.out.println(cnt);
		
		
	}
	
	static int cnt = -1;
	static Queue<Integer> q = new LinkedList<>();
	
	static void BFS(int root) {
		if(visited[root]) return;
		visited[root] = true;
		
		cnt++;
		
		for(int j = 0; j < graph.get(root).size(); j++) {
			int node = graph.get(root).get(j);
			if(!visited[node]) {
				q.add(node);
			}
		}
		
		while(!q.isEmpty()) {
			BFS(q.poll());
		}
	}
}
