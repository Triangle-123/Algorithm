import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static class Node {
		int A, B, W;
		
		public Node(int a, int b,  int w) {
			A = a;
			B = b;
			W = w;
		}
	}
	
	static int[] p;
	static int[] dist;
	static int N, M;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		List<Node> list = new ArrayList<>();
		p = new int[N + 1];
		for(int i = 0; i < M; i++) {
			list.add(new Node(sc.nextInt(), sc.nextInt(), sc.nextInt()));
		}
		
		list.sort((o1, o2) -> o1.W - o2.W);
		
		makeSet();
		
		int sum = 0;
		int max = 0;
		int size = list.size();
		for(int i = 0; i < size; i++) {
			int A = list.get(i).A;
			int B = list.get(i).B;
			
			if(union(A, B)) {
				sum += list.get(i).W;
				max = Math.max(max, list.get(i).W);
			} 
		}
		
		System.out.println(sum - max);
		
	}

	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot != bRoot) {
			p[bRoot] = aRoot;
			return true;
		}
		return false;
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
// 크루스칼로 최소 신장트리 구해놓고
// 가중치가 제일 큰곳을 자르면?
// 되려나
// 크루스칼은 간선배열 작성후
// 배열을 오름차순 정렬하고
// Union-Find 사용