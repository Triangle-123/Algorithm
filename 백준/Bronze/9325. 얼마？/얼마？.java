import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i = 0; i < t; i++) {
			int s = sc.nextInt();
			int n = sc.nextInt();
			int result = s;
			for(int j = 0; j < n; j++) {
				int q = sc.nextInt();
				int p = sc.nextInt();
			
				result += q * p;
			}
			
			System.out.println(result);
			
		}
	}
}
