import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int[] visit = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			visit[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = 0;
		int end = X - 1;
		
		int sum = 0;
		for(int i = start; i < end; i++) {
			sum += visit[i];
		}
		
		int max = 0;
		int maxCount = 1;
		while(end < N) {
			sum += visit[end];
			if(max < sum) {
				max = sum;
				maxCount = 1;
			} else if(max == sum) {
				maxCount++;
			}
			sum -= visit[start];
			start++;
			end++;
		}
		
		if(max == 0) System.out.println("SAD");
		else {
			System.out.println(max);
			System.out.println(maxCount);
		}
	}
}
