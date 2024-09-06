import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static int[][] island;
	static int[][] visited;
	static boolean[][] searched;
	static int N, M;
	static int[] p;
	
	static int num = 1;
	
	static class Edge {
		int A, B, W;

		public Edge(int a, int b, int w) {
			super();
			A = a;
			B = b;
			W = w;
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		island = new int[N][M];
		visited = new int[N][M];
		searched = new boolean[N][M];
		List<Edge> elist = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				island[i][j] = sc.nextInt();
			}
		}
		
		int V = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(island[i][j] == 1 && visited[i][j] == 0) {
					BFS(i, j);
					num++;
					V++;
				}
			}
		}
		
		for(int i = 0; i < N; i++) {
			Arrays.fill(visited[i], 0);
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(island[i][j] != 0 && !searched[i][j]) {
					for(int d = 0; d < 4; d++) {
						int nr = i + dr[d];
						int nc = j + dc[d];
						int cnt = 0;
						while(nr < N && nc < M && nr >= 0 && nc >= 0 && island[nr][nc] != island[i][j]) {
							if(island[nr][nc] != 0) {
								if(cnt >= 2) {
									int A = island[i][j];
									int B = island[nr][nc];
									elist.add(new Edge(A, B, cnt));
								}
								break;
							} else {
								nr += dr[d];
								nc += dc[d];
								cnt++;
							}
						}
					}
				}
			}
		}
		
		Collections.sort(elist, (o1, o2) -> o1.W - o2.W);
		
		p = new int[V + 1];
		for(int i = 1; i < p.length; i++) {
			p[i] = i;
		}
		
		int sum = 0;
		int cnt = 0;
		for(int i = 0; i < elist.size(); i++) {
			if(cnt == V - 1) break;
			int A = elist.get(i).A;
			int B = elist.get(i).B;
			
			if(union(A, B)) {
				sum += elist.get(i).W;
				cnt++;
			}
		}
		
//		for(int i = 1; i <= V; i++) {
//			System.out.println("p[i] = " + p[i]);
//			System.out.println("find(i) = " + find(i));
//		}
		int com = find(1);
		for(int i = 2; i <= V; i++) {
			if(find(i) != com) {
				sum = -1;
				break;
			}
		}
		
		
		System.out.println(sum);
				
	}
	private static boolean union(int x, int y) {
		int xRoot = find(x);
		int yRoot = find(y);
		
		if(xRoot == yRoot) return false;
		p[yRoot] = xRoot;
		return true;	
	}
	
	
	private static int find(int x) {
		if(x != p[x]) {
			p[x] = find(p[x]);
		}
		return p[x];
	}
	private static void BFS(int i, int j) {
		visited[i][j] = 1;
		island[i][j] = num;
		Queue<Integer> q = new LinkedList<>();
		q.offer(i);
		q.offer(j);
		
		while(!q.isEmpty()) {
			int r = q.poll();
			int c = q.poll();
			
			for(int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(nr < N && nr >= 0 && nc < M && nc >= 0 && visited[nr][nc] == 0 && island[nr][nc] != 0) {
					island[nr][nc] = num;
					q.offer(nr);
					q.offer(nc);
					visited[nr][nc] = 1;
				}
			}
		}
	}
}
