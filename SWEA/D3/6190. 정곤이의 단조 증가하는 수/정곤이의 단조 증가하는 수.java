import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tCase = Integer.parseInt(br.readLine());
		for(int t = 1; t <= tCase; t++) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] arr = new int[n];
			for(int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int max = 0;
			for(int i = 0; i < n - 1; i++) {
				for(int j = i + 1; j < n; j++) {
					boolean danjo = true;
					int mul = arr[i] * arr[j];
					String str = String.valueOf(mul);
					for(int k = 1; k < str.length(); k++) {
						if(str.charAt(k) < str.charAt(k - 1)) danjo = false;
					}
					if(danjo) {
						max = Math.max(max, mul);
					}
				}
			}
			if(max == 0) max = -1;
			System.out.println("#" + t + " " + max);
		}
	}
}