import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		int current = 1;
		StringBuilder sb = new StringBuilder();
		out: for(int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			while(true) {
				if(!stack.isEmpty() && stack.peek() == num) {
					stack.pop();
					sb.append("-\n");
					break;
				} else {
					stack.push(current++);
					sb.append("+\n");
				}
				if(stack.size() > n) break out;
			}
		}
		if(stack.isEmpty()) System.out.print(sb);
		else System.out.println("NO");
	}
}
