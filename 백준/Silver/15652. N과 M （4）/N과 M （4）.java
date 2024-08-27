import java.util.Scanner;

public class Main {
	
	static int N, M;
	static int[] sel;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		sel = new int[M];
		
		combi(1, 0);
	}

	private static void combi(int idx, int sidx) {
		if(sidx == M) {
			for(int i = 0; i < sel.length; i++) {
				System.out.print(sel[i] + " ");
			}
			System.out.println();
			return;
		}
		if(idx == N + 1) return;
		
		sel[sidx] = idx;
		combi(idx, sidx + 1);
		combi(idx + 1, sidx);
		
		
	}
}
