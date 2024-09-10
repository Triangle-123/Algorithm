import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		int maxHeight = 0;
		int right = arr[arr.length - 1];
		int left = right - M;
		while(left <= right) {
			int mid = (left + right) / 2;
			long sum = 0;
			for(int i = 0; i < arr.length; i++) {
				int cut = arr[i] - mid;
				if(cut > 0) {
					sum += cut;
				}
			}
			if(sum < M) right = mid - 1;
			else {
				maxHeight = mid;
				left = mid + 1;
			}
		}
		System.out.println(maxHeight);
	}
}
