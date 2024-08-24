import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int[] arr = new int[k];
		long max = Integer.MIN_VALUE;
		for(int i = 0; i < k; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, arr[i]);
		}
		
		long maxLength = 0;
		long left = 1;
		long right = max;
		while(left <= right) {
			long sum = 0;
			long mid = ((left + right) / 2) == 0 ? 1 : ((left + right) / 2);
			for(int i = 0; i < k; i++) {
				sum += arr[i] / mid;
			}
			if(sum >= n) {
				maxLength = Math.max(maxLength, mid);
				left = mid + 1;
			} else right = mid - 1;
			
		}
		
		System.out.println(maxLength);
	}
}
