import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tCase = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= tCase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			String[][] map = new String[r][c];
			
			int tankR = 0;
			int tankC = 0;
			for(int i = 0; i < r; i++) {
				map[i] = br.readLine().split("");
				for(int j = 0; j < c; j++) {
					if(map[i][j].equals("^") || map[i][j].equals("v") || map[i][j].equals("<") || map[i][j].equals(">")) {
						tankR = i;
						tankC = j;
					}
				}
			}
			int[] dr = {-1, 1, 0, 0};
			int[] dc = {0, 0, -1, 1};
			int d = 0;
			
			switch(map[tankR][tankC]) {
			case "^":
				d = 0;
				break;
			case "v":
				d = 1;
				break;
			case "<":
				d = 2;
				break;
			case ">":
				d = 3;
				break;
			}
			
			int command = Integer.parseInt(br.readLine());
			String str = br.readLine();
			
			for(int i = 0; i < str.length(); i++) {
				char com = str.charAt(i);
				if(com != 'S') {
					switch(com) {
					case 'U':
						d = 0;
						map[tankR][tankC] = "^";
						break;
					case 'D':
						d = 1;
						map[tankR][tankC] = "v";
						break;
					case 'L':
						d = 2;
						map[tankR][tankC] = "<";
						break;
					case 'R':
						d = 3;
						map[tankR][tankC] = ">";
						break;
					}
					int nr = tankR + dr[d];
					int nc = tankC + dc[d];
					if(nr >= 0 && nc >= 0 && nr < r && nc < c && map[nr][nc].equals(".")) {
						String temp = map[tankR][tankC];
						map[tankR][tankC] = map[nr][nc];
						map[nr][nc] = temp;
						tankR = nr;
						tankC = nc;
					}
				} else {
					int nr = tankR + dr[d];
					int nc = tankC + dc[d];
					while(nr < r && nc < c && nr >= 0 && nc >= 0 && !map[nr][nc].equals("#") ) {
						if(map[nr][nc].equals("*")) {
							map[nr][nc] = ".";
							break;
						}
						nr += dr[d];
						nc += dc[d];
					}
				}
			}	
			System.out.print("#" + t + " ");
			for(int i = 0; i < r; i++) {
				for(int j = 0; j < c; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
	}
}