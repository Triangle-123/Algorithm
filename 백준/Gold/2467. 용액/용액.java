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
		int left = 0;
		int right = N - 1;
		int min = Integer.MAX_VALUE;
		int[] result = new int[2];
		while(left < right) {
			int sum = arr[left] + arr[right];
			if(min >= Math.abs(sum)) {
				min = Math.abs(sum);
				result = new int[] {arr[left], arr[right]};
			}
			if(sum >= 0) right--;
			else left++;
		}
		System.out.println(result[0] + " " + result[1]);
	}
}
