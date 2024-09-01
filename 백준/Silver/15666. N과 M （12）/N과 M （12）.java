import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N, M;
	static int[] data;
	static int[] sel;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		data = new int[N];
		sel = new int[M];
		for(int i = 0; i < N; i++) {
			data[i] = sc.nextInt();
		}
		Arrays.sort(data);
		combi(0, 0);
		System.out.println(sb);
	}

	private static void combi(int idx, int sidx) {
		
		if(sidx == M) {
			for(int i = 0; i < sel.length; i++) {
				sb.append(sel[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		int before = 0;
		for(int i = idx; i < N; i++) {
			if(before != data[i]) {
				sel[sidx] = data[i];
				before = data[i];
				combi(i, sidx + 1);
			}
		}
	}
}
