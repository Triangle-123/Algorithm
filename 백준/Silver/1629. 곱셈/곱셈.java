import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		System.out.println(pow(a, b, c));
	}
	
	private static long pow(int a, int b, int c) {
		if(b == 0) return 1;
		long result;
		if(b % 2 == 0) {
			result = pow(a, b / 2, c);
			return (result * result) % c;
		} else {
			result = pow(a, (b - 1) / 2, c);
			return (((result * result) % c) * a) % c;
		}
	}
}
