class Solution {
    
    static boolean iswon;
    static int maxDiff = Integer.MIN_VALUE;
    static int[] result = new int[11];
    
    public int[] solution(int n, int[] info) {
        
        int[] lion = new int[11];
       
        battle(0, n, lion, info);
        
        if(!iswon) {
            result = new int[] {-1};
        }
        return result;
    }
    
    private void battle(int idx, int arrow, int[] lion, int[] info) {
            
        
        if(idx == 11 || arrow == 0) {
            
            if(arrow > 0) lion[10] += arrow;
            
            int infoSum = 0;
            int lionSum = 0;
            for(int i = 0; i < 11; i++) {
                if(info[i] != 0 || lion[i] != 0) {
                    if(lion[i] > info[i]) {
                        lionSum += (10 - i);
                    }
                    else infoSum += (10 - i);
                }
            }
            
            if(infoSum < lionSum && maxDiff < lionSum - infoSum) {
                maxDiff = lionSum - infoSum;
                for(int i = 0; i < 11; i++) {
                    result[i] = lion[i];
                }
                iswon = true;
            }
            else if (maxDiff == lionSum - infoSum) {
                boolean same = true;
                for(int i = 10; i >= 0; i--) {
                    if(lion[i] > result[i]) {
                        for(int j = 0; j < 11; j++) {
                            result[j] = lion[j];
                        }
                        break;
                    } else if(result[i] > lion[i]) {
                        break;
                    }
                }
            }
            if(arrow > 0) lion[10] -= arrow;
            return;
        }
        
        if(arrow >= info[idx] + 1) {
            lion[idx] = info[idx] + 1;
            battle(idx + 1, arrow - lion[idx], lion, info);
            lion[idx] = 0;
        }
        
        battle(idx + 1, arrow, lion, info);
    }
}