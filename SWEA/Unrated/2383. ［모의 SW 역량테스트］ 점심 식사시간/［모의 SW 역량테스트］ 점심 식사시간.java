import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
	
	static int minTime;
	static List<int[]> person;
	static int[][] time;
	static int[][] stair;
	static int[] stairTime, sel0, sel1;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tCase = sc.nextInt();
		
		for(int t = 1; t <= tCase; t++) {
			int n = sc.nextInt();
			person = new ArrayList<>();
			stair = new int[2][2];
			stairTime = new int[2];
			int idx = 0;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					int num = sc.nextInt();
					if(num == 1) {
						person.add(new int[] {i, j});
					} else if(num > 1) {
						stair[idx] = new int[] {i, j};
						stairTime[idx++] = num;
					}
				}
			}
			
			time = new int[2][person.size()];
			sel0 = new int[person.size()];
			sel1 = new int[person.size()];
			for(int j = 0; j < stair.length; j++) {
				for(int i = 0; i < person.size(); i++) {
					int currDis = Math.abs(person.get(i)[0] - stair[j][0]) + Math.abs(person.get(i)[1] - stair[j][1]);
					time[j][i] = currDis + stairTime[j] + 1;
				}
			}
			
			minTime = Integer.MAX_VALUE;
			lunch(0, 0, 0);
			
			System.out.println("#" + t + " " + minTime);
		}
	}

	private static void lunch(int idx, int sidx1, int sidx2) {
		
		if(idx == person.size()) {
			int maxTime = 0;
			int[] time1 = new int[sidx1];
			int[] time2 = new int[sidx2];
			int idx1 = 0;
			int idx2 = 0;
			for(int i = 0; i < sel0.length; i++) {
				if(sel0[i] == 1) time1[idx1++] = time[0][i];
				else if(sel1[i] == 1) time2[idx2++] = time[1][i];
			}
			Arrays.sort(time1);
			Arrays.sort(time2);
			if(sidx1 > 3) {
				for(int i = 3; i < sidx1; i++) {
					if(time1[i - 3] + stairTime[0] > time1[i]) time1[i] = time1[i - 3] + stairTime[0];
				}
			}
			if(sidx2 > 3) {
				for(int i = 3; i < sidx2; i++) {
					if(time2[i - 3] + stairTime[1] > time2[i]) time2[i] = time2[i - 3] + stairTime[1];
				}
			}
			for(int i = 0; i < sidx1; i++) {
				maxTime = Math.max(maxTime, time1[i]);
			}
			for(int i = 0; i < sidx2; i++) {
				maxTime = Math.max(maxTime, time2[i]);
			}
			minTime = Math.min(maxTime, minTime);
			return;
		}
		
		sel0[idx] = 1;
		sel1[idx] = 0;
		lunch(idx + 1, sidx1 + 1, sidx2);
		sel0[idx] = 0;
		sel1[idx] = 1;
		lunch(idx + 1, sidx1, sidx2 + 1);
		
		
	}
}
