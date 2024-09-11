import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for(int i = 0; i < N; i++) {
			int command = sc.nextInt();
			if(command == 0) {
				if(pq.isEmpty()) System.out.println(0);
				else System.out.println(pq.poll());
			} else {
				pq.offer(command);
			}
			
		}
	}
}
