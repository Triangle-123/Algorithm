import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[][] arr = new int[N][2];
		
		for(int i = 0; i < N; i++) {
			arr[i][0] = i;
			arr[i][1] = sc.nextInt();
		}
		
		Arrays.sort(arr, (o1, o2) -> o1[1] - o2[1]);
		int temp = Integer.MAX_VALUE;
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			if(arr[i][1] != temp) {
				temp = arr[i][1];
				arr[i][1] = cnt++;
			} else {
				arr[i][1] = cnt - 1;
			}
		}
		
		Arrays.sort(arr, (o1, o2) -> o1[0] - o2[0]);
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			sb.append(arr[i][1] + " ");
		}
		System.out.println(sb);
		
	}
}
// 좌표 압축 하는 테크닉
// 원본배열 변경을 위해 이전값을 담아놓고 비교하는 테크닉도 외워두자.