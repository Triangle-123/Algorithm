import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();
		int sum = 0;
		for(int i = 0; i < n; i++) {
			list.add(Integer.parseInt(br.readLine()));
			map.put(list.get(i), 0);
			sum += list.get(i);
		}
		
		for(int i = 0; i < n; i++) {
			map.put(list.get(i), map.get(list.get(i)) + 1);
		}
		
		long result1 = Math.round((double)sum / n);

		Collections.sort(list);
		int result2 = list.get(n/2);
		
		int maxcnt = 0;
		int result3 = 0;
		
		for(int i = 0; i < n; i++) {
			if(map.get(list.get(i)) > maxcnt) { 
				maxcnt = map.get(list.get(i));
				result3 = list.get(i);
			}
		}
		
		
		boolean isMin = true;
		for(int i = 0; i < n; i++) {
			if(map.get(list.get(i)) == maxcnt) {
				if(isMin && result3 < list.get(i)) {
					result3 = list.get(i);
					isMin = false;
				}
			}
		}
		
		int result4 = list.get(n - 1) - list.get(0);
	
		System.out.println(result1);
		System.out.println(result2);
		System.out.println(result3);
		System.out.println(result4);
		
	}
}
