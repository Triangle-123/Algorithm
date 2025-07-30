import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int M = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		Arrays.sort(arr);
		st = new StringTokenizer(br.readLine());
		loop: for(int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
			int left = 0;
			int right = N - 1;
			while(left <= right) {
				int mid = (left + right) / 2;
				if(arr[mid] > num) right = mid - 1;
				else if(arr[mid] < num) left = mid + 1;
				else {
					sb.append(1 + " ");
					continue loop;
				}
			}
			sb.append(0 + " ");
		}
		System.out.println(sb);
	}
}
