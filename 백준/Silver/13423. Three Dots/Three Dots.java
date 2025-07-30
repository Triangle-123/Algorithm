import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tCase = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < tCase; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			int cnt = 0;
			for(int i = 0; i < N - 2; i++) {
				for(int j = i + 2; j < N; j++) {
					double find = arr[j] - (arr[j] - arr[i]) / 2.0;
					int left = i;
					int right = j;
					while(left <= right) {
						int mid = (left + right) / 2;
						if(arr[mid] > find) right = mid - 1;
						else if(arr[mid] < find) left = mid + 1;
						else {
							cnt++;
							break;
						}
					}
				}
			}
			sb.append(cnt + "\n");
		}
		System.out.println(sb);
	}
}
