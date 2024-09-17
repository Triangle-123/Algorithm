import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int N, maxScore;
	static int[][] player;
	static int[] sel;
	static boolean[] visited;
	static Queue<Integer> q = new ArrayDeque<>();
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		player = new int[N][9];
		sel = new int[9];
		visited = new boolean[9];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < 9; j++) {
				player[i][j] = sc.nextInt();
			}
		}
		
		sel[3] = 0;
		
		perm(0);
		System.out.println(maxScore);
	}


	private static void perm(int idx) {
		if(idx == 9) {
			int innings = 0;
			int order = 0;
			int sumScore = 0;
			int totalScore = 0;
			int out = 0;
			int run = 0;
			while(true) {
				int score = player[innings][sel[order]];
				switch(score) {
				case 0:
					out++;
					if(out == 3) {
						innings++;
						totalScore += sumScore;
						sumScore = 0;
						run = 0;
						q.clear();
						out = 0;
					}
					if(innings == N) {
						maxScore = Math.max(maxScore, totalScore);
						return;
					}
					break;
				case 4:
					sumScore++;
					while(!q.isEmpty()) {
						q.poll();
						sumScore++;
					}
					run = 0;
					break;
				default:
					q.offer(score);
					run += score;
					while(run >= 4) {
						run -= q.poll();
						sumScore++;		
					}
					break;
				}
				order = (order + 1) % 9;
			}
		}
		if(idx == 3) {
			perm(idx + 1);
		} else {
			for(int i = 1; i < 9; i++) {
				if(!visited[i]) {
					sel[idx] = i;
					visited[i] = true;
					perm(idx + 1);
					visited[i] = false;
				}
				
			}	
		}
	}
}
// 1번은 4번에 박아놓고
// 나머지를 어떻게 하든 번호에 박아두고 ( 순열? )
// 이닝별로 0이면 아웃
// 1 ~ 3이면 큐에 넣고 sum에 더하고
// sum이 4이상이면 큐에서 뽑으면서 sum에서 빼고 점수는 +1
// 홈런(4)이면 큐에서 다뽑으면서 그 수만큼 +1
// 모든 경우 다 돌려보면 되려나?
 