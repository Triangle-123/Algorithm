import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < S.length(); i++) {
            sb.append(i + "\n");
        }
        System.out.println(sb);
    }
}