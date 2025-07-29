import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0;
        int before = 0;
        int curr = 0;
        for(int i = 0; i < N; i++) {
            int phone = Integer.parseInt(st.nextToken());
            if(phone == curr) sum += before *= 2;
            else {
                sum += 2;
                before = 2;
                curr = phone;
            }
            if(sum >= 100) {
                sum = 0;
                curr = 0;
                before = 0;
            }
        }
        System.out.println(sum);
    }
}