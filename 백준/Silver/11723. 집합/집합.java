import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int M = Integer.parseInt(br.readLine());
		Set<Integer> set = new HashSet<>();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			boolean isExist = false;
			int num = 0;
			if(!(command.equals("all") || command.equals("empty"))) {
				num = Integer.parseInt(st.nextToken());
				isExist = set.contains(num);
			}
			switch(command) {
			case "add":
				set.add(num);
				break;
			case "remove":
				set.remove(num);
				break;
			case "check":
				if(isExist) sb.append(1 + "\n");
				else sb.append(0 + "\n");
				break;
			case "toggle":
				if(isExist) set.remove(num);
				else set.add(num);
				break;
			case "all":
				for(int j = 1; j <= 20; j++) {
					set.add(j);
				}
				break;
			case "empty":
				set.clear();
				break;
			}
		}
		System.out.println(sb);
	}
}
