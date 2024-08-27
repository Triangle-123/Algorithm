import java.util.Scanner;

public class Main {
	
	static int N, M;
	static int[] sel;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		sel = new int[M];
		visited = new boolean[N + 1];
		
		perm(0);
		
		System.out.println(sb);
	}

	private static void perm(int sidx) {
		if(sidx == M) {
			for(int i = 0; i < sel.length; i++) {
				sb.append(sel[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = 1; i <= N; i++) {
			sel[sidx] = i;
			perm(sidx + 1);
		}
	}
}

