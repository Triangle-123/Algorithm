import java.util.Scanner;

public class Solution {
	
	static int[] parents;
	static int N, M;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tCase = sc.nextInt();
		
		for(int t = 1; t <= tCase; t++) {
			N = sc.nextInt(); // 정점의 개수
			M = sc.nextInt(); // 연산의 개수
			
			parents = new int[N + 1];
			makeSet();
			
			StringBuffer sb = new StringBuffer(); // 출력 결과 담기
			
			for(int i = 0; i < M; i++) {
				int C = sc.nextInt();
				int A = sc.nextInt();
				int B = sc.nextInt();
				
				if(C == 0) union(A, B); // 합치기
				else if(findSet(A) == findSet(B)) sb.append(1); // 두 집합이 같은 집합에 있는지 체크, 같으면 1 다르면 0
				else sb.append(0);
			}
			
			System.out.println("#" + t + " " + sb);
		}
	}

	private static boolean union(int x, int y) { // 합치는 연산 (y가 x를 가리키도록)
//		parents[findSet(y)] = findSet(x);
		
		int xRoot = findSet(x);  // 크루스칼 알고리즘의 사이클 체크(union에 find를 넣으면 되는구나)
		int yRoot = findSet(y);
		if(xRoot == yRoot) return false;
		parents[yRoot] = xRoot;
		return true;
	}

	private static void makeSet() { // 서로소 집합 만들기
		for(int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}
	
	private static int findSet(int x) { // Pass Compression 방식의 find (노드 정보 갱신으로 같은 연산 반복할 때 바로 반환) 
		if(x != parents[x]) {
			parents[x] = findSet(parents[x]);
		}
		return parents[x];
	}
}