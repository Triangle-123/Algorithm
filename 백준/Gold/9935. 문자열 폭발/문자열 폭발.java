import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Stack<Character> stack = new Stack<>();
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder(sc.next());
		String bomb = sc.next();
		for(int i = 0; i < sb.length(); i++) {
			stack.push(sb.charAt(i));
			if(stack.size() >= bomb.length()) {
				boolean expl = true;
				for(int j = 0; j < bomb.length(); j++) {
					if(stack.get(stack.size() - bomb.length() + j) != bomb.charAt(j)) {
						expl = false;
						break;
					}
				}
				
				if(expl) {
					for(int j = 0; j < bomb.length(); j++) {
						stack.pop();						
					}
				}
			}
		}
		sb.delete(0, sb.length());
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
        sb.reverse();
		if(sb.toString().equals("")) System.out.println("FRULA");
		else System.out.println(sb.toString());
	}
}