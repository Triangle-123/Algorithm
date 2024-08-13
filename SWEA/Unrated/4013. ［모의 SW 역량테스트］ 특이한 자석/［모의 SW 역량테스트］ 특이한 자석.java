import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	
	static boolean isFirst = false;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		List<Deque<Integer>> list = new ArrayList<>();
		
		for(int i = 0; i < 4; i++) {
			list.add(new ArrayDeque<Integer>());
		}
		
		int tCase = Integer.parseInt(br.readLine());
		for(int t = 1; t <= tCase; t++) {
			int k = Integer.parseInt(br.readLine());
			for(int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 8; j++) {
					list.get(i).offer(Integer.parseInt(st.nextToken()));
				}
			}
			
			for(int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				int choice = Integer.parseInt(st.nextToken()) - 1;
				int direction = Integer.parseInt(st.nextToken());
				isFirst = true;
				rotate(list, choice, direction, "next");
				
			}
			int score = 1;
			int sum = 0;
			for(int i = 0; i < 4; i++) {
				if(list.get(i).peekFirst() == 1) sum += score;
				score *= 2;
			}
			
			System.out.println("#" + t + " " + sum);
			for(int i = 0; i < 4; i++) {
				list.get(i).clear();
			}
		}
		
	}

	static void rotate(List<Deque<Integer>> list, int choice, int direction, String right) {
		int n = list.get(0).size();
		Object[] arr = list.get(choice).toArray();
		int rvDirection = -direction;

		if(choice != 0 && (right.equals("prev") || isFirst)) {
			Object[] arrPrev = list.get(choice - 1).toArray();
			if(arrPrev[2] != arr[n - 2]) {
				isFirst = false;
				rotate(list, choice - 1, rvDirection, "prev");
			}
		}
		if(choice != 3 && (right.equals("next") || isFirst)) {
			Object[] arrNext = list.get(choice + 1).toArray();
			if(arrNext[n - 2] != arr[2]) {
				isFirst = false;
				rotate(list, choice + 1, rvDirection, "next");
			}
		}
		
		if(direction == 1) {
			list.get(choice).addFirst(list.get(choice).pollLast());
		} else if(direction == -1) {
			list.get(choice).addLast(list.get(choice).pollFirst());
		}
		
	}
}
