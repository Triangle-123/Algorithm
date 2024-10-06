import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.*;

public class Main {
	
	static StringBuffer[] command;
	static boolean[] visited;
	static Queue<Integer> q = new ArrayDeque<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tCase = Integer.parseInt(br.readLine());
		command = new StringBuffer[10000];
		StringBuilder sb = new StringBuilder();
		for(int t = 1; t <= tCase; t++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			visited = new boolean[10000];
			for(int i = 0; i < 10000; i++) {
				command[i] = new StringBuffer();
			}
			q.clear();
			command[A].append("");
			q.offer(A);
			visited[A] = true;
			
			while(!q.isEmpty()) {
				int num = q.poll();
				for(char c : "DSLR".toCharArray()) {
					int n = num;
					switch(c) {
					case 'D':
						n = (2 * n) % 10000;
						break;
					case 'S':
						if(n == 0) n = 9999;
						else n--;
						break;
					case 'L':
						n = (n % 1000) * 10 + (n / 1000);
						break;
					case 'R':
						n = (n % 10) * 1000 + (n / 10);
						break;
					}
					if(!visited[n]) {	
						command[n].append(command[num].toString()).append(c);
						visited[n] = true;
						q.offer(n);
					}
				}
			}
			sb.append(command[B] + "\n");
		}
		System.out.println(sb);
	}
}