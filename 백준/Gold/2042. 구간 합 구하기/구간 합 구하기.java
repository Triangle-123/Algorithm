import java.util.*;
import java.io.*;

public class Main {
	
	static long[] tree;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 수의 개수
		int M = Integer.parseInt(st.nextToken()); // 수의 변경이 일어나는 횟수 => update 메서드 호출 횟수
		int K = Integer.parseInt(st.nextToken()); // 구간의 합을 구하는 횟수 => sum 메서드 호출 횟수
		
		long[] arr = new long[N + 1];
		for(int i = 1; i <= N; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		
		int height = (int) Math.ceil(Math.log(arr.length) / Math.log(2));
		int treeSize = (int) Math.pow(2, height + 1);
		
		tree = new long[treeSize];
		init(arr, 1, 1, arr.length - 1);
		
		for(int i = 0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(st.nextToken());
			if(command == 1) {
				int idx = Integer.parseInt(st.nextToken());
				long changeNum = Long.parseLong(st.nextToken());
				update(1, 1, arr.length - 1, idx, changeNum - arr[idx]);
				arr[idx] = changeNum;
			} else {
				int left = Integer.parseInt(st.nextToken());
				int right = Integer.parseInt(st.nextToken());
				sb.append(sum(1, 1, arr.length - 1, left, right) + "\n");
			}
		}
		
		System.out.println(sb);
	}
	
	private static long init(long[] arr, int node, int start, int end) {
		if(start == end) {
			tree[node] = arr[start];
		} else {
			int mid = (start + end) / 2;
			tree[node] = init(arr, node * 2, start, mid) + init(arr, node * 2 + 1, mid + 1, end);
		}
		return tree[node];
	}
	
	private static void update(int node, int start, int end, int idx, long diff) {
		if(start > idx || end < idx) return;
		
		tree[node] += diff;
		
		if(start != end) {
			int mid = (start + end) / 2;
			update(node * 2, start, mid, idx, diff);
			update(node * 2 + 1, mid + 1, end, idx, diff);
		}
	}
	
	private static long sum(int node, int start, int end, int left, int right) {
		if(start > right || end < left) return 0;
		
		if(start >= left && end <= right) return tree[node];
		
		int mid = (start + end) / 2;
		return sum(node * 2, start, mid, left, right) + sum(node * 2 + 1, mid + 1, end, left, right);
	}
}
