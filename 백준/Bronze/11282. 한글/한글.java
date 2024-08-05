import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		char geul = (char)(n + 44032 - 1); // 한글 아스키코드 44032(가) 부터 시작 => 11172개(55203까지)
		                                    // n이 1이면 '가'를 출력해야 하므로 1을 빼준다.
		
		System.out.println(geul);
	}
}
