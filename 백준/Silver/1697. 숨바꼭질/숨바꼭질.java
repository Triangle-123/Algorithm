import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static boolean[] visited = new boolean[100001];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
			
		BFS(n, k);
	}
	static void BFS(int n, int k) {
		visited[n] = true;
		Queue<Integer> q = new LinkedList<>();
		
		q.offer(n);
		int time = 0;
		while(!q.isEmpty()) {
			int qSize = q.size();
			for(int i = 0; i < qSize; i++) {
				int node = q.poll();
				if(node == k) {
					System.out.println(time);
					return;
				}
				int back = node - 1;
				int front = node + 1;
				int blink = node * 2;
				if(back >= 0 && !visited[back]) {
					q.offer(back);
					visited[back] = true;
				}
				if(front <= 100000 && !visited[front]) {
					q.offer(front);
					visited[front] = true;
				}
				if(blink <= 100000 && !visited[blink]) {
					q.offer(blink);
					visited[blink] = true;
				}
			}
			time++;
		}
		
	}
}
