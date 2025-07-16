import java.util.*;
import java.io.*;

public class Main {
	static int[] parent;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		List<Integer>[] tree = new ArrayList[N + 1];
		parent = new int[N + 1];
		for(int i = 1; i <= N; i++) {
			tree[i] = new ArrayList<>();
		}
		for(int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int prev = Integer.parseInt(st.nextToken());
			int next = Integer.parseInt(st.nextToken());
			tree[prev].add(next);
			tree[next].add(prev);
		}
		boolean[] visited = new boolean[N + 1];
		
		DFS(1, visited, tree);
		StringBuilder sb = new StringBuilder();
		for(int i = 2; i <= N; i++) {
			sb.append(parent[i] + "\n");
		}
		System.out.println(sb);
	}

	private static void DFS(int i, boolean[] visited, List<Integer>[] tree) {
		if(visited[i]) return;
		visited[i] = true;
		for(int j = 0; j < tree[i].size(); j++) {
			int next = tree[i].get(j);
			if(!visited[next]) {
				parent[next] = i;
				DFS(next, visited, tree);
			}
		}
		
	}
}
