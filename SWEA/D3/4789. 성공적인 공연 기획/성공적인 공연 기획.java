import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tCase = Integer.parseInt(br.readLine());
		for(int t = 1; t <= tCase; t++) {
			char[] arr = br.readLine().toCharArray();
			
			int sum = 0;
			int employee = 0;
			for(int i = 0; i < arr.length; i++) {
				if(i == 0) sum += arr[i] - '0';
				else if(arr[i] == '0') continue;
				else {
					if(sum < i) {
						employee += (i - sum);
						sum = i;
					}
					sum += arr[i] - '0';
				}
			}
			
			System.out.printf("#%d %d\n", t, employee);
		}
	}
}