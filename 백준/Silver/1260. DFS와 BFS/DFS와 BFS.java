import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static List<List<Integer>> graph;
	static boolean[] visitedDFS;
	static boolean[] visitedBFS;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int v = sc.nextInt();
		
		graph = new LinkedList<>();
		visitedDFS = new boolean[n + 1];
		visitedBFS = new boolean[n + 1];
		for(int i = 0; i <= n; i++) {
			graph.add(new LinkedList<>());
		}
		for(int i = 1; i <= m; i++) {
			int prev = sc.nextInt();
			int next = sc.nextInt();
			graph.get(prev).add(next);
			graph.get(next).add(prev);
		}
		
		for(int i = 1; i <= n; i++) {
			Collections.sort(graph.get(i));
		}
		
		DFS(v);
		System.out.println();
		
		qBFS.offer(v);
		visitedBFS[v] = true;
		BFS(qBFS.poll());
		
		
	}

	static void DFS(int v) {
		if(visitedDFS[v]) return;
		visitedDFS[v] = true;
		System.out.print(v + " ");
		for(int i = 0; i < graph.get(v).size(); i++) {
			DFS(graph.get(v).get(i));
		}
	}
	
	static Queue<Integer> qBFS = new LinkedList<>();
	
	static void BFS(int v) {
		System.out.print(v + " ");
		
		for(int j = 0; j < graph.get(v).size(); j++) {
			int child = graph.get(v).get(j);
			if(!visitedBFS[child]) {
				visitedBFS[child] = true;
				qBFS.offer(child);
			}
		}
		if(qBFS.isEmpty()) return;
		else BFS(qBFS.poll());
	}
}
