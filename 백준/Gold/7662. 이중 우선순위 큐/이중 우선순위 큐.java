import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main { // 우선순위 "큐"라매!!!!
	// 이걸 어떻게 모르고 푸냐
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tCase = Integer.parseInt(br.readLine());
		TreeMap<Integer, Integer> q = new TreeMap<>();
		for(int t = 1; t <= tCase; t++) {
			q.clear();
			int n = Integer.parseInt(br.readLine());
			for(int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String command = st.nextToken();
				if(command.equals("I")) {
					int num = Integer.parseInt(st.nextToken());
					q.put(num, q.getOrDefault(num, 0) + 1);
				} else {
					if(q.isEmpty()) continue;
					int num = Integer.parseInt(st.nextToken());
                    int key = num == 1 ? q.lastKey() : q.firstKey();
                    int cnt = q.get(key);
                    
                    if(cnt == 1) {
                    	q.remove(key);
                    }
                    else {
                    	q.put(key, q.get(key) - 1);
                    }
				}
			}
			if(q.isEmpty()) System.out.println("EMPTY");
			else System.out.println(q.lastKey() + " " + q.firstKey());
		}
	
	}
}
