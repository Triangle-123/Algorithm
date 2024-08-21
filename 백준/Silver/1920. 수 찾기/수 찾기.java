import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		int m = sc.nextInt();
		loop: for(int i = 0; i < m; i++) {
			int num = sc.nextInt();
			int left = 0;
			int right = arr.length - 1;
			while(left <= right) {
				int mid = (right + left) / 2;
				if(num == arr[mid]) {
					System.out.println(1);
					continue loop;
				} else if(num < arr[mid]) {
					right = mid - 1;
				} else if(num > arr[mid]) {
					left = mid + 1;
				}
			}
			System.out.println(0);
		}
		
		
	}
}
