import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int aSize = Integer.parseInt(st.nextToken());
		int bSize = Integer.parseInt(st.nextToken());
		int[] arrA = new int[aSize];
		int[] arrB = new int[bSize];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < aSize; i++) {
			arrA[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < bSize; i++) {
			arrB[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arrA);
		Arrays.sort(arrB);
		List<Integer> list = new ArrayList<>();
		for(int i = 0; i < aSize; i++) {
			int left = 0;
			int right = bSize - 1;
			boolean find = false;
			while(left <= right) {
				int mid = (left + right) / 2;
				if(arrB[mid] < arrA[i]) left = mid + 1;
				else if(arrB[mid] > arrA[i]) right = mid - 1;
				else {
					find = true;
					break;
				}
			}
			if(!find) list.add(arrA[i]);
		}
		StringBuilder sb = new StringBuilder();
		sb.append(list.size() + "\n");
		for(int i = 0; i < list.size(); i++) {
			sb.append(list.get(i) + " ");
		}
		System.out.println(sb);
	}
}
