import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static int N;
	static int[] people;
	static List<Integer>[] edge;
	static boolean[] sel;
	static int[] p;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		people = new int[N + 1];
		
		for(int i = 1; i <= N; i++) {
			people[i] = sc.nextInt();
		}
		
		edge = new ArrayList[N + 1];
		
		for(int i = 1; i <= N; i++) {
			edge[i] = new ArrayList<>();
			int line = sc.nextInt();
			for(int j = 0; j < line; j++) {
				edge[i].add(sc.nextInt());
			}
		}
		
		p = new int[N + 1];
		sel = new boolean[N + 1];
		power(1);
		
		if(min == Integer.MAX_VALUE) min = -1;
		System.out.println(min);
	}

	private static void power(int idx) {
		
		if(idx == N + 1) {
			List<Integer> sel1 = new ArrayList<>();
			List<Integer> sel2 = new ArrayList<>();
			for(int i = 1; i <= N; i++) {
				if(sel[i]) sel1.add(i);
				else sel2.add(i);
			}
			if(sel1.isEmpty() || sel2.isEmpty()) return;
			makeSet();
			for(int i = 0; i < sel1.size(); i++) {
				for(int j = 0; j < sel1.size(); j++) {
					int A = sel1.get(i);
					int B = sel1.get(j);
					if(edge[A].contains(B)) {
						union(A, B);
					}
				}
			}
			int find = find(sel1.get(0));
			for(int i = 1; i < sel1.size(); i++) {
				if(find != find(sel1.get(i))) return;
			}
			for(int i = 0; i < sel2.size(); i++) {
				for(int j = 0; j < sel2.size(); j++) {
					int A = sel2.get(i);
					int B = sel2.get(j);
					if(edge[A].contains(B)) {
						union(A, B);
					}
				}
			}
			find = find(sel2.get(0));
			for(int i = 1; i < sel2.size(); i++) {
				if(find != find(sel2.get(i))) return;
			}
			
			int sum1 = 0;
			int sum2 = 0;
			for(int i = 0; i < sel1.size(); i++) {
				sum1 += people[sel1.get(i)];
			}
			for(int i = 0; i < sel2.size(); i++) {
				sum2 += people[sel2.get(i)];
			}
			
			min = Math.min(min, Math.abs(sum1 - sum2));
			return;
		}
		
		sel[idx] = true;
		power(idx + 1);
		sel[idx] = false;
		power(idx + 1);
		
	}

	private static void union(int x, int y) {
		int xRoot = find(x);
		int yRoot = find(y);
		
		if(xRoot != yRoot) {
			p[yRoot] = xRoot;
		}
		
	}

	private static int find(int x) {
		if(x != p[x]) {
			p[x] = find(p[x]);
		}
		return p[x];
	}

	private static void makeSet() {
		for(int i = 1; i <= N; i++) {
			p[i] = i;
		}
	}
}