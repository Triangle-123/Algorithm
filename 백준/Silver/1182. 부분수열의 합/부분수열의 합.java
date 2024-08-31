import java.util.Scanner;

public class Main {
	
	static int N, S;
	static int[] arr;
	static boolean[] sel;
	static int cnt;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		S = sc.nextInt();
		
		arr = new int[N];
		sel = new boolean[N];
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		cnt = 0;
		power(0);
		System.out.println(cnt);
	}

	private static void power(int idx) {
		
		if(idx == N) {
			int sum = 0;
			boolean allFalse = true;
			for(int i = 0; i < sel.length; i++) {
				if(sel[i]) {
					sum += arr[i];
					allFalse = false;
				}
			}
			if(allFalse) return;
			if(sum == S) cnt++;
			return;
		}
		
		sel[idx] = true;
		power(idx + 1);
		sel[idx] = false;
		power(idx + 1);
		
	}
}
