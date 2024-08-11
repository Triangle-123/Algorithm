import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		while(!str.equals("0")) {
			StringBuilder sb = new StringBuilder();
			sb.append(str);
			sb.reverse();
			if(str.equals(sb.toString())) System.out.println("yes");
			else System.out.println("no");
			str = sc.nextLine();
		}
	}
}