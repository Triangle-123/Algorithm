import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int bag = n % 5;
		int bagCnt = n / 5;
		if(bag == 0) System.out.println(bagCnt);
		else if(bag % 3 == 0) {
			bagCnt += bag / 3;
			System.out.println(bagCnt);
		}
		else {
			while(bag % 3 != 0) {
				bag += 5;
				if(bag > n) {
					System.out.println(-1);
					bag = n;
					break;
				}
				bagCnt--;
			}
			if(bag % 3 == 0) System.out.println(bagCnt + bag / 3);
		}
	}
}