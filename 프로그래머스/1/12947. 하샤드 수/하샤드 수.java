class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        int num = 0 ;
        String number = String.valueOf(x);
        for(int i = 0; i<number.length(); i++){
            num+=Integer.parseInt(String.valueOf(number.charAt(i)));
        }
        if(x%num != 0){
            answer = false;
        }
        return answer;
    }
}