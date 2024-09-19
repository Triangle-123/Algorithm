import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		String text = br.readLine();
		int cnt = 0;
		int ans = 0;
		for(int i = 1; i < M - 1; i++) {
			if(text.charAt(i - 1) == 'I' && text.charAt(i) == 'O' && text.charAt(i + 1) == 'I') {
				cnt++;
				if(cnt == N) {
					cnt--;
					ans++;
				}
				i++;
			} else cnt = 0;
			
		}
		System.out.println(ans);
	}
}
