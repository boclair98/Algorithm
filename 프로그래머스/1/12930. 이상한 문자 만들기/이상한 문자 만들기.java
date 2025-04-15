class Solution {
    public String solution(String s) {
        String answer = "";
        String[] word = s.split(" ",-1);
        for(int i = 0; i<word.length; i++){
            String words = word[i];
            for(int j = 0; j<words.length(); j++){
                if(j % 2 == 0){
                    answer+=String.valueOf(Character.toUpperCase(words.charAt(j)));
                }else{
                    answer+=String.valueOf(Character.toLowerCase(words.charAt(j)));
                }
            }
            if(i<word.length-1){
                answer+=" ";
            }
        }
        
        return answer;
    }
}