import java.util.*;
import java.io.*;

public class Main {
	
	static int N, K;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		sortGame(arr);
	}

	private static void sortGame(int[] arr) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(arr);
		int cnt = 0;
		Map<String, Integer> map = new HashMap<>();
		while(!q.isEmpty()) {
			int qSize = q.size();
			loop: for(int s = 0; s < qSize; s += 1) {
				int[] poll = q.poll();
				boolean sorted = true;
				for(int i = 1; i < N; i++) {
					if(poll[i] < poll[i - 1]) {
						sorted = false;
						break;
					}
				}
				if(sorted) {
					System.out.println(cnt);
					return;
				}
				String compare = "";
				for(int i = 0; i < N; i++) {
					compare += poll[i];
				}
				if(map.containsKey(compare)) continue loop;
				map.put(compare, cnt);
				for(int i = 0; i < N; i++) {
					if(N - i >= K) {
						int[] newArr = poll.clone();
						Stack<Integer> stack = new Stack<>();
						for(int j = 0; j < K; j++) {
							stack.push(newArr[i + j]);
						}
						for(int j = 0; j < K; j++) {
							newArr[i + j] = stack.pop();
						}
						q.offer(newArr);
					}
				}				
			}
			cnt++;
		}
		System.out.println(-1);
	}
}
	