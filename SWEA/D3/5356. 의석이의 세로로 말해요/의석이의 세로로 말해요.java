import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tCase = Integer.parseInt(br.readLine());
		for(int t = 1; t <= tCase; t++) {
			
			int maxLength = 0;
			String[][] arr = new String[5][];
			for(int i = 0; i < 5; i++) {
				arr[i] = br.readLine().split("");
				if(maxLength < arr[i].length) maxLength = arr[i].length;
			}
			
			String str = "";
			for(int i = 0; i < maxLength; i++) {
				for(int j = 0; j < 5; j++) {
					try {
						str += arr[j][i];
					} catch(ArrayIndexOutOfBoundsException e) {}
				}
			}
			
			System.out.printf("#%d %s\n", t, str);
		}
	}
}
