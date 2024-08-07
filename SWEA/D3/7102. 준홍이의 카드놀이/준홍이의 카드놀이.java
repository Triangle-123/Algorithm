import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.FileInputStream;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tCase = Integer.parseInt(br.readLine());
		for(int t = 1; t <= tCase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[] count = new int[n + m + 1];
			int max = 0;
			for(int i = 1; i <= n; i++) {
				for(int j = 1; j <= m; j++) {
					count[i+j]++;
					max = Math.max(max, count[i+j]);
				}
			}
			System.out.print("#" + t + " ");
			for(int i = 0; i < count.length; i++) {
				if(count[i] == max) System.out.print(i + " ");
			}
			System.out.println();
		}
	}
}