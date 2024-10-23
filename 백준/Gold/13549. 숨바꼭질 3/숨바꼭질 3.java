import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static class Node implements Comparable<Node> {
		int vertex, cost;

		public Node(int vertex, int cost) {
			this.vertex = vertex;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}

	static int[] dist;
	
	private static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		dist[start] = 0;
		pq.offer(new Node(start, 0));
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			if (dist[cur.vertex] < cur.cost) continue;
			
			// 순간이동
			if (cur.vertex * 2 <= 100000 && dist[cur.vertex * 2] > dist[cur.vertex]) {
				dist[cur.vertex * 2] = dist[cur.vertex];
				pq.offer(new Node(cur.vertex * 2, dist[cur.vertex]));
			}
			
			// 걷기
			if (cur.vertex + 1 <= 100000 && dist[cur.vertex + 1] > dist[cur.vertex] + 1) {
				dist[cur.vertex + 1] = dist[cur.vertex] + 1;
				pq.offer(new Node(cur.vertex + 1, dist[cur.vertex] + 1));
			}
			if (cur.vertex - 1 >= 0 && dist[cur.vertex - 1] > dist[cur.vertex] + 1) {
				dist[cur.vertex - 1] = dist[cur.vertex] + 1;
				pq.offer(new Node(cur.vertex - 1, dist[cur.vertex] + 1));
			}
		}
	}
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        dist = new int[100001];
        Arrays.fill(dist, 999999);
        
        dijkstra(N);
        System.out.println(dist[K]);
    }
}