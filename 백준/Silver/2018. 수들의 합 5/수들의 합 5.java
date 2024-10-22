import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int start = 0;
		int end = 0;
		int cnt = 0;
		while(end <= N) {
			int sum = 0;
			for(int i = start; i <= end; i++) {
				sum += i;
			}
			if(sum == N) {
				cnt++;
				end++;
			} else if(sum < N) {
				end++;
			} else {
				start++;
			}
		}
		System.out.println(cnt);
	}
}
