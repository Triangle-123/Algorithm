import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.io.FileInputStream;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tCase = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= tCase; t++) {
			int k = Integer.parseInt(br.readLine());
			Stack<Integer> stack = new Stack<>();
			int sum = 0;
			for(int i = 0; i < k; i++) {
				int num = Integer.parseInt(br.readLine());
				if(num == 0) {
					sum -= stack.pop();
				} else {
					stack.push(num);
					sum += num;
				}
			}
			
			System.out.printf("#%d %d\n", t, sum);
		}
		
	}
}
