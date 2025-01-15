import java.util.*;
import java.io.*;

public class Main {
	
	static boolean[] visited;
	static String[] inequality;
	static int[] sel;
	static int k;
	static long max = Long.MIN_VALUE;
	static long min = Long.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());
		
		inequality = br.readLine().split(" ");
		visited = new boolean[10];
		sel = new int[k + 1];
		
		perm(0);
		
		String maxResult = "";
		String minResult = "";
		if(max < Math.pow(10, k)) {
			maxResult = "0" + max;
		} else maxResult = Long.toString(max);
		if(min < Math.pow(10, k)) {
			minResult = "0" + min;
		} else minResult = Long.toString(min);
	
		System.out.println(maxResult);
		System.out.println(minResult);
	}

	private static void perm(int idx) {
		
		if(idx == k + 1) {
			for(int i = 0; i < k; i++) {
				if(!((inequality[i].equals("<") && sel[i] < sel[i + 1]) || (inequality[i].equals(">") && sel[i] > sel[i + 1]))) {
					return;
				}
			}
			long result = 0;
			for(int i = k; i >= 0; i--) {
				long multi = 1;
				for(int j = 0; j < i; j++) {
					multi *= 10;
				}
				result += sel[k - i] * multi;
			}
			max = Math.max(max, result);
			min = Math.min(min, result);
			return;
		}
		
		for(int i = 0; i < 10; i++) {
			if(!visited[i]) {
				sel[idx] = i;
				visited[i] = true;
				perm(idx + 1);
				visited[i] = false;
			}			
		}
		
	}
}
