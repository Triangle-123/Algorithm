import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((i1, i2) -> i2 - i1);
		PriorityQueue<Integer> minHeap = new PriorityQueue<>((i1, i2) -> i1 - i2);
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int curr = 0;
		for(int i = 0; i < N; i++) {
			Integer num = Integer.parseInt(br.readLine());
			if(maxHeap.size() == minHeap.size()) {
				maxHeap.offer(num);
			} else minHeap.offer(num);
			if(!maxHeap.isEmpty() && !minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
				int temp = maxHeap.poll();
				maxHeap.offer(minHeap.poll());
				minHeap.offer(temp);
			}
			sb.append(maxHeap.peek() + "\n");
		}
		System.out.println(sb);
	}
}
// 최대힙 최소힙을 PQ로 만들고
// 두 PQ의 사이즈가 같으면 최대힙에 입력
// 두 PQ의 사이즈가 다르면 최소힙에 입력
// 만약 최대힙에 들어간 수가 최소힙의 최소값보다 크다면 교환
// 최소힙에 들어간 수가 최대힙의 최대값보다 작다면 교환