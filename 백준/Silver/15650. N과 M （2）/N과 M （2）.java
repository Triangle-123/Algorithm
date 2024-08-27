import java.util.Scanner;

public class Main {
	static int N, M;
	static int[] sel;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		sel = new int[M];
		
		comb(0, 0);
	}
	
	static void comb(int idx, int sidx) {
		
		if(sidx == M) {
			for(int i = 0; i < sel.length; i++) {
				System.out.print(sel[i] + " ");
			}
			System.out.println();
			return;
		}
		if(idx == N) {
			return;
		}
		
		sel[sidx] = idx + 1;
		comb(idx + 1, sidx + 1);
		comb(idx + 1, sidx);
		
		
		
		
	}
}
