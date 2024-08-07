import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.FileInputStream;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t = 1; t <= 10; t++) {
			int tCase = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			Queue<Integer> queue = new LinkedList<>();
			
			for(int i = 0; i < 8; i++) {
				queue.offer(Integer.parseInt(st.nextToken()));
			}
			
			int n = 1;
			while(true) {
				int p = queue.poll() - n;
				if(p <= 0) {
					p = 0;
					queue.offer(p);
					break;
				}
				queue.offer(p);
				n = n + 1 > 5 ? 1 : n + 1;
			}
			
			System.out.print("#" + tCase + " ");
			for(int i = 0; i < 8; i++) {
				System.out.print(queue.poll() + " ");
			}
			System.out.println();
		}
	}
}