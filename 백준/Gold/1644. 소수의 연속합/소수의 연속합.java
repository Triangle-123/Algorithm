import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		int N = Integer.parseInt(br.readLine());
		List<Integer> prime = new ArrayList<>();
		for(int i = 2; i <= N; i++) {
			boolean isPrime = true;
			for(int j = 2; j * j <= i; j++) {
				if(i % j == 0) {
					isPrime = false;
					break;
				}
			}
			if(isPrime) prime.add(i);
		}
		int cnt = 0;
		int left = 0;
		int right = 0;
		while(left <= right && right < prime.size()) {
			int sum = 0;
			for(int i = left; i <= right; i++) {
				sum += prime.get(i);
			}
			if(sum < N) {
				right++;
			} else if(sum == N) {
				cnt++;
				right++;
			} else {
				left++;
			}
		}
		
		System.out.println(cnt);
	}
}