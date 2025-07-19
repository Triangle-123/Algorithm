import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			while(!stack.isEmpty() && stack.peek() > y) {
				stack.pop();
				cnt++;
			}
			if(y > 0 && (stack.isEmpty() || stack.peek() < y)) stack.push(y);
		}
		while(!stack.isEmpty()) {
			stack.pop();
			cnt++;
		}
		System.out.println(cnt);
	}
}