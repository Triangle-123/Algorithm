import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] queue = new int[10000];
	static int front = -1;
	static int rear = -1;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			switch(st.nextToken()) {
			case "push":
				push(Integer.parseInt(st.nextToken()));
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
			case "front":
				front();
				break;
			case "back":
				back();
				break;
			}
		}
		
	}
	
	static void push(int item) {
		queue[++rear] = item;
	}
	
	static void pop() {
		if(empty() == 1) {
			System.out.println(-1); 
			return;
		}
		System.out.println(queue[++front]);
	}
	
	static void size() {
		System.out.println(rear - front);
	}
	
	static int empty() {
		if(front == rear) return 1;
		return 0;
	}
	
	static void front() {
		if(empty() == 1) {
			System.out.println(-1); 
			return;
		}
		System.out.println(queue[front + 1]); 
	}
	
	static void back() {
		if(empty() == 1) {
			System.out.println(-1); 
			return;
		}
		System.out.println(queue[rear]); 
	}
}
