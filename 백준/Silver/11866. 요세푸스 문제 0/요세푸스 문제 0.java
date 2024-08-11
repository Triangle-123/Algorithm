import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		List<Integer> list = new ArrayList<>();
		
		for(int i = 1; i <= n; i++) {
			list.add(i);
		}
		
		int i = 0;
		System.out.print("<");
		while(!list.isEmpty()) {
			i += k - 1;
			while(i >= list.size()) {
				i -= list.size();
			}
			System.out.print(list.get(i));
			if(list.size() != 1) {
				System.out.print(", ");
			}
			list.remove(i);
		}
		System.out.print(">");
	}
}