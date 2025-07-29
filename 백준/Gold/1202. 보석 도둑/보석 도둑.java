import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] jewel = new int[N][2];
		int[] backpack = new int[K];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			jewel[i][0] = Integer.parseInt(st.nextToken());
			jewel[i][1] = Integer.parseInt(st.nextToken());
		}
		for(int i = 0; i < K; i++) {
			backpack[i] = Integer.parseInt(br.readLine());
		}
		Comparator<int[]> comparator = new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0]) return o2[1] - o1[1];
				return o1[0] - o2[0];
			}
		};
		Arrays.sort(jewel, comparator);
		Arrays.sort(backpack);
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((i1, i2) -> i2 - i1);
		int idx = 0;
		long sum = 0;
		for(int i = 0; i < K; i++) {
			for(int j = idx; j < N; j++) {
				if(backpack[i] >= jewel[j][0]) {
					maxHeap.offer(jewel[j][1]);
					idx++;
				} else break;
			}
			if(!maxHeap.isEmpty()) sum += maxHeap.poll();
		}
		System.out.println(sum);
	}
}
// 보석 배열과 가방 배열을 정렬한 뒤
// 가방별로 보석을 검사하며 우선순위 큐(최대힙)에 가방 무게보다 작은 보석들을 추가
// 그곳에서 하나를 뽑으면 그 가방에 넣을 수 있는 최대 가격의 보석인 것
// 이미 넣은 보석들은 다시 검사하지 않기 때문에 시간적으로 이득