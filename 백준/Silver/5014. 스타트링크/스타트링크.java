import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static boolean[] visited;
	static int f;
	static int u;
	static int d;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		f = sc.nextInt();
		int s = sc.nextInt();
		int g = sc.nextInt();
		u = sc.nextInt();
		d = sc.nextInt();
		
		visited = new boolean[f + 1];
		BFS(s, g);
				
	}

	static void BFS(int s, int g) {
		visited[s] = true;
		Queue<Integer> q = new LinkedList<>();
		
		q.offer(s);
		int cnt = 0;
		
		
		
		while(!q.isEmpty()) {
			int qSize = q.size();
			for(int i = 0; i < qSize; i++) {
				int node = q.poll();
				if(node == g) {
					System.out.println(cnt);
					return;
				}
				
				int up = node + u;
				int down = node - d;
				if(up <= f && !visited[up]) {
					q.offer(up);
					visited[up] = true;
				}
				if(down >= 1 && !visited[down]) {
					q.offer(down);
					visited[down] = true;
				}
						
			}
			cnt++;
		}
		
		System.out.println("use the stairs");
		
		
	}
}
