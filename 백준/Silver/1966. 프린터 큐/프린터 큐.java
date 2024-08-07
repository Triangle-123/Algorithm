import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tCase = Integer.parseInt(br.readLine());
		for(int t = 1; t <= tCase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			Integer[] priority = new Integer[n];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; i++) {
				priority[i] = Integer.parseInt(st.nextToken());
			}
			
			Integer[] priority2 = Arrays.copyOf(priority, n);
			
			
			Arrays.sort(priority2, (i1, i2) -> i2 - i1);
			
			Queue<Integer> queue = new LinkedList<>();
			
			for(int i = 0; i < n; i++) {
				queue.offer(priority2[i]);
			}
			
			int cnt = 1;
			int k = 0;
			while(true) {
				if(k == m && priority[k] == queue.peek()) {
					break;
				} else if(priority[k] == queue.peek()) {
					queue.poll();
					cnt++;
				}
				k = (k + 1) % n;
			}
			
			
			System.out.println(cnt);
		}
		
	}
}