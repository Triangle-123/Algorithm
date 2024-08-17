import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static List<List<Integer>> prev;
	static List<List<Integer>> next;
	static boolean[] visited;
	static int node1, node2;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		node1 = Integer.parseInt(st.nextToken());
		node2 = Integer.parseInt(st.nextToken());
		
		prev = new LinkedList<>();
		next = new LinkedList<>();
		visited = new boolean[n + 1];
		for(int i = 0; i <= n; i++) {
			prev.add(new LinkedList<>());
			next.add(new LinkedList<>());
		}
		
		int m = Integer.parseInt(br.readLine());
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int parent = Integer.parseInt(st.nextToken());
			int child = Integer.parseInt(st.nextToken());
			next.get(parent).add(child);
			prev.get(child).add(parent);
		}
		
		int result = DFS(node1);
		if(related) System.out.println(result);
		else System.out.println(-1);
	}

	static boolean related = false;
	
	static int DFS(int root) {
		if(visited[root]) return 0;
		visited[root] = true;
		
		int cnt = 0;
		
		if(next.get(root).contains(node2) || prev.get(root).contains(node2)) {
			related = true;
			return ++cnt;
		}
		else if(next.get(root).isEmpty() && root != node1) return cnt;
		
		
		for(int i = 0; i < next.get(root).size(); i++) {
			cnt += DFS(next.get(root).get(i));
			if(related) return ++cnt;
		}
		
		if(!prev.get(root).isEmpty()) {
			cnt += DFS(prev.get(root).get(0));
		}
		
		if(related) return ++cnt;
		else return 0;
	}
}
