import java.util.Scanner;
import java.io.FileInputStream;

public class Solution {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for(int i = 1; i <= t; i++) {
			int p = sc.nextInt();
			int q = sc.nextInt();
			
			int p1 = 0;
			int p2 = 0;
			
			int q1 = 0;
			int q2 = 0;
			
			int cnt = 1;
			int j = 1;
			int k = j;
			int l = 1;
			while(true) {
				if(cnt == p) {
					p1 = k;
					p2 = l;
				}
				if(cnt == q) {
					q1 = k;
					q2 = l;
				}
				if(p2 != 0 && q2 != 0) break;
				k--;
				l++;
				cnt++;
				if(k < 1) {
					j++;
					k = j;
					l = 1;
				}
				
			}
			
			cnt = 1;
			j = 1;
			k = j;
			l = 1;
			while(true) {
				if(k == (p1 + q1) && l == (p2 + q2)) break;
				
				k--;
				l++;
				cnt++;
				if(k < 1) {
					j++;
					k = j;
					l = 1;
				}
				
			}
			System.out.println("#" + i + " " + cnt);
		}
	}
}
