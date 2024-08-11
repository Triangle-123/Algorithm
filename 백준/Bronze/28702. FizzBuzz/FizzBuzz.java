import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] str = new String[3];
		int n = 0;
		int r = 0;
		for(int i = 0; i < str.length; i++) {
			str[i] = sc.next();
			if((!str[i].equals("FizzBuzz")) && (!str[i].equals("Fizz")) && (!str[i].equals("Buzz"))) {
				r = i;
				n = Integer.parseInt(str[i]);
			}
		}
		
		n += 3 - r;
		
		if(n % 3 == 0 && n % 5 == 0) System.out.println("FizzBuzz");
		else if(n % 3 == 0) System.out.println("Fizz");
		else if(n % 5 == 0) System.out.println("Buzz");
		else System.out.println(n);
	}
}