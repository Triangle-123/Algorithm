import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.FileInputStream;

public class Solution {
	static int change;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		for(int i = 1; i <= t; i++) {
			st = new StringTokenizer(br.readLine());
			char[] arr = st.nextToken().toCharArray();
			change = Integer.parseInt(st.nextToken());
		
			arr = isBig(arr);
			
			System.out.printf("#%d ", i);
			for(int j = 0; j < arr.length; j++) {
				System.out.print(arr[j]);
			}
			System.out.println();
		}
	}
	
	static char[] isBig(char[] arr) {
		char[] arr1 = new char[arr.length];
		char[] arr2 = new char[arr.length];
		
		for(int i = 0; i < arr.length; i++) {
			arr1[i] = arr[i];
			arr2[i] = arr[i];
		}
		arr1 = maxarr(arr1);
		arr2 = minarr(arr2);
		int iarr1 = Integer.parseInt(String.valueOf(arr1));
		int iarr2 = Integer.parseInt(String.valueOf(arr2));
		
		if(iarr1 > iarr2) return arr1;
		else return arr2;
	}
	
	static char[] minarr(char[] arr) {
		int change_count = change;
		while(true) {
			for(int j = arr.length - 1; j > 0; j--) {
				int minIdx = j;
				for(int k = j - 1; k >= 0; k--) {
					if(arr[minIdx] > arr[k]) minIdx = k;
				}
				if(minIdx == j) continue;
				char temp = arr[j];
				arr[j] = arr[minIdx];
				arr[minIdx] = temp;
				change_count--;
				if(change_count <= 0) return arr;
			}
			
			while(true) {
				for(int j = 0; j < arr.length-1; j++) {
					if(arr[j] == arr[j+1]) return arr;
				}
				char temp = arr[arr.length - 1];
				arr[arr.length - 1] = arr[arr.length - 2];
				arr[arr.length - 2] = temp;
				change_count--;
				if(change_count <= 0) return arr;
			}
		}
	}
	
	static char[] maxarr(char[] arr) {
		int change_count = change;
		while(true) {
			for(int j = 0; j < arr.length - 1; j++) {
				int maxIdx = j;
				for(int k = j + 1; k < arr.length; k++) {
					if(arr[maxIdx] <= arr[k]) maxIdx = k;
				}
				if(maxIdx == j) continue;
				char temp = arr[j];
				arr[j] = arr[maxIdx];
				arr[maxIdx] = temp;
				change_count--;
				if(change_count <= 0) return arr;
			}
			
			while(true) {
				for(int j = 0; j < arr.length-1; j++) {
					if(arr[j] == arr[j+1]) return arr;
				}
				char temp = arr[arr.length - 1];
				arr[arr.length - 1] = arr[arr.length - 2];
				arr[arr.length - 2] = temp;
				change_count--;
				if(change_count <= 0) return arr;
			}
		}
	}
}
