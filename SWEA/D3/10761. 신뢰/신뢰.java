import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.FileInputStream;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tCase = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= tCase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			
			int Time = 0;       // 총 시간
			int bPosition = 1;
			int oPosition = 1;  //  블루 오렌지 현재 위치
			int bMove = 0;
			int oMove = 0; // 블루와 오렌지가 움직일 수 있었던 값
			
			for(int i = 0; i < n; i++) {
				if(st.nextToken().equals("B")) {
					int nextPosition = Integer.parseInt(st.nextToken());
					if(Math.abs(bPosition - nextPosition) <= bMove) { // 목표 위치로 가는 소요시간보다 움직일 수 있던 시간이 많았으면
						bPosition = nextPosition;                    // 실제로는 가서 기다렸을 것
						bMove = 0;
					}
					Time += Math.abs(bPosition - nextPosition) + 1 - bMove;   // 움직일 수 있던 것보다 소요시간이 더 많이 든다면 움직인만큼 빼준다
					oMove += Math.abs(bPosition - nextPosition) + 1 - bMove;
					bPosition = nextPosition;
					bMove = 0;
				} else {
					int nextPosition = Integer.parseInt(st.nextToken());
					if(Math.abs(oPosition - nextPosition) <= oMove) {
						oPosition = nextPosition;
						oMove = 0;
					}
					Time += Math.abs(oPosition - nextPosition) + 1 - oMove;
					bMove += Math.abs(oPosition - nextPosition) + 1 - oMove;
					oPosition = nextPosition;
					oMove = 0;
				}
			}
			
			System.out.printf("#%d %d\n", t, Time);
		}
	}
}