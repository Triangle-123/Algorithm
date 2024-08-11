import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int l = sc.nextInt();
		String str = sc.next();
		long sum = 0;
		
		for(int i = 0; i < str.length(); i++) {
			long hash = str.charAt(i) - 96;
			for(int j = 0; j < i; j++) {
				hash *= 31;
				hash %= 1234567891;
			}
			sum += hash;
			sum %= 1234567891;
		}
		System.out.println(sum);
	}
}