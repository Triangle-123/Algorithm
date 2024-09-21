import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] A = new int[N];
		for(int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}
		List<Integer> dp = new ArrayList<>();
		dp.add(0);
		for(int i = 0; i < N; i++) {
			int curr = dp.size() - 1;
			if(dp.get(curr) < A[i]) {
				dp.add(A[i]);
			} else {
				while(curr >= 1) {
					if(dp.get(curr - 1) < A[i]) {
						dp.set(curr, A[i]);
						break;
					}
					curr--;
				}
			}
		}
		System.out.println(dp.size() - 1);
	}
}
