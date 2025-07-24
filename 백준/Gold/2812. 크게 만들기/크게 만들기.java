import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Deque<Character> biggest = new ArrayDeque<>();
		char[] str = br.readLine().toCharArray();
		for(int i = 0; i < str.length; i++) {
			if(str.length - i >= N - K) {
				if(!biggest.isEmpty() && str[i] > biggest.peek()) {
					while(!biggest.isEmpty() && biggest.peek() < str[i]) {
						biggest.poll();
					}
					biggest.offer(str[i]);
				} 
				else if(!biggest.isEmpty() && str[i] > biggest.peekLast()) {
					while(str.length - i > N - K - biggest.size() && str[i] > biggest.peekLast()) {
						biggest.pollLast();						
					}
					biggest.offerLast(str[i]);
				} 
				else if(biggest.size() < N - K) {
					biggest.offer(str[i]);
				}
			}
			else if(str.length - i >= N - K - biggest.size()) {
				if(str[i] > biggest.peekLast()) {
					while(str.length - i > N - K - biggest.size() && str[i] > biggest.peekLast()) {
						biggest.pollLast();						
					}
					biggest.offerLast(str[i]);
				} else if(biggest.size() < N - K) {
					biggest.offerLast(str[i]);
				}
			}
			else if(biggest.size() < N - K) {
				biggest.offer(str[i]);
			}
		}
		StringBuilder sb = new StringBuilder();
		while(!biggest.isEmpty()) {
			sb.append(biggest.poll());
		}
		System.out.println(sb);
	}
}
