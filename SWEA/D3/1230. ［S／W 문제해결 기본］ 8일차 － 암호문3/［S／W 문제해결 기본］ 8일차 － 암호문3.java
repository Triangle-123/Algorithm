import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> list = new ArrayList<>();
		Stack<Integer> stack = new Stack<>();
		
		
		for(int t = 1; t <= 10; t++) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			
			int command = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < command; i++) {
				String str = st.nextToken();
				if(str.equals("I")) {
					int idx = Integer.parseInt(st.nextToken());
					int nums = Integer.parseInt(st.nextToken());
					
					for(int j = 0; j < nums; j++) {
						stack.push(Integer.parseInt(st.nextToken()));
					}
					
					while(!stack.isEmpty()) {
						list.add(idx, stack.pop());
					}
				}
				else if(str.equals("D")) {
					int idx = Integer.parseInt(st.nextToken());
					int nums = Integer.parseInt(st.nextToken());
					
					for(int j = 0; j < nums; j++) {
						list.remove(idx);
					}
				}
				else if(str.equals("A")) {
					int nums = Integer.parseInt(st.nextToken());
					
					for(int j = 0; j < nums; j++) {
						list.add(Integer.parseInt(st.nextToken()));
					}
				}
			}
			
			System.out.print("#" + t + " ");
			for(int i = 0; i < 10; i++) {
				System.out.print(list.get(i) + " ");
			}
			System.out.println();
		}
	}
}