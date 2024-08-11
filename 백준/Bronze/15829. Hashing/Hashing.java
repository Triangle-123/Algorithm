import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int l = sc.nextInt();
		String str = sc.next();
		int sum = 0;
		
		for(int i = 0; i < str.length(); i++) {
			int hash = str.charAt(i) - 96;
			for(int j = 0; j < i; j++) {
				hash *= 31;
			}
			sum += hash;
		}
		System.out.println(sum);
	}
}