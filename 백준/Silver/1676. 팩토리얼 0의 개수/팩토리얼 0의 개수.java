import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		BigInteger result = new BigInteger("1");
		for(int i = n; i >= 1; i--) {
			BigInteger num = new BigInteger(Integer.toString(i));
			result = result.multiply(num);
		}
		String str = result.toString();
		
		int cnt = 0;
		for(int i = str.length() - 1; i >= 0; i--) {
			if(str.charAt(i) != '0') break;
			cnt++;
		}
		System.out.println(cnt);
	}
}
