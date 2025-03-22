import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int[] p;
	static int cnt = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int G = Integer.parseInt(br.readLine());
		int P = Integer.parseInt(br.readLine());
		
		p = new int[G + 1];
		
		for(int i = 1; i <= G; i++) {
			p[i] = i;
		}
		
		for(int i = 0; i < P; i++) {
			int airplane = Integer.parseInt(br.readLine());
			if(find(airplane) == 0) {
				break;
			}
			union(p[find(airplane) - 1], p[find(airplane)]);
			cnt++;
		}
		System.out.println(cnt);
	}
	
	private static int find(int x) {
		if(x != p[x]) {
			p[x] = find(p[x]);
		}
		return p[x];
	}
	
	private static void union(int x, int y) {
		p[y] = x;
	}
}