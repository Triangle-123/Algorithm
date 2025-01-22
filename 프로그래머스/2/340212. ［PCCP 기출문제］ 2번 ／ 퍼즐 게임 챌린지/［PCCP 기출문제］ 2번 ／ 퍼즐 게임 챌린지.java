import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = Integer.MAX_VALUE;
        
        int[] arr = diffs.clone();
        Arrays.sort(arr);
        int left = arr[0];
        int right = arr[arr.length - 1];
        while(left <= right) {
            int mid = (left + right) / 2;
            long sum = 0;
            for(int i = 0; i < diffs.length; i++) {
               if(mid >= diffs[i]) {
                   sum += times[i];
               } else if(i > 0) {
                   sum += times[i] + ((times[i] + times[i - 1]) * (diffs[i] - mid));
               }
            }
            if(sum <= limit) {
                if(answer > mid) {
                    answer = mid;
                }
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        
        
        return answer;
    }
}
// diff : 난이도
// limit 내에 퍼즐을 모두 풀기 위한 숙련도의 최솟값
// level : 숙련도
// 1 또는 0을 left로
// diff를 right로 
// 이분탐색하며 숙련도를 정함
// 정한 숙련도로 퍼즐을 푼다
