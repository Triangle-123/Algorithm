import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static boolean[][] visited;
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static int sheep = 0;
	static int wolf = 0;
	static int sheepTotal = 0;
	static int wolfTotal = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		char[][] arr = new char[r][c];
		
		visited = new boolean[r][c];
		
		for(int i = 0; i < r; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				if(arr[i][j] == '#' || visited[i][j]) continue;
				battle(arr, i, j);
				if(sheep > wolf) sheepTotal += sheep;
				else wolfTotal += wolf;
				sheep = 0;
				wolf = 0;
			}
		}
	
		System.out.println(sheepTotal + " " + wolfTotal);
	}
	
	static void battle(char[][] arr, int i, int j) {
		if(visited[i][j] || arr[i][j] == '#') return;
		visited[i][j] = true;
		
		if(arr[i][j] == 'o') sheep++;
		else if(arr[i][j] == 'v') wolf++;
		
		for(int d = 0; d < 4; d++) {
			int nr = i + dr[d];
			int nc = j + dc[d];
			
			if(nr >= 0 && nc >= 0 && nr < arr.length && nc < arr[i].length && arr[i][j] != '#' || !visited[i][j]) {
				battle(arr, nr, nc);
			}
		}
	}
}
