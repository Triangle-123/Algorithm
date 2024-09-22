import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
	
	static class Node {
		int A, B, W;
		
		public Node(int a, int b, int w) {
			A = a;
			B = b;
			W = w;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		List<Node>[] list = new ArrayList[N + 1];
		int[] degree = new int[N + 1];
		boolean[] visited = new boolean[N + 1];
		for(int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		for(int i = 0; i < M; i++) {
			int B = sc.nextInt();
			int A = sc.nextInt();
			int W = sc.nextInt();
			
			list[A].add(new Node(A, B, W));
			degree[B]++;
		}
		
		Map<Integer, Node>[] cnt = new TreeMap[N + 1];
		for(int i = 1; i <= N; i++) {
			cnt[i] = new TreeMap<>();
		}
		
		Queue<Integer> q = new ArrayDeque<>();
		for(int i = 1; i <= N; i++) {
			if(degree[i] == 0) {
				cnt[i].put(i, new Node(i, i, 1));
				q.offer(i);
				visited[i] = true;
			}
		}
		
		while(!q.isEmpty()) {
			int i = q.poll();
			visited[i] = true;
			for(Node node : list[i]) {
				for(int n : cnt[node.A].keySet()) {
					if(cnt[node.B].containsKey(n)) cnt[node.B].put(n, new Node(n, node.B, (node.W * cnt[node.A].get(n).W) + cnt[node.B].get(n).W));
					else cnt[node.B].put(n, new Node(n, node.B, node.W * cnt[node.A].get(n).W));
				}
				degree[node.B]--;
			}
			for(int j = 1; j <= N; j++) {
				if(degree[j] == 0 && !visited[j]) {
					q.offer(j);
					visited[j] = true;
				}
			}
		}

		int[] sum = new int[N + 1];
		for(int i : cnt[N].keySet()) {
			sum[cnt[N].get(i).A] += cnt[N].get(i).W;
		}
		for(int i = 1; i <= N; i++) {
			if(sum[i] == 0) continue;
			System.out.println(i + " " + sum[i]);
		}
	}
}


/*
 * 어떻게 저장할까
 * 부품은 순서대로라고 생각하고
 * dp 배열 2차원으로 만들어서
 * degree가 0이 아니면
 * 불러와서 넣기?
 * 
 * 
 * 순서대로가 아닌가본데..
 * 그 와중에 그걸 위상정렬로 넣어야되나
 */
