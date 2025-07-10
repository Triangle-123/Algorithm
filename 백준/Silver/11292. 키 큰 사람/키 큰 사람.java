import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int sdt = Integer.parseInt(br.readLine());
        while(sdt > 0) {
           String[] name = new String[sdt];
           double[] tall = new double[sdt];
           for(int i = 0; i < sdt; i++) {
               st = new StringTokenizer(br.readLine());
               name[i] = st.nextToken();
               tall[i] = Double.parseDouble(st.nextToken());
           }
           double max = tall[0];
           List<String> list = new ArrayList<>();
           for(int i = 0; i < sdt; i++) {
               if(tall[i] > max) {
                   max = tall[i];
                   list.clear();
                   list.add(name[i]);
               } else if(tall[i] == max) {
                   list.add(name[i]);
               }
           }
           for(int i = 0; i < list.size(); i++) {
               sb.append(list.get(i) + " ");
           }
           sb.append("\n");
           sdt = Integer.parseInt(br.readLine());
        }
        System.out.println(sb);
    }
}