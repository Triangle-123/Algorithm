import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, M, minTime, way;
	static boolean[] visited = new boolean[100001];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		minTime = Integer.MAX_VALUE;
		way = 0;
		BFS(N);
		System.out.println(minTime);
		System.out.println(way);
	}
	private static void BFS(int i) {
		Queue<Integer> q = new ArrayDeque<>();
		visited[i] = true;
		q.offer(i);
		int time = 0;
		while(!q.isEmpty()) {
			if(time > minTime) return;
			int qSize = q.size();
			for(int j = 0; j < qSize; j++) {
				int x = q.poll();
				if(x == M) {
					if(minTime > time) {
						minTime = time;
						way = 1;
					} else if(minTime == time) {
						way++;
					}
				}
				int x1 = x - 1;
				int x2 = x + 1;
				int x3 = x * 2;
				if(x1 >= 0 && !visited[x1]) {
					q.offer(x1);
//					if(x1 != M) visited[x1] = true;
				}
				if(x2 < visited.length && !visited[x2]) {
					q.offer(x2);
//					if(x2 != M) visited[x2] = true;
				}
				if(x3 < visited.length && !visited[x3]) {
					q.offer(x3);
//					if(x3 != M) visited[x3] = true;
				}
				visited[x] = true;
			}
			time++;
		}
	}
}
