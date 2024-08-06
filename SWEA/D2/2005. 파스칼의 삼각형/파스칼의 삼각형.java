import java.util.Scanner;
import java.io.FileInputStream;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tCase = sc.nextInt();
		for(int t = 1; t <= tCase; t++) {
			int n = sc.nextInt();
			int[][] arr = new int[n][n];
			
			int idx = 0;
			for(int i = 0; i < n; i++) {
				idx++;
				if(i == 0) {
					arr[i][0] = 1;
					continue;
				}
				for(int j = 0; j < idx; j++) {
					if(j == 0) arr[i][j] = arr[i - 1][j];
					else if(j == idx - 1) arr[i][j] = arr[i - 1][j - 1];
					else arr[i][j] = arr[i - 1][j] + arr[i - 1][j - 1];
				}
			}
			
			System.out.println("#" + t);
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(arr[i][j] != 0) System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
}
