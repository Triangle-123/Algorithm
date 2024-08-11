import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[][] dice = new int[n][6];
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 6; j++) {
				dice[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int result = 0;
		
		for(int idx = 0; idx < 6; idx++) {
			result = Math.max(result, maxSum(dice, 0, dice[0][idx], n));
		}
		
		System.out.println(result);
		
		
	}
	
	static int maxSum(int[][] dice, int row, int idx, int n) {
		int max = 0;
		int r = 0;
		int top = 0;
		if(row == n) return 0;
		for(int i = 0; i < 6; i++) {
			if(dice[row][i] == idx) {
				r = i;
				break;
			}
		}
		switch(r) {
		case 0:
			top = 5;
			break;
		case 1:
			top = 3;
			break;
		case 2:
			top = 4;
			break;
		case 3:
			top = 1;
			break;
		case 4:
			top = 2;
			break;
		case 5:
			top = 0;
			break;
		}
		
		for(int i = 0; i < 6; i++) {
			if(i != r && i != top) {
				max = Math.max(max, dice[row][i]);
			}
		}
		return max + maxSum(dice, row + 1, dice[row][top], n);
	}
}