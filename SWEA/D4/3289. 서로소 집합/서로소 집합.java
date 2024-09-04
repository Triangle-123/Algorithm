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

	private static void union(int x, int y) {
		parents[findSet(y)] = findSet(x);
		
	}

	private static void makeSet() {
		for(int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}
	
	private static int findSet(int x) {
		if(x != parents[x]) {
			parents[x] = findSet(parents[x]);
		}
		return parents[x];
	}
}
