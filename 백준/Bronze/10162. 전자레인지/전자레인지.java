import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        String ans = "";
        if(T % 10 != 0) ans = "-1";
        else {
            int time = 0;
            int A = 0;
            int B = 0;
            int C = 0;
            while(time < T) {
                if(time + 300 <= T) {
                    A++;
                    time += 300;
                } else if(time + 60 <= T) {
                    B++;
                    time += 60;
                } else {
                    C += (T - time) / 10;
                    time += T - time;
                } 
            }
            ans = A + " " + B + " " + C;
        }
        System.out.println(ans);
    }
}