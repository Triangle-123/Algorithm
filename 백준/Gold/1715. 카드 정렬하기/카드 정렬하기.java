import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>((i1, i2) -> i1 - i2);
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			pq.offer(num);
		}
		List<Integer> compare = new ArrayList<>();
		int compareCnt = 0;
		while(pq.size() >= 2) {
			int prev = pq.poll();
			int next = pq.poll();
			compare.add(prev + next);
			pq.offer(prev + next);
		}
		for(int i = 0; i < compare.size(); i++) {
			compareCnt += compare.get(i);
		}
		System.out.println(compareCnt);
	}
}