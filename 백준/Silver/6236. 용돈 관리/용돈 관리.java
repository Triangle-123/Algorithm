import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[] arr = new int[N];
		int max = 0;
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
			max = Math.max(max, arr[i]);
		}

		long left = max;
		long right = Integer.MAX_VALUE;
		long ans = Integer.MAX_VALUE;
		while(left < right) {
			long mid = ((long)left + right) / 2;
			int cnt = 1;
			long money = mid;
			for(int i = 0; i < N; i++) {
				if(arr[i] > money) {
					money = mid - arr[i];
					cnt++;
				} else {
					money -= arr[i];
				}
			}
			if(cnt > M) {
				left = mid + 1;
			} else if(cnt <= M) {
				right = mid;
				ans = Math.min(ans, mid);
			}
		}
		System.out.println(ans);
	}
}

