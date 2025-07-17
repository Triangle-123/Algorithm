import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        int R = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        list.add(0);
        int length = L * R / 100;
        while(length > 5) {
            list.add(length);
            length = length * R / 100;
        }
        int sum = 0;
        for(int i = 1; i < list.size(); i++) {
            sum += ((int)Math.pow(2, i) * list.get(i));
        }
        System.out.println(sum);
    }
}