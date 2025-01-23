import java.util.*;
import java.io.*;

public class Main {
	
	static List<Integer>[] questions;
	static int[] strikes, balls;
	static int result, N;
	static boolean[] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		questions = new ArrayList[N];
		strikes = new int[N];
		balls = new int[N];
		visited = new boolean[10];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			questions[i] = new ArrayList<>();
			int question = Integer.parseInt(st.nextToken());
			questions[i].add(question / 100);
			questions[i].add((question % 100) / 10);
			questions[i].add(question % 10);
			strikes[i] = Integer.parseInt(st.nextToken());
			balls[i] = Integer.parseInt(st.nextToken());
		}
		
		perm(2, new ArrayList<Integer>());
		
		System.out.println(result);
	}

	private static void perm(int idx, List<Integer> answer) {
		
		if(idx < 0) {
			for(int i = 0; i < N; i++) {
				int strike = 0;
				int ball = 0;
				for(int j = 0; j < 3; j++) {
					if(answer.get(j) == questions[i].get(j)) {
						strike++;
					} else if(answer.contains(questions[i].get(j))) {
						ball++;
					}
				}
				if(strike != strikes[i] || ball != balls[i]) {
					return;
				}
			}
			result++;
			return;
		}
		
		for(int i = 1; i < 10; i++) {
			if(visited[i]) continue;
			answer.add(i);
			visited[i] = true;
			perm(idx - 1, answer);
			visited[i] = false;
			answer.remove(answer.size() - 1);
		}
		
	}
}

// 백트래킹으로 모두 따지기