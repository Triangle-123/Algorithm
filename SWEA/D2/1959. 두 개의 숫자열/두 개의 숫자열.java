import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tCase = Integer.parseInt(br.readLine());
		for(int t = 1; t <= tCase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			
			int[] arr1 = new int[n];
			int[] arr2 = new int[m];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; i++) {
				arr1[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < m; i++) {
				arr2[i] = Integer.parseInt(st.nextToken());
			}
			
			if(n > m) {
				int[] tempArr = Arrays.copyOf(arr1, n);
				arr1 = Arrays.copyOf(arr2, m);
				arr2 = Arrays.copyOf(tempArr, n);
				
				int temp = n;
				n = m;
				m = temp;
			}
			int idx = 0;
			int max = 0;
			for(int i = 0; i <= m - n; i++) {
				int sum = 0;
				for(int j = 0; j < n; j++) {
					sum += arr1[j] * arr2[j + idx];
				}
				if(max < sum) max = sum;
				idx++;
			}
			System.out.printf("#%d %d\n", t, max);
		}
	}
}
