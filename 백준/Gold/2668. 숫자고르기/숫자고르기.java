import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
	static boolean[] visited;
	static int[] graph;
	static List<Integer> startNode = new LinkedList<>();
	static List<Integer> node = new ArrayList<>();
	static List<Integer> maxNode = new ArrayList<>();
	static Set<Integer> set = new HashSet<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		graph = new int[n + 1];
		visited = new boolean[n + 1];
		for(int i = 1; i <= n; i++) {
			int num = sc.nextInt();
			if(num == i) {
				startNode.add(num);
			}
			graph[i] = num;
		}
		
		for(int i = 1; i <= n; i++) {
			node.clear();
			node.addAll(startNode);
			DFS(i, i);
			Arrays.fill(visited, false);
//			if(maxNode.size() < node.size()) {
//				maxNode.clear();
//				maxNode.addAll(node);
//			}
			set.addAll(node);
		}
		maxNode.addAll(set);
		Collections.sort(maxNode);
		int maxSize = maxNode.size();
		System.out.println(maxSize);
		for(int i = 0; i < maxSize; i++) {
			System.out.println(maxNode.get(i)); 
		}
	}

	static void DFS(int root, int start) {
		if(startNode.contains(root)) return;
		if(visited[root]) {
			if(root == start) {
				for(int i = 0; i < visited.length; i++) {
					if(visited[i]) node.add(i);
				}
			}		
			return;
		}
		
		visited[root] = true;
		DFS(graph[root], start);
	}
}
