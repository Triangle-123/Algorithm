import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		if(n == 0) {
			System.out.println(0);
			System.exit(0); // 0은 정상종료 1은 비정상종료
		}
		int[] arr = new int[n]; 
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int cut = (int) Math.round(n * 0.15);
		Arrays.sort(arr);
		int avg = 0;
		for(int i = cut; i < n - cut; i++) {
			avg += arr[i];
		}
		avg = (int) Math.round((double)avg / (n - (cut * 2)));
		System.out.println(avg);
	}
}
