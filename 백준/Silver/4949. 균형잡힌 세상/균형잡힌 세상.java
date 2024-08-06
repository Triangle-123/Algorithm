import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		Stack<Character> stack = new Stack<>();
		out: while(!str.equals(".")) {
			for(int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				if(c == '(' || c == '[') {
					stack.push(c);
				} else {
					switch(c) {
					case ')':
						if(!stack.isEmpty() && stack.peek() == '(') {
							stack.pop();
							break;
						}
						else  {
							System.out.println("no");
							str = br.readLine();
							stack.clear();
							continue out;
						}
					case ']':
						if(!stack.isEmpty() && stack.peek() == '[') {
							stack.pop();
							break;
						}
						else  {
							System.out.println("no");
							str = br.readLine();
							stack.clear();
							continue out;
						}
						
					}
				}
			}
			if(stack.isEmpty()) System.out.println("yes");
            else System.out.println("no");
			stack.clear();
			str = br.readLine();
		}
		
	}
}