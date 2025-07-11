import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int[] arr = new int[N];
    	for(int i = 0; i < N; i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    	}
    	int x = Integer.parseInt(br.readLine());
    	Arrays.sort(arr);
    	int cnt = 0;
    	int left = 0;
    	int right = N - 1;
    	while(left < right) {
    		int sum = arr[left] + arr[right];
    		if(sum < x) {
    			left++;
    		} else if(sum > x) {
    			right--;
    		} else {
    			cnt++;
    			left++;
    		}
    	}
    	System.out.println(cnt);
    }	
}