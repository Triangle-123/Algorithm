import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	
	static int maxDepth;
	static int maxNum;
	static boolean[] visited;
	static List<Integer>[] list;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int t = 1; t <= 10; t++) {
			int n = sc.nextInt() / 2;
			int start = sc.nextInt();
			list = new ArrayList[101];
			visited = new boolean[101];
			for(int i = 0; i <= 100; i++) {
				list[i] = new ArrayList<>();
			}
			
			for(int i = 0; i < n; i++) {
				list[sc.nextInt()].add(sc.nextInt());
			}
			
			maxDepth = 0;
			maxNum = 0;
			BFS(start);
			System.out.println("#" + t + " " + maxNum);
		}
	}

	private static void BFS(int start) {
		visited[start] = true;
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		int depth = 0;
		while(!q.isEmpty()) {
			int qSize = q.size();
			for(int i = 0; i < qSize; i++) {
				int node = q.poll();
				
				boolean offered = false;
				
				for(int j = 0; j < list[node].size(); j++) {
					int next = list[node].get(j);
					if(!visited[next]) {
						q.offer(next);
						visited[next] = true;
						offered = true;
					}
						
				}
					
				if(!offered) {
					if(maxDepth == depth) {
						maxNum = Math.max(maxNum, node);
					} else {
						maxDepth = Math.max(maxDepth, depth);
						if(maxDepth == depth) maxNum = node;
					}
				}
				
			}
			depth++;
		}
	}
}