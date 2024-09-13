import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine().trim();
		String[] arr = s.split(" ");
		if(s.equals("")) {
			System.out.println(0);
			return;
		}
		System.out.println(arr.length);
	}
}



