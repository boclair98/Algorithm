class Solution {
    public String solution(String my_string) {
        String answer = "";
        int idx = my_string.length()-1;
        while(idx >= 0){
            answer+=my_string.charAt(idx--);
        }
        return answer;
    }
}