import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
	
	static int N, M;
	static int[] sel;
	static boolean[] visited;
	static int[] data;
	static Set<String> compare = new HashSet<>();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		data = new int[N];
		sel = new int[M];
		visited = new boolean[N];
		
		for(int i = 0; i < N; i++) {
			data[i] = sc.nextInt();
		}
		Arrays.sort(data);
		perm(0);
		List<String> list = new ArrayList<>(compare);
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				String[] s1 = o1.split(" ");
				String[] s2 = o2.split(" ");
				
				for(int i = 0; i < s1.length; i++) {
					if(Integer.parseInt(s1[i]) == Integer.parseInt(s2[i])) continue;
					return Integer.parseInt(s1[i]) - Integer.parseInt(s2[i]);
				}
				return 0;
			}
		});
		for(int i = 0; i < list.size(); i++) {
			sb.append(list.get(i));
		}
		System.out.println(sb);
	}

	private static void perm(int idx) {
		if(idx == M) {
			StringBuilder sb2 = new StringBuilder();
			for(int i = 0; i < sel.length; i++) {
				sb2.append(sel[i] + " ");
			}
			sb2.append("\n");
			compare.add(sb2.toString());

			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				sel[idx] = data[i];
				perm(idx + 1);
				visited[i] = false;
			}
		}
	}
}
