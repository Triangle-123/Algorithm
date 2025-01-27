import java.util.*;
import java.io.*;

public class Main {
	
	static class Node {
		int prev;
		int next;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Node[] station = new Node[1000001];
		
		st = new StringTokenizer(br.readLine());
		int first = Integer.parseInt(st.nextToken());
		int prev = first;
		station[first] = new Node();
		for(int i = 1; i < N - 1; i++) {
			int curr = Integer.parseInt(st.nextToken());
			station[curr] = new Node();
			station[curr].prev = prev;
			station[prev].next = curr;
			prev = curr;
		}
		int last = Integer.parseInt(st.nextToken());
		station[last] = new Node();
		station[last].prev = prev;
		station[prev].next = last;
		station[last].next = first;
		station[first].prev = last;
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			int currStation = Integer.parseInt(st.nextToken());
			switch(command) {
			case "BN":
				int newStation = Integer.parseInt(st.nextToken());
				int next = station[currStation].next;
				sb.append(next + "\n");
				if(station[newStation] == null) {
					station[newStation] = new Node();
					station[next].prev = newStation;
					station[newStation].next = next;
					station[newStation].prev = currStation;
					station[currStation].next = newStation;
				}
				break;
			case "BP":
				newStation = Integer.parseInt(st.nextToken());
				prev = station[currStation].prev;
				sb.append(prev + "\n");
				if(station[newStation] == null) {
					station[newStation] = new Node();
					station[prev].next = newStation;
					station[newStation].prev = prev;
					station[newStation].next = currStation;
					station[currStation].prev = newStation;
				}
				break;
			case "CN":
				next = station[currStation].next;
				sb.append(next + "\n");
				station[currStation].next = station[next].next;
				station[station[next].next].prev = currStation;
				station[next] = null;
				break;
			case "CP":
				prev = station[currStation].prev;
				sb.append(prev + "\n");
				station[currStation].prev = station[prev].prev;
				station[station[prev].prev].next = currStation;
				station[prev] = null;
				break;
			}
		}
		System.out.println(sb);
	}
}
