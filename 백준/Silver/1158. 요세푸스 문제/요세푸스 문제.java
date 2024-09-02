import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		List<Integer> list = new LinkedList<>();
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		for(int i = 1; i <= n; i++) {
			list.add(i);
		}
		int curr = k - 1;
		int[] arr = new int[n];
		int idx = 0;
		while(true) {
			arr[idx++] = list.get(curr);
			list.remove(curr);
			if(list.isEmpty()) break;
			curr = (curr + k - 1) % list.size();
		}
		
		System.out.print("<");
		for(int i = 0; i < arr.length - 1; i++) {
			System.out.print(arr[i] + ", ");
		}
		System.out.println(arr[n - 1] + ">");
	}
}
