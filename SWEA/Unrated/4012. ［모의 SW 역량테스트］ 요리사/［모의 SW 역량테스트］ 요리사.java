import java.util.Scanner;

public class Solution {
	
	static int N, R;
	static int[][] data;
	static int[] sel1;
	static int[] sel2;
	static int sum1, sum2;
	static int min;
	static boolean[] visited;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tCase = sc.nextInt();
		for(int t = 1; t <= tCase; t++) {
			N = sc.nextInt();
			R = N / 2;
			data = new int[N + 1][N + 1];
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++) {
					data[i][j] = sc.nextInt();
				}
			}
			sel1 = new int[R + 1];
			sel2 = new int[R + 1];
			visited = new boolean[N + 1];
			min = Integer.MAX_VALUE;
			combi(1, 1);
			System.out.println("#" + t + " " + min);
		}
	}


	private static void combi(int idx, int sidx) {
		
		if(sidx == R + 1) {
			combi2(1, 1);
			return;
		}
		if(idx == N + 1) return;
		
		sel1[sidx] = idx;
		visited[idx] = true;
		combi(idx + 1, sidx + 1);
		visited[idx] = false;
		combi(idx + 1, sidx);
		
	}


	private static void combi2(int idx, int sidx) {
		
		if(sidx == R + 1) {
			madeCombi();
			return;
		}
		if(idx == N + 1) return;
		
		if(!visited[idx]) {
			sel2[sidx] = idx;
			combi2(idx + 1, sidx + 1);
			combi2(idx + 1, sidx);
		}
		else combi2(idx + 1, sidx);
	}
	
	private static void madeCombi() {
		sum1 = 0;
		sum2 = 0;
		
		for(int i = 1; i < sel1.length - 1; i++) {
			int r = sel1[i];
			for(int j = i + 1; j < sel1.length; j++) {
				int c = sel1[j];
				sum1 += data[r][c] + data[c][r];
			}
		}
		
		for(int i = 1; i < sel2.length - 1; i++) {
			int r = sel2[i];
			for(int j = i + 1; j < sel2.length; j++) {
				int c = sel2[j];
				sum2 += data[r][c] + data[c][r];
			}
		}
		
		min = Math.min(min, Math.abs(sum1 - sum2));
	}
}
