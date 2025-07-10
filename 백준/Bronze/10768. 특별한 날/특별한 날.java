import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int month = Integer.parseInt(br.readLine());
        int day = Integer.parseInt(br.readLine());
        if(month < 2 || (month == 2 && day < 18)) {
            System.out.println("Before");
        } else if(month > 2 || (month == 2 && day > 18)) {
            System.out.println("After");
        } else System.out.println("Special");
    }
}