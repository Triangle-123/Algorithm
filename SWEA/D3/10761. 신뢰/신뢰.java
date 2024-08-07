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
			
			int Time = 0;
			int bPosition = 1;
			int oPosition = 1;
			int bMove = 0;
			int oMove = 0;
			
			for(int i = 0; i < n; i++) {
				if(st.nextToken().equals("B")) {
					int nextPosition = Integer.parseInt(st.nextToken());
					if(Math.abs(bPosition - nextPosition) <= bMove) {
						bPosition = nextPosition;
						bMove = 0;
					}
					Time += Math.abs(bPosition - nextPosition) + 1 - bMove;
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