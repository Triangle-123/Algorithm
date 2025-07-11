import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	String[] names = new String[N + 1];
    	Map<String, Integer> numbers = new HashMap<>();
    	StringBuilder sb = new StringBuilder();
    	for(int i = 1; i <= N; i++) {
    		String name = br.readLine();
    		names[i] = name;
    		numbers.put(name, i);
    	}
    	for(int i = 0; i < M; i++) {
    		String search = br.readLine();
    		if(search.charAt(0) >= 65 && search.charAt(0) <= 91) {
    			sb.append(numbers.get(search));
    		} else sb.append(names[Integer.parseInt(search)]);
    		sb.append("\n");
    	}
    	System.out.println(sb);
    }	
}