import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] board = new int[N + 1][M + 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            board[i][0] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int j = 1; j <= M; j++) {
            board[0][j] = Integer.parseInt(st.nextToken());
        }
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= M; j++) {
                if(board[i - 1][j] == board[i][j - 1]) {
                    board[i][j] = 0;
                } else board[i][j] = 1;
            }
        }
        System.out.println(board[N][M]);
    }
}