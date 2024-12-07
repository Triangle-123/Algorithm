import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] result = new int[N + 1];
		Stack<Integer> stack = new Stack<>();
		Stack<Integer> idxStack = new Stack<>();
		for(int i = 1; i <= N; i++) {
			while(true) {
				if(stack.isEmpty()) {
					result[i] = 0;
					stack.push(arr[i]);
					idxStack.push(i);
					break;
				}
				else if(stack.peek() > arr[i]) {
					result[i] = idxStack.peek();
					stack.push(arr[i]);
					idxStack.push(i);
					break;
				}
				else {
					stack.pop();
					idxStack.pop();
				}				
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= N; i++) {
			sb.append(result[i] + " ");
		}
		System.out.println(sb);
	}
}
