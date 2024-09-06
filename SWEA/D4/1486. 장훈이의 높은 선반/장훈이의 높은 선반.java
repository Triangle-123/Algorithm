import java.util.Scanner;

public class Solution {
	
	static int N, B, ans;
	static int[] employee, sel;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tCase = sc.nextInt();
		for(int t = 1; t <= tCase; t++) {
			
			N = sc.nextInt();
			B = sc.nextInt();
			
			employee = new int[N];
			sel = new int[N];
			
			for(int i = 0; i < N; i++) {
				employee[i] = sc.nextInt();
			}
			ans = Integer.MAX_VALUE;
			power(0, 0);
			
			System.out.println("#" + t + " " + (ans - B));
		}
	}

	private static void power(int idx, int sum) {
		if(sum >= ans) return;
		
		if(sum >= B) {
			ans = Math.min(ans, sum);
			return;
		}
		
		if(idx == N) return;
		
		power(idx + 1, sum + employee[idx]);
		power(idx + 1, sum);
		
	}
}
