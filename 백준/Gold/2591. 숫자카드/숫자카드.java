import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] card = br.readLine().split("");
        int[] dp = new int[card.length];
        
        dp[0] = 1;
        for (int i = 1; i < card.length; i++) {
        	if(Integer.parseInt(card[i]) > 0) dp[i] = dp[i - 1];
            if(Integer.parseInt(card[i - 1]) > 0 && Integer.parseInt(card[i - 1] + card[i]) <= 34) {
            	if(i >= 2) dp[i] += dp[i - 2];
            	else dp[i]++;
            }
        }
        System.out.println(dp[card.length - 1]);
        
    }
}