import java.util.*;
import java.io.*;

public class Main {
	
	static int[] memo;
	static final int mod = 1000000000;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int N = Math.abs(num);
		memo = new int[N + 1];
		Arrays.fill(memo, -1);
		fibo(N);
		int result = 1;
		if(num < 0 && num % 2 == 0) result = -1;
		else if(num == 0) result = 0;
		System.out.println(result);
		System.out.println(memo[N] % mod);
	}

	private static int fibo(int n) {
		if(memo[n] == -1) {
			if(n <= 1) {
				memo[n] = n;
			}
			else memo[n] = (fibo(n - 1) + fibo(n - 2)) % mod;
		}
		return memo[n];
	}
}

// N = 0 -> 0
// -1 + -2
// -1 = 1
// -2 = -1
// N = -1 -> 1
// -2 + -3
// -2 = -1
// -3 = 2
// N = -2 -> -1
// -3 + -4
// -3 = 2
// -4 = -3

// 1 -1 2 -3 5 -8 13