import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[1000000];
		for(int i = 0; i < 1000000; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		quickSort(0, arr.length - 1);
		
		System.out.println(arr[500000]);
		
		
	}
	private static void quickSort(int left, int right) {
		
		if(left < right) {
			int pivot = partition(left, right);
			quickSort(left, pivot - 1);
			quickSort(pivot + 1, right);
		}
		
	}
	private static int partition(int left, int right) {
		int pivot = left;
		int L = left + 1;
		int R = right;
		
		while(L <= R) {
			while(L <= R && arr[L] <= arr[pivot]) L++;
			while(arr[R] > arr[pivot]) R--;
			
			if(L < R) {
				int temp = arr[L];
				arr[L] = arr[R];
				arr[R] = temp;
			}
		}
		
		int temp = arr[R];
		arr[R] = arr[pivot];
		arr[pivot] = temp;
		
		return R;
	}
}
