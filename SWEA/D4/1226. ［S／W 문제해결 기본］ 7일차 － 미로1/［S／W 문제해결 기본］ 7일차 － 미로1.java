import java.util.*;
import java.io.FileInputStream;

class Solution
{
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] board;
    static boolean[][] visited;
    static Queue<Integer> q = new ArrayDeque<>();
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		for(int t = 1; t <= 10; t++) {
			int tCase = sc.nextInt();
            board = new int[16][16];
            visited = new boolean[16][16];
            
            for(int i = 0; i < 16; i++) {
                String[] str = sc.next().split("");
            	for(int j = 0; j < 16; j++) {
                	board[i][j] = Integer.parseInt(str[j]);
                    if(board[i][j] == 2) {
                        q.clear();
                        q.offer(i);
                        q.offer(j);
               		}
            	}
            }
    	System.out.println("#" + t + " " + BFS());
	}
    } 
    private static int BFS() {
    	while(!q.isEmpty()) {
        	int r = q.poll();
            int c = q.poll();
            visited[r][c] = true;
            if(board[r][c] == 3) return 1;
            for(int d = 0; d < 4; d++) {
            	int nr = r + dr[d];
                int nc = c + dc[d];
                
                if(nr < board.length && nr >= 0 && nc < board[nr].length && nc >= 0 && !visited[nr][nc] && board[nr][nc] != 1) {
                	visited[nr][nc] = true;
                    q.offer(nr);
                    q.offer(nc);
                }
            
            }
        
        }
    	return 0;
    }
}