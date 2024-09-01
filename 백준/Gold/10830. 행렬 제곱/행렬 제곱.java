import java.util.Scanner;

public class Main {
	
	static long[][] arr;
	static int N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		long b = sc.nextLong();
		arr = new long[N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		long[][] result = pow(b);
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				System.out.print(result[i][j] + " "); 
			}
			System.out.println();
		}	 
	}

	private static long[][] pow(long b) {
		long[][] result = new long[N][N];
		
		if(b == 1) {
			for(int i = 0; i < result.length; i++) {
				for(int j = 0; j < result.length; j++) {
					result[i][j] = arr[i][j];
					result[i][j] %= 1000;
				}
			}
			return result;
		}
		
		if(b % 2 == 0) {
			long[][] pow = pow(b / 2);
			
			for(int i = 0; i < result.length; i++) {
				for(int j = 0; j < result.length; j++) {
					for(int k = 0; k < result.length; k++) {
						result[i][j] += (pow[i][k] * pow[k][j]);
						result[i][j] %= 1000;
					}
				}
			}
			
			return result;
			
		} else {
			long[][] pow = pow((b - 1) / 2);
			long[][] result2 = new long[N][N];
			for(int i = 0; i < result.length; i++) {
				for(int j = 0; j < result.length; j++) {
					for(int k = 0; k < result.length; k++) {
						result[i][j] += (pow[i][k] * pow[k][j]);
						result[i][j] %= 1000;
					}
				}
			}
			for(int i = 0; i < result.length; i++) {
				for(int j = 0; j < result.length; j++) {
					for(int k = 0; k < result.length; k++) {
						result2[i][j] += (result[i][k] * arr[k][j]);
						result2[i][j] %= 1000;
					}
				}
			}
			return result2;
			
		}

	}

	
}
