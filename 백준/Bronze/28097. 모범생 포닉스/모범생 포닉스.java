import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int time = 0;
        for(int i = 0; i < N; i++) {
            int t = Integer.parseInt(st.nextToken());
            time += t;
            if(i < N - 1) time += 8;
        }
        System.out.println((time / 24) + " " + (time % 24));
    }
}