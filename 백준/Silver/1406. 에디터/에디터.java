import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		char[] str = br.readLine().toCharArray();
		List<Character> result = new LinkedList<>();
		for(int i = 0; i < str.length; i++) {
			result.add(str[i]);
		}
		int M = Integer.parseInt(br.readLine());
		ListIterator<Character> cursor = result.listIterator(result.size());
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			switch(command) {
			case "L":
				if(cursor.hasPrevious()) {
					cursor.previous();
				}
				break;
			case "D":
				if(cursor.hasNext()) {
					cursor.next();
				}
				break;
			case "B":
				if(cursor.hasPrevious()) {
					cursor.previous();
					cursor.remove();
				}
				break;
			case "P":
				char input = st.nextToken().charAt(0);
				cursor.add(input);
				break;
			}
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		while(!result.isEmpty()) {
			bw.write(result.remove(0));
		}
		bw.close();
	}
}
// 문자열 => 길이 N (N <= 100000)
// 명령어 개수 M (1 <= M <= 500000)
// 한줄씩 주어진다
// 커서의 처음 위치는 문장의 맨 뒤
// 커서의 위치 : 0 <= cursor <= result.size();
// 커서의 현재 위치가 0인 경우 L와 B를 무시
// B는 cursor - 1을 지우고
// D는 cursor가 result.size() 면 무시
// P는 cursor 위치에 바로 삽입