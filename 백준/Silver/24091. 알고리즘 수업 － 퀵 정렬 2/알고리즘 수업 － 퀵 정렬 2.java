import java.util.Scanner;

public class Main {
	
	static int[] arr;
	static int N, K, cnt;
 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		arr = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		quickSort(0, N - 1);
		
		if(cnt < K) System.out.println(-1);
		
	}

	private static void quickSort(int left, int right) {
		
		if(left < right) {
			int pivot = lomutoPartition(left, right);
			quickSort(left, pivot - 1);
			quickSort(pivot + 1, right);
		}
		
	}

	private static int lomutoPartition(int left, int right) {
		int pivot = right;
		
		int i = left - 1;
		
		for(int j = left; j < right; j++) {
			if(arr[j] <= arr[pivot]) {
				i++;
				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
				cnt++;
			}
			if(cnt == K) {
				for(int k = 0; k < arr.length; k++) {
					System.out.print(arr[k] + " ");
				}
				System.out.println();
				return -1;
			}
		}
		if(pivot != i + 1) {
			int temp = arr[i + 1];
			arr[i + 1] = arr[pivot];
			arr[pivot] = temp;
			cnt++;
			if(cnt == K) {
				for(int k = 0; k < arr.length; k++) {
					System.out.print(arr[k] + " ");
				}
				System.out.println();
				return -1;
			}
		}
		
		return i + 1;
	}
}
