import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static List<Integer>[] graph;
	static List<Integer> hacking = new ArrayList<>();
	static boolean[] visited;
	static Queue<Integer> q = new LinkedList<>();
	static int cnt = 0;
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		graph = new ArrayList[n + 1];
		
		for(int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < m; i++) {
			int prev = sc.nextInt();
			int next = sc.nextInt();
			graph[next].add(prev);
		}
		
		int max = 0;
		hacking.add(0);
		for(int i = 1; i <= n; i++) {
			visited = new boolean[n + 1];
			visited[i] = true;
			q.offer(i);
			while(!q.isEmpty()) {
				int poll = q.poll();
				for(int j = 0; j < graph[poll].size(); j++) {
					int node = graph[poll].get(j);
					if(!visited[node]) {
						q.offer(node);
						cnt++;
						visited[node] = true;
					}	
				}
			}
			hacking.add(cnt);
			max = Math.max(max, cnt);
			cnt = 0;
		}
		
		for(int i = 1; i <= n; i++) {
			if(hacking.get(i) == max) {
				System.out.print(i + " ");
			}
		}
	}
	
}
