import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tCase = Integer.parseInt(br.readLine());
		for(int t = 1; t <= tCase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			int[] arr = new int[n];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int cnt = 0;
			loop : for(int i = 0; i < n - d; i++) {
				if(i == 0 && arr[i] == 0) {
					arr[i] = 1;
					cnt++;
				}
				if(arr[i] == 1) {
					for(int j = 1; j <= d; j++) {
						if(arr[i + j] == 1) {
							continue loop;
						}
					}
					arr[i + d] = 1;
					cnt++;
				}
			}
			
			if(arr[n - 1] == 0) {
				arr[n - 1] = 1;
				cnt++;
			}
			System.out.printf("#%d %d\n", t, cnt);
		}
	}
}
