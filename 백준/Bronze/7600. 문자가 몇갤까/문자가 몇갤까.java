import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		String str = br.readLine();
		
		while(!str.equals("#")) {
			Set<Character> set = new HashSet<>();
			char[] arr = str.toCharArray();
			for(int i = 0; i < arr.length; i++) {
				if(arr[i] < 65) {
					continue;
				}
				if(arr[i] <= 90) {
					arr[i] += 32;
				}
				set.add(arr[i]);
			}
			
			System.out.println(set.size());
			str = br.readLine();
		}
		
		
	}
}
