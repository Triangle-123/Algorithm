import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m  = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[1000001];
		
		for(int i = 2; i < arr.length; i++) {
			arr[i] = i;
		}
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == 0) continue;
			
			for(int j = 2; j * j <= arr[i]; j++) {
				if(arr[i] % j == 0) arr[i] = 0;
			}
		}
		
		for(int i = m; i <= n; i++) {
			if(arr[i] != 0) System.out.println(arr[i]);
		}
		
	}
}