import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.FileInputStream;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tCase = Integer.parseInt(br.readLine());
		for(int t = 1; t <= tCase; t++) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			Queue<String> deck1 = new LinkedList<>();
			Queue<String> deck2 = new LinkedList<>();
			
			if(n % 2 != 0) {
				for(int i = 0; i < n / 2 + 1; i++) {
					deck1.offer(st.nextToken());
				}
				for(int i = 0; i < n / 2; i++) {
					deck2.offer(st.nextToken());
				}
			} else {
				for(int i = 0; i < n / 2; i++) {
					deck1.offer(st.nextToken());
				}
				for(int i = 0; i < n / 2; i++) {
					deck2.offer(st.nextToken());
				}
			}
			
			System.out.print("#" + t + " ");
			while(!deck1.isEmpty()) {
				System.out.print(deck1.poll() + " ");
				if(!deck2.isEmpty()) {
					System.out.print(deck2.poll() + " ");
				}
			}
			System.out.println();
			
		}
	}
}