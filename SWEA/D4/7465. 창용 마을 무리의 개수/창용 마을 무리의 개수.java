import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	
	static class Edge {
		int A, B;

		public Edge(int a, int b) {
			super();
			A = a;
			B = b;
		}
	}
	
	static int N, M;
	static int[] p;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tCase = sc.nextInt();
		for(int t = 1; t <= tCase; t++) {
			N = sc.nextInt();
			M = sc.nextInt();
			
			p = new int[N + 1];
			Edge[] edges = new Edge[M];
			
			for(int i = 1; i <= N; i++) {
				p[i] = i;
			}
			
			for(int i = 0; i < M; i++) {
				edges[i] = new Edge(sc.nextInt(), sc.nextInt());
			}
			
			for(int i = 0; i < M; i++) {
				union(edges[i].A, edges[i].B);
			}
			
			Set<Integer> set = new HashSet<>();
			for(int i = 1; i <= N; i++) {
				set.add(find(i));
			}
			System.out.println("#" + t + " " + set.size());
		}
	}

	private static boolean union(int a, int b) {
		
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) return false;
		p[bRoot] = aRoot;
		return true;
		
	}

	private static int find(int x) {
		if(x != p[x]) {
			p[x] = find(p[x]);
		}
		return p[x];
	}
}
