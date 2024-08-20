import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static List<List<Integer>> graph = new ArrayList<>();
	static boolean[] visited;
	static int sum = 0;
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
		
		int min = 30000;
		int minIdx = 0;
		for(int i = 1; i <= n; i++) {
			BFS(i);
			if(min > sum) {
				min = sum;
				minIdx = i;
			}
			sum = 0;
			Arrays.fill(visited, false);
		}
		
		System.out.println(minIdx);
	}
	
	
	static void BFS(int i) {
		visited[i] = true;
		Queue<Integer> q = new LinkedList<>();
		
		q.offer(i);
		
		int level = 1;
		while(!q.isEmpty()) {
			int qSize = q.size();
			for(int j = 0; j < qSize; j++) {
				int node = q.poll();
				for(int n = 0; n < graph.get(node).size(); n++) {
					int nextNode = graph.get(node).get(n);
					if(!visited[nextNode]) {
						q.offer(nextNode);
						visited[nextNode] = true;
						sum += level;
					}
				}
			}
			level++;
		}
		
	}
}
