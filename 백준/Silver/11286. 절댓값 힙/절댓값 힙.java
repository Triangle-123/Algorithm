import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			
			@Override
			public int compare(Integer o1, Integer o2) {
				int abs1 = Math.abs(o1);
				int abs2 = Math.abs(o2);
				if(abs1 == abs2) {
					return o1 - o2;
				}
				return abs1 - abs2;
			}
			
		});
		int n = sc.nextInt();
		for(int i = 0; i < n; i++) {
			int num = sc.nextInt();
			if(num != 0) {
				pq.offer(num);
			} else {
				if(pq.isEmpty()) System.out.println(0);
				else System.out.println(pq.poll());
			}
		}
	}
}
