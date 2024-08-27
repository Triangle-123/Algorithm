import java.util.Scanner;

public class Solution {
	
	static int[] sel;
	static int[] data;
	static int cnt;
	static int sum;
	static int N, K;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tCase = sc.nextInt();
		
		for(int t = 1; t <= tCase; t++) {
			N = sc.nextInt();
			K = sc.nextInt();
			data = new int[N];
			for(int i = 0; i < N; i++) {
				data[i] = sc.nextInt();
			}
			sel = new int[N];
			
			cnt = 0;
			power(0);
			
			System.out.println("#" + t + " " + cnt);
		}
				
	}

	private static void power(int idx) {
		sum = 0;
		if(idx == N) {
			for(int n : sel) {
				sum += n;
			}
			if(sum == K) cnt++;
			return;
		}
		
		sel[idx] = data[idx];
		power(idx + 1);
		
		sel[idx] = 0;
		power(idx + 1);
		
	}
}
