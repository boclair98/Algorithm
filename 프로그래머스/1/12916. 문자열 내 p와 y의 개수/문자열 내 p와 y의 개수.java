class Solution {
    boolean solution(String s) {
        boolean answer = false;
        int count1 = 0;
        int count2 = 0;
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i) =='p' || s.charAt(i) =='P'){
                count1++;
            }else if(s.charAt(i) =='y' || s.charAt(i) =='Y'){
                count2++;
            }
        }
        if(count1 == count2){
            answer =true;
        }

        return answer;
    }
}