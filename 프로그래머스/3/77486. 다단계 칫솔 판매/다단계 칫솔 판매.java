class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        int[] referralIdx = new int[referral.length];
        
        // referral의 판매원이 enroll의 몇번째인지 찾기
        for(int i = 0; i < referral.length; i++) {
            for(int j = 0; j < enroll.length; j++) {
                if(referral[i].equals("-")) {
                    referralIdx[i] = -1;
                    continue;
                } else if(referral[i].equals(enroll[j])) {
                    referralIdx[i] = j;
                    break;
                }
            }
        }
        
        
        for(int i = 0; i < seller.length; i++) {
            int sellerIdx = 0;
            for(int j = 0; j < enroll.length; j++) {
                if(seller[i].equals(enroll[j])) {
                    sellerIdx = j;
                    break;
                }
            }
            int payment = (amount[i] * 100) / 10;
            answer[sellerIdx] += (amount[i] * 100) - payment;
            int payment2 = 0;
            while(payment >= 1) {
                payment2 = payment / 10;
                payment -= payment2;
                if(referralIdx[sellerIdx] != -1) {
                    answer[referralIdx[sellerIdx]] += payment;
                    payment = payment2;
                    sellerIdx = referralIdx[sellerIdx];
                } else {
                    
                    payment = 0;
                }
            }
            if(payment > 0) {
                answer[sellerIdx] += payment;
            }
        }
        
        
        return answer;
    }
}

// center를 제외한 판매원 배열 enroll
// enroll의 각 인덱스의 상위 판매원 배열 referral(상위 없으면 "-")
// 판매량에 연결되는 판매원 배열 seller
// 판매량 배열 amount (이익금은 판매량 * 100)

// center를 제외한 판매원은 상위 판매원에게 자신의 이익의 10%를 줌
// 그 10%를 계속해서 10%로 분할해 상위에게 줌
// 실수처리 없이 10으로 나누면 되고
// 받은 이익이 10원 미만이면 자신이 가짐
// 이익의 총 합에서 10%가 아니라 자신에게 들어오는 이익 당 한번씩 계산하는 것
// enroll의 순서대로 나열해야 하기에 그것만 신경쓰면 될 듯

// 각 판매원이 얻은 이익금을 나열한 배열 return (enroll 순서대로, 정수형)