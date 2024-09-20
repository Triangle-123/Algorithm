import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int N, C, sel;
	static int[] house;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		C = sc.nextInt();
		house = new int[N];
		for(int i = 0; i < N; i++) {
			house[i] = sc.nextInt();
		}
		Arrays.sort(house);
		int left = 0;
		int right = house[N - 1] - house[0] + 1;
		
		int mid = 0;
		while(left < right) {
			mid = (left + right) / 2;
			sel = house[0];
			int cnt = 1;
			for(int i = 1; i < N; i++) {
				if(house[i] >= sel + mid) {
					sel = house[i];
					cnt++;
				}
			}
			if(C <= cnt) {
				left = mid + 1;
			} else right = mid;
		}
		System.out.println(left - 1);
	}
}
