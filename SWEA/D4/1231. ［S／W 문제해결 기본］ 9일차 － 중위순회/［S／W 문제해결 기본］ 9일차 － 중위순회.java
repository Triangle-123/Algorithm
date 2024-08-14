import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t = 1; t <= 10; t++) {
			int n = Integer.parseInt(br.readLine());
			char[] tree = new char[n + 1];
			for(int i = 1; i < tree.length; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				if(i == Integer.parseInt(st.nextToken())) {
					tree[i] = st.nextToken().charAt(0);
				} else tree[i] = 0;
			}
			
			System.out.print("#" + t + " ");
			inOrder(tree, 1);
			System.out.println();
		}
	}
	
	static void inOrder(char[] tree, int root) {
		if(root >= tree.length || tree[root] == 0) {
			return;
		}
		
		inOrder(tree, root * 2);
		System.out.print(tree[root]);
		inOrder(tree, root * 2 + 1);
	}
}
