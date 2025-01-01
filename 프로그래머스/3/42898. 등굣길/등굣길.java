class Solution {
    
    static int[][] board, best, count;
    
    public int solution(int m, int n, int[][] puddles) {
        
        int answer = 0;
        
        board = new int[n + 1][m + 1];
        best = new int[n + 1][m + 1];
        count = new int[n + 1][m + 1];
        
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                board[i][j] = 1;
            }
        }
        
        for(int i = 0; i < puddles.length; i++) {
            if(puddles[i].length != 0) {
                board[puddles[i][1]][puddles[i][0]] = -1;
            }
        }
        
        count[1][1] = 1;
        
        topDown(n, m);
        count();
        
        // for(int i = 0; i <= n; i++) {
        //     for(int j = 0; j <= m; j++) {
        //         System.out.print(best[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        // System.out.println("\ncount");
        // for(int i = 0; i <= n; i++) {
        //     for(int j = 0; j <= m; j++) {
        //         System.out.print(count[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        return count[n][m] % 1000000007;
        
    }
    
    public int topDown(int r, int c) {
        if(r < 1 || c < 1) return 9999;
        if(r == 1 && c == 1) return 0;
        if(board[r][c] == -1) {
            best[r][c] = -1;
            return 9999;
        }
        if(best[r][c] != 0) return best[r][c];
        
        int a = board[r][c] + topDown(r - 1, c);
        int b = board[r][c] + topDown(r, c - 1);
        
        best[r][c] = Math.min(a, b);
        return best[r][c];
    }
    
    public void count() {
        for(int r = 1; r < best.length; r++) {
            for(int c = 1; c < best[r].length; c++) {
                if(r > 1 && best[r][c] == best[r - 1][c] + 1) {
                    count[r][c] += count[r - 1][c] % 1000000007;
                }
                if(c > 1 && best[r][c] == best[r][c - 1] + 1) {
                    count[r][c] += count[r][c - 1] % 1000000007;
                }
            }
        }
    }
}       