import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int[][] graph;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t = 1; t <= 10; t++) {
			int n = Integer.parseInt(br.readLine());
			String[] tree = new String[n + 1];
			graph = new int[n + 1][2];
			tree[0] = "!";
			for(int i = 1; i < tree.length; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				if(i == Integer.parseInt(st.nextToken())) {
					tree[i] = st.nextToken();
					if(tree[i].equals("-") || tree[i].equals("+") || tree[i].equals("*") || tree[i].equals("/")) {
						graph[i][0] = Integer.parseInt(st.nextToken()); // 왼쪽
						graph[i][1] = Integer.parseInt(st.nextToken()); // 오른쪽
					}
				} else tree[i] = "!";
			}
			System.out.print("#" + t + " ");
			System.out.println(inOrder(tree, 1)); 
		}
	}
	
	static int inOrder(String[] tree, int root) {
		if(root >= tree.length || tree[root].equals("!")) {
			return 0;
		}
		
		int iLeft = inOrder(tree, graph[root][0]);
		int iRight = inOrder(tree, graph[root][1]);
		
		switch(tree[root]) {
		case "+":
			return iLeft + iRight;
		case "-":
			return iLeft - iRight;
		case "*":
			return iLeft * iRight ;
		case "/":
			return iLeft / iRight;
		default:
			return Integer.parseInt(tree[root]);
		}
	}
}
