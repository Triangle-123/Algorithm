import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t = 1; t <= 10; t++) {
			int length = Integer.parseInt(br.readLine());
			String str = br.readLine();
			
			String postfix = infixToPostfix(str);
			int result = evaluatePostfix(postfix);
			System.out.println("#" + t + " " + result);
		}
	}
	
	
	
	static Map<Character, Integer> map = new HashMap<>();
	
	static {
		map.put('+', 1);
		map.put('-', 1);
		map.put('*', 2);
		map.put('/', 2);
	}
	
	
	static String infixToPostfix(String str) {
		String postfix = "";
		Stack<Character> stack = new Stack<>();
		for(int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if((c >= '0' && c <= '9')){
				postfix += c;
			} else if(c == '(') {
				stack.push(c);
			} else if(c == ')') {
				char popItem = stack.pop();
				while(popItem != '(') {
					postfix += popItem;
					popItem = stack.pop();
				}
			}
			else {
				while(!stack.isEmpty() && 
						stack.peek() != '(' &&
						map.get(stack.peek()) >= map.get(c)) {
					postfix += stack.pop();
				}
				
				stack.push(c);
			}
		}
		
		while(!stack.isEmpty()) {
			postfix += stack.pop();
		}
		
		return postfix;
	}
	
	static int evaluatePostfix(String postfix) {
		Stack<Integer> stack = new Stack<>();
		for(int i = 0; i < postfix.length(); i++) {
			char c = postfix.charAt(i);
			
			if((c >= '0' && c <= '9')) {
				stack.push(c - '0');
			} else {
				int result = 0;
				int num2 = stack.pop();
				int num1 = stack.pop();
				switch(c) {
				case '+':
					result = num1 + num2;
					break;
				case '-':
					result = num1 - num2;
					break;
				case '*':
					result = num1 * num2;
					break;
				case '/':
					result = num1 / num2;
					break;
				}
				
				stack.push(result);
			}
			
		}
		return stack.pop();
	}
	
}