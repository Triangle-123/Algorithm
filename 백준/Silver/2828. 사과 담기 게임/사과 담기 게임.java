import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int J = Integer.parseInt(br.readLine());
		int position = 1;
		int distance = 0;
		for(int i = 0; i < J; i++) {
			int apple = Integer.parseInt(br.readLine());
			if(apple >= position && apple <= position + M - 1) {
				continue;
			} else if(apple < position) {
				distance += position - apple;
				position = apple;
			} else {
				distance += apple - position - M + 1;
				position = apple - M + 1;
			}
		}
		System.out.println(distance);
	}
}
