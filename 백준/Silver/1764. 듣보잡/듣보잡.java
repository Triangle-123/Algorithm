import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		Set<String> set = new HashSet<>();
		TreeSet<String> deudbo = new TreeSet<>();
		
		for(int i = 0; i < n; i++) {
			set.add(br.readLine());
		}
		
		for(int i = 0; i < m; i++) {
			deudbo.add(br.readLine());
		}
		
		deudbo.retainAll(set);
		
		StringBuilder sb = new StringBuilder();
		int size = deudbo.size();
		sb.append(size).append("\n");
		for(int i = 0; i < size; i++) {
			sb.append(deudbo.pollFirst()).append("\n");
		}
		System.out.println(sb);
	}
}
