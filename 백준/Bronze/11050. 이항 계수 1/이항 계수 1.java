import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int k2 = n - k;
		
		int result = 1;
		while(n != 0) {
			result *= n--;
		}
		
		int fact = 1;
		while(k2 != 0) {
			fact *= k2--;
		}
		while(k != 0) {
			fact *= k--;
		}
		
		result /= fact;
		System.out.println(result);
	}
}