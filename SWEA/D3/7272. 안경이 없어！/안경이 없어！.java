/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.FileInputStream;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tCase = Integer.parseInt(br.readLine());
		for(int t = 1; t <= tCase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String str1 = st.nextToken();
			String str2 = st.nextToken();
			
			System.out.print("#" + t + " ");
			
			if(str1.length() != str2.length()) {
				System.out.println("DIFF");
				continue;
			}
			
			for(int i = 0; i < str1.length(); i++) {
				if(str1.charAt(i) != 'B') {
					switch(str1.charAt(i)) {
					case 'A':
					case 'D':
					case 'O':
					case 'P':
					case 'Q':
					case 'R':
						str1 = str1.replace(str1.charAt(i), 'A');
						break;
					default:
						str1 = str1.replace(str1.charAt(i), 'Z');	
					}
				}
				if(str2.charAt(i) != 'B') {
					switch(str2.charAt(i)) {
					case 'A':
					case 'D':
					case 'O':
					case 'P':
					case 'Q':
					case 'R':
						str2 = str2.replace(str2.charAt(i), 'A');
						break;
					default:
						str2 = str2.replace(str2.charAt(i), 'Z');	
					}
				}
			}
			
			if(str1.equals(str2)) System.out.println("SAME");
			else System.out.println("DIFF");
		}
	}
}