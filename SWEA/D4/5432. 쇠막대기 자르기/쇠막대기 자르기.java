import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.io.FileInputStream;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tCase = Integer.parseInt(br.readLine());
		for(int t = 1; t <= tCase; t++) {
			String[] str = br.readLine().split("");
			Stack<String> stack = new Stack<>();
			int stick = 0;
			boolean pushed = false;
			for(int i = 0; i < str.length; i++) {
				if(str[i].equals("(")) {
					stack.push(str[i]);
					pushed = true;
				} else if(pushed) {
					stack.pop();
					stick += stack.size();
					pushed = false;
				} else {
					stack.pop();
					stick++;
				}
			}
			System.out.printf("#%d %d\n", t, stick);
		}
	}
}
