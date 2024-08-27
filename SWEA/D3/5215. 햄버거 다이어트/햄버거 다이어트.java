import java.util.Scanner;

public class Solution {
	static int N, L;
	static int[][] meterial; 
	static int maxScore;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tCase = sc.nextInt();
		for(int t = 1; t <= tCase; t++) {
			N = sc.nextInt();
			L = sc.nextInt();
			meterial = new int[N][2];
			for(int i = 0; i < N; i++) {
				meterial[i][0] = sc.nextInt();
				meterial[i][1] = sc.nextInt();
			}
			
			maxScore = 0;
			comb(0, 0, 0);
			
			System.out.println("#" + t + " " + maxScore);
		}
	}
	private static void comb(int idx, int cal, int score) {
		
		if(cal > L) {
			return;
		}

		
		if(idx == N) {
			maxScore = Math.max(maxScore, score);
			return;
		}
		
		
		int score2 = score + meterial[idx][0];
		int cal2 = cal + meterial[idx][1];
		comb(idx + 1, cal2, score2);
		comb(idx + 1, cal, score);
		
		
	}
}
