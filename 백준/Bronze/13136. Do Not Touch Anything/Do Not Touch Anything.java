import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		long result = ((long) Math.ceil((double)r / n )) * ((long) Math.ceil((double)c / n ));
		// 입력 범위 꼭 확인하기!!!!!!!!!!!!!!!!
        
		System.out.println(result);
	}
}

