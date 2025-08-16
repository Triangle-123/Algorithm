import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        
        long num1 = A;
        long num2 = B;
        while(num1 != num2) {
            if(num1 > num2) {
                num2 += B;
            } else if(num2 > num1) {
                num1 += A;
            }
        }
        System.out.println(num2);
    }
}