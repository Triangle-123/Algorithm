import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		int max = 0;
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
			max = Math.max(max, arr[i]);
		}
		int M = sc.nextInt();
		int left = 1;
		int right = M;
		
		int sum = 0;
		for(int i = 0; i < N; i++) {
			sum += arr[i];
		}
		int ans = 0;
		if(sum <= M) {
			ans = max;
		}
		else {
			while(left < right) {
				int mid = (left + right) / 2;
				sum = 0;
				for(int i = 0; i < N; i++) {
					if(arr[i] < mid) sum += arr[i];
					else sum += mid;
				}
				if(sum > M) {
					right = mid;
				} else {
					ans = Math.max(ans, mid);
					left = mid + 1;
				}
			}		
		}
		System.out.println(ans);
	}
}
