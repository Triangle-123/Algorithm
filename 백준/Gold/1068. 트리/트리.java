import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static List<Integer>[] graph;
	static boolean[] visited;
	static int delete;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		graph = new ArrayList[n];
		visited = new boolean[n];
		for(int i = 0; i < n; i++) {
			graph[i] = new ArrayList<>(); 
		}
		
		List<Integer> rootNode = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			int parent = sc.nextInt();
			if(parent == -1) {
				rootNode.add(i);
				continue;
			}
			graph[parent].add(i);
		}
		delete = sc.nextInt();
		graph[delete].clear();
		
		for(int i = 0; i < rootNode.size(); i++) {
			if(rootNode.get(i) != delete) DFS(rootNode.get(i));
		}
		
		System.out.println(cnt);
	}
	
	static int cnt = 0;
	static void DFS(int root) {
		visited[root] = true;
		if(root == delete) return;
		if(graph[root].isEmpty()) cnt++;
		else if(graph[root].size() == 1 && graph[root].get(0) == delete) {
			cnt++;
			return;
		}
		for(int i = 0; i < graph[root].size(); i++) {
			int node = graph[root].get(i);
			if(!visited[node]) {
				DFS(node);
			}
		}
	}
}
