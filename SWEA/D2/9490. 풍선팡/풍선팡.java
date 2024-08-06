/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tCase = Integer.parseInt(br.readLine());
		for(int t = 1; t <= tCase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			int[][] arr = new int[n][m];
			
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < m; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int max = 0;
			
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					int sum = recursive(arr, i, j, arr[i][j]);
					max = Math.max(max, sum);
				}
			}
			
			System.out.printf("#%d %d\n", t, max);
			
 		}
	}
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	
	static int recursive(int[][] arr, int i, int j, int n) {
		int sum = 0;
		
		if(n == 0) return arr[i][j];
		
		for(int k = 0; k < 4; k++) {
			int nr = i + (dr[k] * n);
			int nc = j + (dc[k] * n);
			
			if(nr < arr.length && nc < arr[i].length && nr >= 0 && nc >= 0) {
				sum += arr[nr][nc];
			}
		}
		
		return sum + recursive(arr, i , j, n - 1);
	}
}