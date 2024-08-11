import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for(int i = 0; i < n; i++) {
			String str = sc.next();
			switch(str) {
			case "push":
				int num = sc.nextInt();
				push(num);
				break;
			case "pop":
				pop();
				break;
			case "size":
				size();
				break;
			case "empty":
				System.out.println(empty());
				break;
			case "top":
				top();
				break;
			}
		}
	}
	
	static int[] stack = new int[10000];
	static int top = -1;
	
	static void push(int num) {
		stack[++top] = num;
	}
	
	static void pop() {
		if(empty() == 1) System.out.println(-1);
		else System.out.println(stack[top--]);
	}
	
	static void size() {
		System.out.println(top + 1);
	}
	
	static int empty() {
		if(top == -1) return 1;
		return 0;
	}
	
	
	static void top() {
		if(empty() == 1) System.out.println(-1);
		else System.out.println(stack[top]);
	}
	
}