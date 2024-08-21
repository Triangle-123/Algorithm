import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int cnt = 1;
		int num = 666;
		while(true) {
			if(cnt == n) {
				System.out.println(num);
				break;
			}
			num++;
			if(Integer.toString(num).contains("666")) {
				cnt++;
			}
		}
	}
}
