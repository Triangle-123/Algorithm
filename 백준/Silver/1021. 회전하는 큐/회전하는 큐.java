import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Deque<Integer> dq1 = new ArrayDeque<>();
		Deque<Integer> dq2 = new ArrayDeque<>();
		for(int i = 1; i <= N; i++) {
			dq1.offer(i);
			dq2.offer(i);
		}
		st = new StringTokenizer(br.readLine());
		int totalCnt = 0;
		for(int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
			int cnt = 0;
			int cnt2 = 0;
			while(dq1.peek() != num) {
				dq1.offerLast(dq1.pollFirst());
				cnt++;
			}
			while(dq2.peek() != num) {
				dq2.offerFirst(dq2.pollLast());
				cnt2++;
			}
			dq1.poll();
			dq2.poll();
			totalCnt += Math.min(cnt, cnt2);
		}
		System.out.println(totalCnt);
	}
}
