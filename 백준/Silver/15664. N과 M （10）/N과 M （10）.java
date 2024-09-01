import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	
	static int N, M;
	static int[] data;
	static int[] sel;
	static StringBuilder sb = new StringBuilder();
	static Set<String> set = new HashSet<>();


	
	
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
			StringBuilder sb2 = new StringBuilder();
			for(int i = 0; i < sel.length; i++) {
				sb2.append(sel[i] + " ");
			}
			if(set.contains(sb2.toString())) return;
			sb.append(sb2.toString());
			set.add(sb2.toString());
			sb.append("\n");
			return;
		}
		if(idx == N) return;

	
		sel[sidx] = data[idx];
		combi(idx + 1, sidx + 1);
		combi(idx + 1, sidx);

	}
}
