import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
	
	static int N, E;
	
	static class Edge {
		int A, B;
		long W;

		public Edge(int a, int b, long w) {
			super();
			A = a;
			B = b;
			W = w;
		}

		@Override
		public String toString() {
			return "Edge [A=" + A + ", B=" + B + ", W=" + W + "]";
		}
		
		
		
	}
	
	static int[] p;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tCase = sc.nextInt();
		
		for(int t = 1; t <= tCase; t++) {
			N = sc.nextInt();
			E = route(N - 1);
			
			p = new int[N];
			
			for(int i = 0; i < N; i++) {
				p[i] = i;
			}
			int[][] position = new int[2][N];
			
			for(int i = 0; i < position.length; i++) {
				for(int j = 0; j < position[i].length; j++) {
					position[i][j] = sc.nextInt();
				}
			}
			
			double e = sc.nextDouble();
			
			Edge[] edges = new Edge[E];
			int idx = 0;
			for(int i = 0; i < N - 1; i++) {
				for(int j = i + 1; j < N; j++) {
					
					long dis1 = (long)(position[0][i] - position[0][j]) * (position[0][i] - position[0][j]);
					long dis2 = (long)(position[1][i] - position[1][j]) * (position[1][i] - position[1][j]);
					
					edges[idx++] = new Edge(i, j, (dis1 + dis2));
				}
			}
			
			Arrays.sort(edges, new Comparator<Edge>() {

				@Override
				public int compare(Edge o1, Edge o2) {
					return Long.compare(o1.W, o2.W);
				}
				
			});
			
			double sum = 0;
			int cnt = 0;
			for(int i = 0; i < E; i++) {
				if(cnt == N - 1) break;
				if(union(edges[i].A, edges[i].B)) {
					sum += e * ((long)edges[i].W);
					cnt++;
				}
			}
			System.out.println("#" + t + " " + (long)Math.round(sum));
		}
	}
	
	private static boolean union(int x, int y) {
		int xRoot = find(x);
		int yRoot = find(y);
		
		if(xRoot == yRoot) return false;
		p[yRoot] = xRoot;
		return true;
	}

	private static int find(int x) {
		if(x != p[x]) {
			p[x] = find(p[x]);
		}
		return p[x];
	}

	static int route(int r) {
		if(r == 1) return 1;
		return r + route(r - 1);
	}
}
