import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
        Arrays.sort(arr);
		int left = 1;
		int right = arr[arr.length - 1];
		int result = 0;
		while(left <= right) {
			int cnt = 0;
			int mid = (left + right) / 2;
			for(int i = 0; i < N; i++) {
				cnt += arr[i] / mid;
			}
			if(cnt >= M) {
				result = mid;
				left = mid + 1;
			} else right = mid - 1;
		}
		System.out.println(result);
	}
}
// 이분탐색을 하며 N번씩 반복
// NlogN
