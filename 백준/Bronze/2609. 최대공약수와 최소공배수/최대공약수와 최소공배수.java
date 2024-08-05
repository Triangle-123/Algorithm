import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int min = Math.min(a, b);
		
		int n = 1;
		int m = 1;
		int gcd = 0;
		int lcm = 0;
		while(n <= min) {
			if(a % n == 0 && b % n == 0) gcd = n;
			n++;
		}
		n = 1;
		while(true) {
			if(a * n > b * m) {
				m++;
			} else if(a * n < b * m) {
				n++;
			} else {
				lcm = a * n;
				break;
			}
			
		}
		
		System.out.println(gcd);
		System.out.println(lcm);
		
	}
}