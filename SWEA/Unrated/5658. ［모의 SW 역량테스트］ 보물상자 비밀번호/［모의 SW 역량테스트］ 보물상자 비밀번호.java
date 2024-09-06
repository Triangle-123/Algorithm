import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tCase = sc.nextInt();
		for(int t = 1; t <= tCase; t++) {
			int n = sc.nextInt() / 4;
			int k = sc.nextInt();
			
			String[] str = sc.next().split("");
			Queue<String> q = new LinkedList<>();
			Set<Integer> set = new HashSet<>();
			
			for(int i = 0; i < str.length; i++) {
				q.offer(str[i]);
			}
			
			for(int l = 0; l < n; l++) {
				int idx = 0;
				Object[] s = q.toArray();
				for(int i = 0; i < 4; i++) {
					String st = "";
					for(int j = 0; j < n; j++) {
						st += (String)s[idx++];
					}
					set.add(Integer.decode("0x" + st));
				}
				q.offer(q.poll());
			}
			List<Integer> list = new ArrayList<>(set);
			list.sort(Collections.reverseOrder());
			
			System.out.println("#" + t + " " + list.get(k - 1));
		}
	}
}
