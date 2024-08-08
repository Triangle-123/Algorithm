/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.FileInputStream;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tCase = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= tCase; t++) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] arr = new int[n];
			for(int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i = 1; i < n; i++) {  // 정렬되지 않은 부분 (0은 정렬된 부분으로 간주)
				int data = arr[i];
				
				int j;
				for(j = i - 1; j >= 0 && data < arr[j]; j--) {  // 뒤에서부터 조회하며 현재 값보다 큰 부분들을 밀어줌
					arr[j + 1] = arr[j];
				}
				
				arr[j + 1] = data; // 다 밀고 다음 부분에 현재 값을 대입
				
			}
			
			System.out.printf("#%d ", t);
			for(int i = 0; i < n; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
		}
	}
}