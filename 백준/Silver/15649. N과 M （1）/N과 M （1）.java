import java.util.Scanner;

public class Main {
	
	static int N, M;
	static boolean[] visited;
	static int[] sel;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		visited = new boolean[N + 1];
		sel = new int[M];
		
		perm(0);
	}
	
	static void perm(int sidx) {
		
		if(sidx == M) {
			for(int i = 0; i < sel.length; i++) {
				System.out.print(sel[i] + " ");
			}
			System.out.println();
			return;
		} 
		
		for(int i = 1; i <= N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				sel[sidx] = i;
				perm(sidx + 1);
				visited[i] = false;
			}
		}
	}
}
