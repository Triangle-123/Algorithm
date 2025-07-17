import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int ans = 0;
        if(c == 0) {
            ans = (int) Math.sqrt(a + b);
        } else ans = ((int)Math.pow(c, 2)) - a - b;
        System.out.println(ans);
    }
}