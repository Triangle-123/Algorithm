import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tCase = Integer.parseInt(br.readLine());
		Stack<Character> stack = new Stack<>();
		loop : for(int t = 1; t <= tCase; t++) {
			String str = br.readLine();
			for(int i = 0; i < str.length(); i++) {
				if(str.charAt(i) == '(') stack.push(str.charAt(i));
				else if(!stack.isEmpty()) stack.pop();
				else {
					System.out.println("NO");
					continue loop;
				}
			}
			
			if(stack.isEmpty()) System.out.println("YES");
			else System.out.println("NO");
			stack.clear();
		}
	}
}