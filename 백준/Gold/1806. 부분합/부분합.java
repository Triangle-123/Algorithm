import java.util.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int left = 0;
		int right = 0;
		int sum = arr[left];
		int length = 100001;
		while(left <= right) {
			if(sum >= S) {
				length = Math.min(length, right - left + 1);
				sum -= arr[left];
				left++;
			} else {
				right++;
				if(right >= N) {
					break;
				}
				sum += arr[right];
			}
		}
		if(length > 100000) length = 0;
		System.out.println(length);
	}
}
