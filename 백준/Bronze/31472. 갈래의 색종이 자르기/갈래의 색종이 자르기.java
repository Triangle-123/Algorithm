import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int W = sc.nextInt();
        int ans = ((int)Math.sqrt(W * 2)) * 4;
        System.out.println(ans);
    }
}