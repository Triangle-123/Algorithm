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
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			int[] buyer = new int[n];
			for(int i = 0; i < n; i++) {
				buyer[i] = Integer.parseInt(st.nextToken());
			}
			
			
			for(int i = 1; i < n; i++) {
				int data = buyer[i];
				
				int j;
				for(j = i - 1; j >= 0 && data < buyer[j]; j--) {
					buyer[j + 1] = buyer[j];
				}
				buyer[j + 1] = data;
			}
			
			Queue<Integer> queue = new LinkedList<>();
			for(int i = 0; i < n; i++) {
				queue.offer(buyer[i]);
			}
			
			boolean isFirst = true;
			
			System.out.print("#" + t + " ");
			int pollCnt = 0;
			while(true) {
				if(queue.peek() >= m) {
					if(isFirst) {
						queue.poll();
						isFirst = false;
						pollCnt++;
					}
					else if(queue.peek() - (m / k) * pollCnt >= m / k) {
						queue.poll();
						pollCnt++;
					} else {
						System.out.println("Impossible");
						break;
					}
					
				} else {
					System.out.println("Impossible");
					break;
				}
				if(queue.isEmpty()) {
					System.out.println("Possible");
					break;
				}
			}
		}
	}
}