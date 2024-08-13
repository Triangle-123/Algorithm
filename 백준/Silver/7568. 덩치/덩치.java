import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n][2];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < 2; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		int rank = 1;
		for(int j = 0; j < n; j++) {
			rank = 1;
			for(int i = 0; i < n; i++) {
				if(j == i) continue;
				if(arr[j][0] < arr[i][0] && arr[j][1] < arr[i][1]) rank++;
			}
			System.out.print(rank + " ");
		}
	}
}