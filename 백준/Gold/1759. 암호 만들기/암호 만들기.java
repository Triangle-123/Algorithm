import java.util.Scanner;

public class Main {
	
	static char[] data;
	static char[] moum = {'a', 'e', 'i', 'o', 'u'};
	static char[] temp;
	static char[] sel;
	static int L, C;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		L = sc.nextInt();
		C = sc.nextInt();
		
		data = new char[C];
		temp = new char[C];
		sel = new char[L];
		for(int i = 0; i < C; i++) {
			data[i] = sc.next().charAt(0);
		}
		
		mergeSort(0, data.length - 1);
		
		combi(0, 0);
	}
	private static void combi(int idx, int sidx) {
		if(sidx == L) {
			int mCnt = 0;
			int jCnt = 0;
			loop: for(int i = 0; i < sel.length; i++) {
				boolean ismoum = false;
				for(int j = 0; j < moum.length; j++) {
					if(sel[i] == moum[j]) {
						ismoum = true;
					}
				}
				if(ismoum) mCnt++;
				else jCnt++;
			}
			
			if(mCnt >= 1 && jCnt >= 2) {
				for(int i = 0; i < sel.length; i++) {
					System.out.print(sel[i]);
				}
				System.out.println();
			}
			return;
		}
		if(idx == C) return;
		sel[sidx] = data[idx];
		combi(idx + 1, sidx + 1);
		combi(idx + 1, sidx);
		
		
	}
	static void mergeSort(int left, int right) {
		if(left < right) {
			int mid = (left + right) / 2;
			mergeSort(left, mid);
			mergeSort(mid + 1, right);
			merge(left, mid, right);
		}
		
	}
	static void merge(int left, int mid, int right) {
		int L = left;
		int R = mid + 1;
		int idx = left;
		
		while(L <= mid && R <= right) {
			if(data[L] < data[R]) {
				temp[idx++] = data[L++];
			} else {
				temp[idx++] = data[R++];
			}
		}
		
		if(L <= mid) {
			for(int i = L; i <= mid; i++) {
				temp[idx++] = data[i];
			}
		} else {
			for(int i = R; i <= right; i++) {
				temp[idx++] = data[i];
			}
		}
		
		for(int i = left; i <= right; i++) {
			data[i] = temp[i];
		}
	}
}
