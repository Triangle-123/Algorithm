import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static List<int[]> house = new ArrayList<>();
	static List<int[]> chicken = new ArrayList<>();
	static int N, M;
	static int[][] sel;
	static int minSum = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int[][] arr = new int[N][N];
		sel = new int[M][2];
		
		
		for(int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int num = sc.nextInt();
				arr[i][j] = num;
				if(num == 2) {
					chicken.add(new int[] {i, j});
				} else if(num == 1) {
					house.add(new int[] {i, j});
				}
			}
		}
		
		combi(0, 0);
		System.out.println(minSum);
				
	}

	private static void combi(int idx, int sidx) {
		
		if(sidx == M) {
			int sum = 0;
			for(int i = 0; i < house.size(); i++) {
				int currMin = Integer.MAX_VALUE;
				for(int j = 0; j < sel.length; j++) {
					currMin = Math.min(currMin, Math.abs(house.get(i)[0] - sel[j][0]) + Math.abs(house.get(i)[1] - sel[j][1])); 
				}
				sum += currMin;
				if(sum > minSum) return;
			}
			minSum = Math.min(minSum, sum);
			return;
		}
		
		if(idx == chicken.size()) return;
		
		sel[sidx][0] = chicken.get(idx)[0];
		sel[sidx][1] = chicken.get(idx)[1];
		combi(idx + 1, sidx + 1);
		combi(idx + 1, sidx);
		
	}
}
