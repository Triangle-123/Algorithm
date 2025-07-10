import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String cord = br.readLine().substring(0, 5);
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        for(int i = 0; i < N; i++) {
            String newCord = br.readLine().substring(0, 5);
            if(cord.equals(newCord)) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}