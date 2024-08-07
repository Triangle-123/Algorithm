import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		
		int tCase = Integer.parseInt(br.readLine());
		for(int t = 1; t <= tCase; t++) {
			int n = Integer.parseInt(br.readLine());
			
			Queue<Character> queue = new LinkedList<>();
			
			for(int i = 65; i <= 90; i++) {
				queue.offer((char)i);
			}
			
			char[] arr = new char[n];
			for(int i = 0; i < n; i++) {
				arr[i] = br.readLine().charAt(0);
			}
			
			Arrays.sort(arr);
			
			int cnt = 0;
			for(int i = 0; i < n; i++) {
				if(!queue.isEmpty() && arr[i] == queue.peek()) {
					queue.poll();
					cnt++;
				}
			}
			
			System.out.printf("#%d %d\n", t, cnt);
		}
	}
}
