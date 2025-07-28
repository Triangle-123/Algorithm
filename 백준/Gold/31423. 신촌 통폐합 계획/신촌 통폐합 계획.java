import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] arr = new String[N + 1];
		int[] tail = new int[N + 1];
		int[] next = new int[N + 1];
		for(int i = 1; i <= N; i++) {
			String school = br.readLine();
			arr[i] = school;
			tail[i] = i;
		}
		StringTokenizer st;
		int r = 0;
		for(int k = 1; k < N; k++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			next[tail[i]] = j;
			tail[i] = tail[j];
			if(k == N - 1) {
				r = i;
			}
		}
		StringBuffer sb = new StringBuffer();
		int curr = r;
		while(curr != 0) {
			sb.append(arr[curr]);
			curr = next[curr];
		}
		System.out.println(sb);
	}
}