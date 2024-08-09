import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int tCase = Integer.parseInt(br.readLine());
		
		int[] primeNum = new int[1000001];
		for(int i = 2; i < primeNum.length; i++) {
			primeNum[i] = i;
		}
		for(int i = 0; i < primeNum.length; i++) {
			if(primeNum[i] == 0) continue;
					
			for(int j = 2; j * j <= primeNum[i]; j++) {
				if(primeNum[i] != j && primeNum[i] % j == 0) primeNum[i] = 0;
			}
		}
		
		for(int t = 1; t <= tCase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String d = st.nextToken();
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
 			int cnt = 0;
 			
			for(int i = a; i <= b; i++) {
				if(primeNum[i] != 0 && Integer.toString(primeNum[i]).contains(d)) {
					cnt++;
				}
			}
			
			bw.write("#" + t + " " + cnt);
			bw.newLine();
		}
		
		bw.flush();
		bw.close();
	}
}