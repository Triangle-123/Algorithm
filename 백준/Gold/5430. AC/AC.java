import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tCase = sc.nextInt();
		loop: for(int t = 1; t <= tCase; t++) {
			Deque<Integer> dq = new ArrayDeque<>(); // 덱은 배열을 뒤집은 것처럼 쓸 수 있다!!!
			char[] command = sc.next().toCharArray();
			int n = sc.nextInt();
			char[] ele = sc.next().toCharArray();
			for(int i = 0; i < ele.length; i++) {
				String str = "";
				while(ele[i] >= '0' && ele[i] <= '9') {
					str += ele[i++];
				}
				if(!str.equals("")) dq.offerLast(Integer.parseInt(str));
			}
			boolean reverse = false;
			for(int i = 0; i < command.length; i++) {
				if(command[i] == 'R') {
					reverse = !reverse;
				} else {
					if(dq.isEmpty()) {
						System.out.println("error");
						continue loop;
					}
					if(reverse) dq.pollLast();
					else dq.pollFirst();
				}
			}
			System.out.print("[");
			if(reverse) {
				int size = dq.size();
				for(int i = 0; i < size; i++) {
					if(i == size - 1) {
						System.out.print(dq.pollLast());
					}
					else System.out.print(dq.pollLast() + ",");
				}
			} else {
				int size = dq.size();
				for(int i = 0; i < size; i++) {
					if(i == size - 1) {
						System.out.print(dq.pollFirst());
					}
					else System.out.print(dq.pollFirst() + ",");
				}
			}
			System.out.println("]");
		}
		
	}
}
