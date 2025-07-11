import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
    	Deque<Integer> deque = new ArrayDeque<>();
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	int command = Integer.parseInt(br.readLine());
    	StringBuilder sb = new StringBuilder();
    	for(int i = 0; i < command; i++) {
    		st = new StringTokenizer(br.readLine());
    		int x;
    		Integer y;
    		switch(st.nextToken()) {
    		case "push_front":
    			x = Integer.parseInt(st.nextToken());
    			deque.offerFirst(x);
    			break;
    		case "push_back":
    			x = Integer.parseInt(st.nextToken());
    			deque.offerLast(x);
    			break;
    		case "pop_front":
    			y = deque.pollFirst();
    			if(y == null) {
    				y = -1;
    			}
    			sb.append(y + "\n");
    			break;
    		case "pop_back":
    			y = deque.pollLast();
    			if(y == null) {
    				y = -1;
    			}
    			sb.append(y + "\n");
    			break;
    		case "front":
    			y = deque.peekFirst();
    			if(y == null) {
    				y = -1;
    			}
    			sb.append(y + "\n");
    			break;
    		case "back":
    			y = deque.peekLast();
    			if(y == null) {
    				y = -1;
    			}
    			sb.append(y + "\n");
    			break;
    		case "size":
    			sb.append(deque.size() + "\n");
    			break;
    		case "empty":
    			if(deque.isEmpty()) {
    				y = 1;
    			} else y = 0;
    			sb.append(y + "\n");
    			break;
    		}
    	}
    	System.out.println(sb);
    }
}