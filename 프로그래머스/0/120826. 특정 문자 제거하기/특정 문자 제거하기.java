class Solution {
    public String solution(String my_string, String letter) {
        String answer = "";
        for(int i = 0; i < my_string.length(); i++){
            char chars = my_string.charAt(i);
            if(!String.valueOf(chars).equals(letter)){
                answer+=chars;
            }
        }
        return answer;
    }
}