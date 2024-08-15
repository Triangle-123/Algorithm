import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int num1;
	static int num2;
	static int[][] graph;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tCase = Integer.parseInt(br.readLine());
		for(int t = 1; t <= tCase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			num1 = Integer.parseInt(st.nextToken());
			num2 = Integer.parseInt(st.nextToken());
			
			graph = new int[v + 1][2];
			visited = new boolean[v + 1];
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i <= e; i++) {
				int node = Integer.parseInt(st.nextToken());
				int child = Integer.parseInt(st.nextToken());
				if(graph[node][0] == 0) graph[node][0] = child; 
				else graph[node][1] = child; 
			}
			
			System.out.print("#" + t + " ");
			order(1);
			System.out.println(subtree(vertex));
			
		}
	}
	
	static int vertex = 0;
	
	static boolean order(int root) {
		if(visited[root]) return false;
		visited[root] = true;
		boolean isLeft = order(graph[root][0]);
		boolean isRight = order(graph[root][1]);
		if(root == num1 || root == num2) return true;
		if(root >= graph.length || (graph[root][0] == 0 && graph[root][1] == 0)) return false;
		if(isLeft && isRight) {
			System.out.print(root + " ");
			vertex = root;
			return false;
		} else if( isLeft || isRight ) {
			return true;
		}
		return false;
	}
	
	static int subtree(int root) {
		if(root == 0) return 0;
		int cnt = 1;
		return cnt + subtree(graph[root][0]) + subtree(graph[root][1]);
		
	}
}