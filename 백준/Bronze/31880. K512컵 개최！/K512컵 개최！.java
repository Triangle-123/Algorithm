import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long luck = 0;
        st = new StringTokenizer(br.readLine());
        for(int j = 0; j < N; j++) {
            luck += Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int j = 0; j < M; j++) {
            int multi = Integer.parseInt(st.nextToken());
            if(multi > 1) {
                luck *= multi;
            }
        }
        System.out.println(luck);
    }
}