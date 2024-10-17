import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[][] map;
	static int[] dc = {-1, 0, 1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N + 1][3];
		StringTokenizer st;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] dpMin = new int[N + 1][3];
		int[][] dpMax = new int[N + 1][3];
		
        // dpMax[i][j]: i번째 줄의 j번째 칸(0, 1, 2)까지 내려갔을 때의 최대 합
        // dpMin[i][j]: i번째 줄의 j번째 칸(0, 1, 2)까지 내려갔을 때의 최소 합
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < 3; j++) {
				dpMin[i][j] = Integer.MAX_VALUE;
				dpMax[i][j] = Integer.MIN_VALUE;
				for (int d = 0; d < 3; d++) {
					int pc = j + dc[d];
					if (pc < 0 || pc >= 3) continue;
					dpMin[i][j] = Math.min(dpMin[i][j], map[i][j] + dpMin[i - 1][pc]);
					dpMax[i][j] = Math.max(dpMax[i][j], map[i][j] + dpMax[i - 1][pc]);
				}
			}
		}
		
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			max = Math.max(max, dpMax[N][i]);
			min = Math.min(min, dpMin[N][i]);
		}
		System.out.println(max + " " + min);
	}
}
