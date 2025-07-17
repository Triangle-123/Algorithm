import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int[][] arr = new int[H][W];
		st = new StringTokenizer(br.readLine());
		for(int j = 0; j < W; j++) {
			int N = Integer.parseInt(st.nextToken());
			for(int i = 0; i < N; i++) {
				arr[H - i - 1][j] = 1;
			}
		}
		
		boolean block = false;
		int cnt = 0;
		int rainwater = 0;
		for(int i = 0; i < H; i++) {
			block = false;
			cnt = 0;
			for(int j = 0; j < W; j++) {
				if(!block && arr[i][j] == 0) continue;
				if(!block && arr[i][j] == 1) block = true;
				else if(block && arr[i][j] == 1) {
					rainwater += cnt;
					cnt = 0;
				}
				else if(arr[i][j] == 0) cnt++;
			}
		}
		System.out.println(rainwater);
	}
}
