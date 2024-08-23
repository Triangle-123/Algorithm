import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Integer> stack = new Stack<>();
		int n = sc.nextInt();
		int first = 1;
		for(int i = 0; i < n; i++) {
			int order = sc.nextInt();
			if(order == first) {
				first++;
				continue;
			} else {
				while(!stack.isEmpty() && stack.peek() == first) {
					stack.pop();
					first++;
				}
				if(order == first) {
					first++;
					continue;
				} else stack.push(order);
			}
		}
		
		while(!stack.isEmpty()) {
			if(stack.peek() == first) {
				stack.pop();
				first++;
			}
			else {
				System.out.println("Sad");
				break;
			}
		}
		if(stack.isEmpty()) System.out.println("Nice");
	}
}
