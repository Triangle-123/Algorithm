import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int N, M;
	static int[] data;
	static int[] sel;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		data = new int[N];
		visited = new boolean[N];
		sel = new int[M];
		
		for(int i = 0; i < N; i++) {
			data[i] = sc.nextInt();
		}
		Arrays.sort(data);
		
		perm(0);
		System.out.println(sb);
 	}

	private static void perm(int idx) {
		if(idx == M) {
			for(int i = 0; i < sel.length; i++) {
				sb.append(sel[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = 0; i < N; i++) {
			sel[idx] = data[i];
			perm(idx + 1);
		}
	}
}
