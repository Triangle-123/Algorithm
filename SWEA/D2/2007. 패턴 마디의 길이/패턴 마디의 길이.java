import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tCase = Integer.parseInt(br.readLine());
		for(int t = 1; t <= tCase; t++) {
			String str = br.readLine();
			System.out.printf("#%d %d\n", t, patternLength(str, 1)); 
		}
	}
	
	static int patternLength(String str, int idx) {
		String compare1 = "";
		String compare2 = "";
		for(int i = 0; i < idx; i++) {
			compare1 += str.charAt(i);
			compare2 += str.charAt(i + idx);
		}
		if(compare1.equals(compare2)) {
			return compare1.length();
		}
		
		return patternLength(str, idx + 1);
		
	}
}
