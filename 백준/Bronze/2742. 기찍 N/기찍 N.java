import java.util.*;
import java.io.*;

class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i = N; i > 0; i--) {
            System.out.println(i);
        }
    }
    
}