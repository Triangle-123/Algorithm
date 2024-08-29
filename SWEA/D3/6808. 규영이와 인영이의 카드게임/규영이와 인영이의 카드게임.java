import java.util.Scanner;

public class Solution {
	static int[] kyu, in, sel;
	static int N;
	static boolean[] visited;
	static int wCnt, lCnt;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tCase = sc.nextInt();
		for(int t = 1; t <= tCase; t++) {
			kyu = new int[9];
			in = new int[9];
			N = in.length;
			sel = new int[N];
			visited = new boolean[N];
			for(int i = 0; i < N; i++) {
				kyu[i] = sc.nextInt();
			}
			int idx = 0;
			loop: for(int i = 1; i <= 18; i++) {
				for(int j = 0; j < N; j++) {
					if(kyu[j] == i) continue loop;
				}
				in[idx++] = i; 
			}
			
			wCnt = 0;
			lCnt = 0;
			perm(0);
			
			System.out.println("#" + t + " " + wCnt + " " + lCnt);
			
		}
		
	}

	private static void perm(int idx) {
		
		if(idx == N) {
			int kyuScore = 0;
			int inScore = 0;
			
			for(int i = 0; i < N; i++) {
				if(kyu[i] > sel[i]) kyuScore += kyu[i] + sel[i];
				else inScore += kyu[i] + sel[i];
			}
			
			if(kyuScore > inScore) wCnt++;
			else lCnt++;
			
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				sel[idx] = in[i];
				perm(idx + 1);
				visited[i] = false;
			}
		}
		
	}
}
