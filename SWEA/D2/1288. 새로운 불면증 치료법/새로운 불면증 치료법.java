import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.io.FileInputStream;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tCase = Integer.parseInt(br.readLine());
		for(int t = 1; t <= tCase; t++) {
			Set<Character> set = new HashSet<>();
			int num = Integer.parseInt(br.readLine());
			int nNum = num;
			while(true) {
				char[] arr = Integer.toString(nNum).toCharArray();
				
				for(int i = 0; i < arr.length; i++) {
					set.add(arr[i]);
				}
				if(set.size() == 10) break;
				
				nNum += num; 
				
			}
			
			System.out.printf("#%d %d\n", t, nNum);
		}
	}
}