import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		String[][] arr = new String[n][n];
		
		List<Integer> list = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			arr[i] = br.readLine().split("");
		}
		
		int cnt = 0;
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(arr[i][j].equals("1")) {
					cnt = houseCount(arr, i, j);
					list.add(cnt);
					cnt = 0;
				}
			}
		}
		
		Collections.sort(list);
		System.out.println(list.size());
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	
	
	static int houseCount(String[][] arr, int r, int c) {
		int cnt = 0;
		arr[r][c] = "0";
		cnt++;
		int d = 0;
		while(d < 4) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(nr >= 0 && nc >= 0 && nr < arr.length && nc < arr.length && !arr[nr][nc].equals("0")) {
				cnt += houseCount(arr, nr, nc);
			} else {
				d++;
			}
		}
		return cnt;
	}
}