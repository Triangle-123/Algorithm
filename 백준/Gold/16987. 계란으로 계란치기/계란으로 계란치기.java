import java.util.Scanner;

public class Main {
	
	static boolean[] crashed;
	static int N, maxCnt;
	static int[][] egg;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		egg = new int[N][2];
		crashed = new boolean[N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < 2; j++) {
				egg[i][j] = sc.nextInt();
			}
		}
		perm(0);
		System.out.println(maxCnt);
	}

	private static void perm(int idx) {
		if(idx == N) {
			int cnt = 0;
			for(int i = 0; i < N; i++) {
				if(crashed[i]) cnt++;
			}
			maxCnt = Math.max(maxCnt, cnt);
			return;
		}
		if(crashed[idx]) perm(idx + 1);
		for(int i = 0; i < N; i++) {
			if(!crashed[i] && !crashed[idx] && i != idx) {
				egg[idx][0] -= egg[i][1];
				if(egg[idx][0] <= 0) crashed[idx] = true;
				egg[i][0] -= egg[idx][1];
				if(egg[i][0] <= 0) crashed[i] = true;
				perm(idx + 1);
				egg[idx][0] += egg[i][1];
				if(crashed[idx]) crashed[idx] = false;
				egg[i][0] += egg[idx][1];
				if(crashed[i]) crashed[i] = false;
			}
		}
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			if(crashed[i]) cnt++;
		}
		if(cnt >= N - 1) perm(idx + 1);
	}
}
