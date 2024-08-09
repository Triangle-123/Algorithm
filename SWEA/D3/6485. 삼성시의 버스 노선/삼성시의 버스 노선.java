import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tCase = sc.nextInt();
		
		for(int t = 1; t <= tCase; t++) {
			int[] count = new int[5001];
			int n = sc.nextInt();
			for(int i = 0; i < n; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				for(int j = a; j <= b; j++) {
					count[j]++;
				}
			}
			int p = sc.nextInt();
			
			System.out.print("#" + t + " ");
			for(int i = 0; i < p; i++) {
				System.out.print(count[sc.nextInt()] + " ");
			}
            System.out.println();
		}
	}
}