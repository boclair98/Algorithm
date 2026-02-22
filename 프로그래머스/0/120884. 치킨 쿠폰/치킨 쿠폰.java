class Solution {
    public int solution(int chicken) {
        int answer = 0;
        int coupon = 0;
        while(chicken >= 10){
            int ch = chicken / 10;
            int cou = chicken % 10;
            answer+=ch;
            chicken = ch + cou;
        }

        return answer;
    }
}