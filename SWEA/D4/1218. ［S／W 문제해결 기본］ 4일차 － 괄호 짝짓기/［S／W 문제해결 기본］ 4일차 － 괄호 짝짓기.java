import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.io.FileInputStream;
//
public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t = 1; t <= 10; t++) {
			int length = Integer.parseInt(br.readLine());
			Stack<String> stack = new Stack<>();
			String[] str = br.readLine().split("");
			
			out : for(int i = 0; i < length; i++) {
				if(str[i].equals("(") || str[i].equals("[") || 
						str[i].equals("{") || str[i].equals("<")) {
					stack.push(str[i]);
				} 
				else {
					switch(stack.pop()) {
					case "(":
						if(str[i].equals(")")) break;
					case "[":
						if(str[i].equals("]")) break;
					case "{":
						if(str[i].equals("}")) break;
					case "<":
						if(str[i].equals(">")) break;
					default:
						System.out.printf("#%d %d\n", t, 0);
						break out;
					}
				}
			}
			if(stack.isEmpty()) System.out.printf("#%d %d\n", t, 1);
		}
		
	}
}