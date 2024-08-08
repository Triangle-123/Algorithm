import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.io.FileInputStream;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= n; i++) {
			String num = Integer.toString(i);
			if(num.contains("3") || num.contains("6") || num.contains("9")) {
				for(int j = 0; j < num.length(); j++) {
					if(num.charAt(j) == '3' || num.charAt(j) == '6' || num.charAt(j) == '9') {
						System.out.print("-");
					}
				}
			} else System.out.print(num);
			
			System.out.print(" ");
		}
	}
}
