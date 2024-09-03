import java.util.Scanner;

public class Solution {
	
	static int[] price = new int[4];
	static int[] plan = new int[12];
	static int minPrice;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tCase = sc.nextInt();
		for(int t = 1; t <= tCase; t++) {
			
			for(int i = 0; i < 4; i++) {
				price[i] = sc.nextInt();
			}
			
			minPrice = price[3];
			
			for(int i = 0; i < 12; i++) {
				plan[i] = sc.nextInt();
			}
			
			DFS(0, 0);
			System.out.println("#" + t + " " + minPrice);
		}
	}

	private static void DFS(int curr, int idx) {
		
		for(int i = idx; i < 12; i++) {
			if(plan[i] == 0) continue;
			DFS(curr + plan[i] * price[0], i + 1);
			DFS(curr + price[1], i + 1);
			DFS(curr + price[2], i + 3);
			return;
		}
		minPrice = Math.min(curr, minPrice);
		
	}
}
