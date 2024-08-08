import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tCase = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= tCase; t++) {
			String str = br.readLine();
			int cnt = 0;
			for(int i = 0; i < str.length(); i++) {
				if(str.charAt(i) == '(') cnt++;
				if(str.charAt(i) == ')') {
					if(str.charAt(i - 1) != '(') cnt++;
				}
			}
			
			System.out.printf("#%d %d\n", t, cnt);
		}
	}
}