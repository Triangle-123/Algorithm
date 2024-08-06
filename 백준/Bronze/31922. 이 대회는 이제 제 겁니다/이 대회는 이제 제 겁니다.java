import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int p = sc.nextInt();
		int c = sc.nextInt();
		
		int result = a + c < p ? p : a + c;
		
		System.out.println(result);
	}
}
