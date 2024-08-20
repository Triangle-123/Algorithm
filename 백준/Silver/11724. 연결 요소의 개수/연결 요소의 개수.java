import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static List<List<Integer>> graph = new ArrayList<>();
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		visited = new boolean[n + 1];
		for(int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i = 0; i < m; i++) {
			int prev = sc.nextInt();
			int next = sc.nextInt();
			graph.get(prev).add(next);
			graph.get(next).add(prev);
		}
		
		int cnt = 0;
		for(int i = 1; i <= n; i++) {
			if(!visited[i]) {
				DFS(i);
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
	
	static void DFS(int root) {
		visited[root] = true;
		
		for(int i = 0; i < graph.get(root).size(); i++) {
			int node = graph.get(root).get(i);
			if(!visited[node]) {
				DFS(node);
			}
		}
	}
}