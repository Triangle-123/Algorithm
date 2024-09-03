import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static int A, B, C;
	static List<Integer> list = new ArrayList<>();
	static boolean[][][] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		A = sc.nextInt();
		B = sc.nextInt();
		C = sc.nextInt();
		
		visited = new boolean[A + 1][B + 1][C + 1];
		
		DFS(0, 0, C);
		Collections.sort(list);
		for(int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
	}
	private static void DFS(int a, int b, int c) {
		
		if(visited[a][b][c]) return;
		else if(a == 0) list.add(c);
		
		visited[a][b][c] = true;
		
		if(a + b <= A) {
			DFS(a+b, 0, c);
		} else DFS(A, (a + b) - A ,c);
		
		if(a + c <= A) {
			DFS(a+c, b, 0);
		} else DFS(A, b, (a + c) - A);
		
		if(a + b <= B) {
			DFS(0, a+b, c);
		} else DFS((a + b) - B, B, c);
		
		if(b + c <= B) {
			DFS(a, b+c, 0);
		} else DFS(a, B, (b + c) - B);
		
		if(a + c <= C) {
			DFS(0, b, a+c);
		} else DFS((a + c) - C, b, C);
		
		if(b + c <= C) {
			DFS(a, 0, b+c);
		} else DFS(a, (b + c) - C, C);
		
	}	
}