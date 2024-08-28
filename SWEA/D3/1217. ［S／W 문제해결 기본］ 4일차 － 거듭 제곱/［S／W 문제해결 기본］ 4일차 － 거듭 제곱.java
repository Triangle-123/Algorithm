import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int t = 1; t <= 10; t++) {
			int tCase = sc.nextInt();
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			int result = pow(n, m);
			System.out.println("#" + tCase + " " + result);
		}
	}

	private static int pow(int n, int m) {
		
		if(m == 0) return 1;
		if(m % 2 == 0) {
			int result = pow(n, m / 2);
			return result * result;
		} else {
			int result = pow(n, (m - 1) / 2);
			return result * result * n;
		}

	}
}
