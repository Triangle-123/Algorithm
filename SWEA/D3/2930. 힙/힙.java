import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		int tCase = sc.nextInt();
		for(int t = 1; t <= tCase; t++) {
			int n = sc.nextInt();
			
			System.out.print("#" + t + " ");
			for(int i = 0; i < n; i++) {
				int command = sc.nextInt();
				if(command == 1) {
					int num = sc.nextInt();
					pq.offer(num);
				} else {
					if(pq.isEmpty()) System.out.print(-1 + " ");
					else System.out.print(pq.poll() + " ");
				}
			}
			System.out.println();
			pq.clear();
		}
	}
	
}
