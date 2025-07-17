import java.util.*;
import java.io.*;

class Main {
    
    private static int fact(int i) {
        if(i == 2) return i;
        if(i < 2) return 1;
        return i * fact(i - 1);
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();
        while(!str.equals("0")) {
            int sum = 0;
            for(int i = 0; i < str.length(); i++) {
                sum += (str.charAt(i) - '0') * fact(str.length() - i);
            }
            sb.append(sum + "\n");
            str = br.readLine();
        }
        System.out.println(sb);
    }
}