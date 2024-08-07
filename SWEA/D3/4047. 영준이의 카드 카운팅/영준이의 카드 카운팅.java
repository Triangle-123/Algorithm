import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.io.FileInputStream;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tCase = Integer.parseInt(br.readLine());
		
		String[] shape = {"S", "D", "H", "C"};
		
		
		loop: for(int t = 1; t <= tCase; t++) {
			Map<String, Integer> map = new HashMap<>();
			
			for(int i = 0; i < 4; i++) {
				for(int j = 1; j <= 13; j++) {
					if(j < 10) {
						map.put(shape[i] + "0" + j, 0);						
					}
					else {
						map.put(shape[i] + j, 0);
					}
				}
			}
			
			String[] arr = br.readLine().split("");
			for(int i = 0; i < arr.length - 2; i += 3) {
				String card = arr[i] + arr[i + 1] + arr[i + 2];
				if(map.get(card) == 0) {
					map.put(card, 1);
				} else {
					System.out.print("#" + t + " ");
					System.out.println("ERROR");
					continue loop;
				}
			}
			
			System.out.print("#" + t + " ");
			for(int i = 0; i < 4; i++) {
				int sum = 0;
				for(int j = 1; j <= 13; j++) {
					if(j < 10) {
						sum += map.get(shape[i] + "0" + j);						
					}
					else {
						sum += map.get(shape[i] + j);
					}
				}
				System.out.print(13 - sum + " ");
			}
			System.out.println();
		}
		
	}
}