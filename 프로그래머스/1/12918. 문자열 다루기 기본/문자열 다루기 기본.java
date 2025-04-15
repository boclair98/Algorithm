class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        int idx = s.length();
        if(idx == 4 || idx == 6){
            for (int i = 0; i<idx; i++){
                char word = s.charAt(i);
                if(Character.isAlphabetic(word)){
                    answer = false;
                    break;
                }
            }
        }else{
            answer = false;
        }
        return answer;
    }
}