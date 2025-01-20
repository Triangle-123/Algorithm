import java.util.*;
import java.io.*;

public class Main {
	
	// 배열을 순회하며 조건에 충족할때 까지 검사
	// 배열이 매우 커도 이 방식이 통할까?
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		int[] hole = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			hole[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(hole);
		
		int cnt = 1;
		int left = hole[0];
		for(int i = 0; i < N; i++) {
			if(left + L < hole[i] + 1) {
				cnt++;
				left = hole[i];
			}
		}
		System.out.println(cnt);
	}
}
