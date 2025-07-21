import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		Deque<Integer> deque = new ArrayDeque<>();
		for(int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			deque.offer(i);
		}
		StringBuilder sb = new StringBuilder();
		while(true) {
			int num = deque.poll();
			sb.append(num + " ");
			if(deque.isEmpty()) break;
			if(arr[num] > 0) {
				for(int i = 0; i < arr[num] - 1; i++) {
					deque.offerLast(deque.pollFirst());
				}
			} else {
				for(int i = arr[num]; i < 0; i++) {
					deque.offerFirst(deque.pollLast());
				}
			}
		}
		System.out.println(sb);
	}
}
