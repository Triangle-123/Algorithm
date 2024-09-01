import java.util.Scanner;

public class Main {
	static int N;
	static int[] data;
	static int[] sel;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		data = new int[N];
		sel = new int[N];
		visited = new boolean[N];
		for(int i = 0; i < N; i++) {
			data[i] = i + 1;
		}
		
		perm(0);
		System.out.println(sb);
	}

	private static void perm(int idx) {
		
		if(idx == N) {
			for(int i = 0; i < sel.length; i++) {
				sb.append(sel[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				sel[idx] = data[i];
				perm(idx + 1);
				visited[i] = false;
			}
		}
		
	}
}
