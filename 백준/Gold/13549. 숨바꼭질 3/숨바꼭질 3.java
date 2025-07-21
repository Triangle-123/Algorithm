import java.util.*;
import java.io.*;

public class Main {
	
	static int time = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		BFS(N, K);
		System.out.println(time);
	}

	private static void BFS(int n, int k) {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(n);
		int[] visited = new int[200001];
		Arrays.fill(visited, -1);;
		visited[n] = 0;
		while(!q.isEmpty()) {
			int qSize = q.size();
			for(int s = 0; s < qSize; s++) {
				int x = q.poll();
				if(x == k) {
					time = Math.min(time, visited[x]);
				}
				int front = x + 1;
				int back = x - 1;
				int teleport = x * 2;
				if(front <= 100000 && (visited[front] == -1 || visited[front] > visited[x] + 1)) {
					q.offer(front);
					visited[front] = visited[x] + 1;
				}
				if(back >= 0 && (visited[back] == -1 || visited[back] > visited[x] + 1)) {
					q.offer(back);
					visited[back] = visited[x] + 1;
				}
				if(teleport <= 200000 && (visited[teleport] == -1 || visited[teleport] > visited[x])) {
					q.offer(teleport);
					visited[teleport] = visited[x];
				}
			}
		}
	}
}
