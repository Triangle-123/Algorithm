import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int tCase = Integer.parseInt(br.readLine());
        for(int i = 1; i <= tCase; i++) {
            sb.append("Scenario #" + i + ":\n");
            int wordCnt = Integer.parseInt(br.readLine());
            String[] words = new String[wordCnt]; 
            for(int j = 0; j < words.length; j++) {
                words[j] = br.readLine();
            }
            int user = Integer.parseInt(br.readLine());
            for(int j = 0; j < user; j++) {
                st = new StringTokenizer(br.readLine());
                int password = Integer.parseInt(st.nextToken());
                for(int k = 0; k < password; k++) {
                    int idx = Integer.parseInt(st.nextToken());
                    sb.append(words[idx]);
                }
                sb.append("\n");
            }
            if(i < tCase) sb.append("\n");
        }
        System.out.println(sb);
    }
}