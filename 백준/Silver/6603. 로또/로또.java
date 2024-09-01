import java.util.Scanner;

public class Main {
	static int K;
	static int R = 6;
	static int[] S;
	static int[] sel = new int[R];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		K = sc.nextInt();
		while(K != 0) {
			S = new int[K];
			for(int i = 0; i < K; i++) {
				S[i] = sc.nextInt();
			}
			
			combi(0, 0);
			System.out.println(sb);
			K = sc.nextInt();
			sb.delete(0, sb.length());
		}
	}

	private static void combi(int idx, int sidx) {
		if(sidx == R) {
			for(int i = 0; i < sel.length; i++) {
				sb.append(sel[i] + " ");
			}
			sb.append("\n");
			return;
		}
		if(idx == K) return;
		
		sel[sidx] = S[idx];
		combi(idx + 1, sidx + 1);
		combi(idx + 1, sidx);
	}
}
