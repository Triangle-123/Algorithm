import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int t = 1; t <= 10; t++) {
			int tCase = sc.nextInt();
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			int result = recursive(n, m);
			System.out.printf("#%d %d\n", tCase, result);
		}
		
		sc.close();
	}
	
	static int recursive(int n, int m) {
		if(m == 1) return n;
		return n * recursive(n, m - 1);
	}
}
