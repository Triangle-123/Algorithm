import java.util.Scanner;

public class Main {
	static int N, R;
	static int[][] data;
	static int[] sel;
	static int min;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = N / 2;
		data = new int[N][N];
		sel = new int[R];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				data[i][j] = sc.nextInt();
			}
		}
		min = Integer.MAX_VALUE;
		combi(0, 0);
		System.out.println(min);
	}

	private static void combi(int idx, int sidx) {
		
		if(sidx == R) {
			int[] link = new int[R];
			int sScore = 0;
			int lScore = 0;
			int startIdx = 0;
			int linkIdx = 0;
			for(int i = 0; i < N; i++) {
				if(startIdx < R && sel[startIdx] == i) {
					startIdx++;
					continue;
				}
				link[linkIdx++] = i;
			}
			
			for(int i = 0; i < R - 1; i++) {
				for(int j = i + 1; j < R; j++) {
					sScore += data[sel[i]][sel[j]] + data[sel[j]][sel[i]];
					lScore += data[link[i]][link[j]] + data[link[j]][link[i]];
				}
			}
			
			min = Math.min(min, Math.abs(sScore - lScore));
			return;
		}
		
		if(idx == N) return;
		
		sel[sidx] = idx;
		combi(idx + 1, sidx + 1);
		combi(idx + 1, sidx);
		
	}
}
