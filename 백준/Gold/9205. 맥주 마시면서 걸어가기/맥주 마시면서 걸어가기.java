import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static List<Integer>[] graph;
	static boolean[] visited;
	static int n;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tCase = sc.nextInt();
		for(int t = 1; t <= tCase; t++) {
			n = sc.nextInt();
			
			int[][] des = new int[n + 2][2];
			for(int i = 0; i < des.length; i++) {
				des[i][0] = sc.nextInt();
				des[i][1] = sc.nextInt();
			}
			
			graph = new ArrayList[n + 2];
			visited = new boolean[n + 2];
			for(int i = 0; i < graph.length; i++) {
				graph[i] = new ArrayList<>();
			}
			
			for(int i = 0; i < des.length - 1; i++) {
				for(int j = i + 1; j < des.length; j++) {
					if(Math.abs(des[i][0] - des[j][0]) + Math.abs(des[i][1] - des[j][1]) <= 1000) { // 꼭 편의점을 순서대로 갈 필요가 없으므로
						graph[i].add(j); // 이 편의점 전에 있는 편의점도 갈수 있도록 서로 추가해준다.
						graph[j].add(i); // 어차피 방문처리하니 웬만하면 서로 추가하자..
					}
				}
			}
			BFS(0);
		}
	}

	static void BFS(int root) {
		visited[root] = true;
		Queue<Integer> q = new LinkedList<>();
		q.offer(root);
		
		while(!q.isEmpty()) {
			int node = q.poll();
			if(node == n + 1) {
				System.out.println("happy");
				return;
			}
			for(int i = 0; i < graph[node].size(); i++) {
				int next = graph[node].get(i);
				if(!visited[next]) {
					q.offer(next);
					visited[next] = true;
				}
			}
		}
		System.out.println("sad");
		return;
	}
}
