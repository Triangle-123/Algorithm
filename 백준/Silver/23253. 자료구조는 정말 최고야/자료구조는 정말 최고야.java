import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		PriorityQueue<Integer> head = new PriorityQueue<>((i1, i2) -> i1 - i2);
		int[] books = new int[N + 1];
		for(int i = 0; i < M; i++) {
			int k = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			if(k > 1) {
				int j = 1;
				int next = Integer.parseInt(st.nextToken());
				while(j < k) {
					int prev = Integer.parseInt(st.nextToken());
					books[prev] = next;
					next = prev;
					j++;
					if(j == k) {
						head.offer(prev);
					}
				}
			}
		}
        for(int i = 1; i <= N; i++) {
			if(!head.isEmpty() && head.peek() == i) {
				int n = head.poll();
				if(books[n] != 0) {
					head.offer(books[n]);
				}
			}
		}
		String ans = head.isEmpty() ? "Yes" : "No";
		System.out.println(ans);
	}
}
