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
			max = Math.max(max, arr[i]); // 강의가 블루레이에 적어도 담겨야 하므로
		}
		int left = max;
		int right = 10000 * N;
		int ans = Integer.MAX_VALUE;
		while(left < right) {
			int mid = (left + right) / 2; // 상한 크기
			int sum = 0;
			int cnt = 1;
			for(int i = 0; i < N; i++) {
				sum += arr[i];
				
				if(sum > mid) {
					sum = arr[i];
					cnt++;
				}
			}
			if(cnt > M) {
				left = mid + 1;
			} else {
				ans = Math.min(ans, mid);
				right = mid;
			}
		}
		
		System.out.println(ans);
		
	}
}
// 최대값 중 최소를 구하는 것?
// M개의 블루레이를 만족하는 값 중 최소를 구하면 될듯
// 블루레이 크기의 상한을 정해놓고
// 1번부터 담으면서 상한을 넘으면 블루레이 추가
// 모두 담았는데 M개를 넘었다면 상한을 늘리고
// 아니라면 값을 저장하면서 상한을 줄여보자