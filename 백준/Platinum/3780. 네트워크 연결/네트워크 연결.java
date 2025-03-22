import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] p, dist;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tCase = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < tCase; t++) {
			int N = Integer.parseInt(br.readLine());
			p = new int[N + 1];
			for(int i = 1; i <= N; i++) {
				p[i] = i;
			}
			dist = new int[N + 1];
			loop: while(true) {
				st = new StringTokenizer(br.readLine());
				switch(st.nextToken()) {
				case "E":
					int center = Integer.parseInt(st.nextToken());
					find(center);
					sb.append(dist[center] + "\n");
					break;
				case "I":
					int i = Integer.parseInt(st.nextToken());
					int j = Integer.parseInt(st.nextToken());
					union(i, j);
					break;
				case "O":
					break loop;
				}
			}
		}
		System.out.println(sb);
	}
	
	private static int find(int x) { // dist[1]은 1, dist[2]는 2, dist[4]는 0
		if(x != p[x]) { // x가 1이면
			int before = p[x]; // 2
			p[x] = find(p[x]); // 4
			dist[x] += dist[before]; // dist[1] += dist[2]
									// 여기서 dist[2]는 dist[2] += dist[4]를 거쳤음
		}
		return p[x];
	}
	
	private static void union(int x, int y) {
		dist[x] = Math.abs(x - y) % 1000;
		p[x] = y;
	}
}