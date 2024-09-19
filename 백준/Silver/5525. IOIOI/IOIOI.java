import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		String text = br.readLine();
		String pattern = "I";
		for(int i = 0; i < N; i++) {
			pattern += "OI";
		}
		int[] skip = new int[Character.MAX_VALUE + 1];
		for(int i = 0; i < Character.MAX_VALUE; i++) {
			skip[i] = pattern.length();
		}
		for(int i = 0; i < pattern.length() - 1; i++) {
			skip[pattern.charAt(i)] = pattern.length() - 1 - i;
		}
		
		int cnt = 0;
		int tPoint = pattern.length() - 1;
		while(tPoint < text.length()) {
			int pPoint = pattern.length() - 1;
			
			while(text.charAt(tPoint) == pattern.charAt(pPoint)) {
				if(pPoint == 0) {
					cnt++;
					break;
				}
				pPoint--;
				tPoint--;
			}
			tPoint += Math.max(skip[text.charAt(tPoint)], pattern.length() - pPoint);
		}
		System.out.println(cnt);
	}
}
