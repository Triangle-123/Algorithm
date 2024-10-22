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
		int start = 0;
		int end = 0;
		int cnt = 0;
		while(end < N) {
			int sum = 0;
			for(int i = start; i <= end; i++) {
				sum += arr[i];
			}
			if(sum == M) {
				cnt++;
				start++;
			}
			else if(sum < M) {
				end++;
			}
			else {
				start++;
			}
		}
		System.out.println(cnt);
	}
}
