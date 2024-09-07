import java.util.Scanner;

public class Main {
	
	static int maxSum = 0;
	
	static int[] tetroX = {4, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 2, 2, 3, 3, 2, 2, 3, 3};
	static int[] tetroY = {1, 4, 2, 3, 3, 3, 3, 2, 2, 2, 2, 3, 3, 2, 2, 3, 3, 2, 2};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[][] board = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		
		for(int i = 0; i < tetroX.length; i++) {
			for(int j = 0; j <= n - tetroX[i]; j++) {
				for(int k = 0; k <= m - tetroY[i]; k++) {
					int sum = 0;
					for(int l = 0; l < tetroX[i]; l++) {
						for(int p = 0; p < tetroY[i]; p++) {
							switch(i) {
							case 3:
								if(l == 0 && p != 0) continue;
								break;
							case 4:
								if(l == 0 && p != 2) continue;
								break;
							case 5:
								if(l == 1 && p != 0) continue;
								break;
							case 6:
								if(l == 1 && p != 2) continue;
								break;
							case 7:
								if(l != 2 && p == 1) continue;
								break;
							case 8:
								if(l != 2 && p == 0) continue;
								break;
							case 9:
								if(l != 0 && p == 1) continue;
								break;
							case 10:
								if(l != 0 && p == 0) continue;
								break;
							case 11:
								if((l == 0 && p == 2) || (l == 1 && p == 0)) continue;
								break;
							case 12:
								if((l == 0 && p == 0) || (l == 1 && p == 2)) continue;
								break;
							case 13:
								if((l == 0 && p == 1) || (l == 2 && p == 0)) continue;
								break;
							case 14:
								if((l == 0 && p == 0) || (l == 2 && p == 1)) continue;
								break;
							case 15:
								if(l == 1 && p != 1) continue;
								break;
							case 16:
								if(l == 0 && p != 1) continue;
								break;
							case 17:
								if(l != 1 && p == 0) continue;
								break;
							case 18:
								if(l != 1 && p == 1) continue;
								break;
							default:
								break;
							}
							sum += board[j + l][k + p];
						}
					}
					maxSum = Math.max(maxSum, sum);
				}
			}
			
		}
		System.out.println(maxSum);
	}
}

// 튀어나와 있는 애들은 그냥 박스처리하고 비어있는 인덱스는 건너뛰게 하자
