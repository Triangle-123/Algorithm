import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tCase = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= tCase; t++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			
			int result = resident(k, n);
			System.out.println(result);
		}
	}
	
	
	static int resident(int k, int n) {
		int sum = 0;
		if(k == 0) {
			sum = n;
		}
		else {
			for(int i = 1; i <= n; i++) {
				sum += resident(k-1, i);
			}
		}
		return sum;
	}
}