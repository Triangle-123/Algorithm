import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	static int[] arr;
	static int[] temp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new int[n];
		temp = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		mergeSort(0, arr.length - 1);
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < arr.length; i++) {
			sb.append(arr[i] + "\n");
		}
		System.out.println(sb);
	}

	private static void mergeSort(int left, int right) {
		if(left < right) {
			int mid = (left + right) / 2;
			mergeSort(left, mid);
			mergeSort(mid + 1, right);
			merge(left, mid, right);
		}
		
	}

	private static void merge(int left, int mid, int right) {
		int L = left;
		int R = mid + 1;
		int idx = left;
		
		while(L <= mid && R <= right) {
			if(arr[L] < arr[R]) {
				temp[idx++] = arr[L++];
			} else {
				temp[idx++] = arr[R++];
			}
		}
		
		if(L <= mid) {
			for(int i = L; i <= mid; i++) {
				temp[idx++] = arr[i];
			}
		} else {
			for(int i = R; i <= right; i++) {
				temp[idx++] = arr[i];
			}
		}
		
		for(int i = left; i <= right; i++) {
			arr[i] = temp[i];
		}
	}
}
