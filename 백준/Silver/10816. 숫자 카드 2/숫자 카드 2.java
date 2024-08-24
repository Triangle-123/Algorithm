import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<Integer> card = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			card.add(sc.nextInt());
		}
		Collections.sort(card);
		int m = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < m; i++) {
			int num = sc.nextInt();
			int left = left(card, num);
			int right = right(card, num);
			sb.append(right - left + " ");
		}
		System.out.println(sb);
	}
	
	static int left(List<Integer> list, int num) {
		int left = 0;
		int right = list.size();
		while(left < right) {
			int mid = (left + right) / 2;
			if(list.get(mid) >= num) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}
	
	static int right(List<Integer> list, int num) {
		int left = 0;
		int right = list.size();
		while(left < right) {
			int mid = (left + right) / 2;
			if(list.get(mid) > num) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}
}
