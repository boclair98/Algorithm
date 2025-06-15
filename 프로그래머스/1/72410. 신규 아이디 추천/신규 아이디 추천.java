class Solution {
    public String solution(String new_id) {
        //1
        String answer = new_id.toLowerCase();
        
        // 2
        String answer2 ="";
        for(int i = 0; i<answer.length(); i++){
            char word = answer.charAt(i);
            if(word>='a' && word<='z'){
                answer2+=word;
            }else if(word>='0' && word<='9'){
                answer2+=word;
            }else if(word =='-' || word == '_' || word =='.'){
                answer2+=word;
            }
        }
        //3
        String answer3 ="";
        int idx = 0 ;
        while (answer2.contains("..")){
            answer2 = answer2.replace("..",".");
        }
        
        //4
        if(answer2.length() > 0){
            if(answer2.charAt(0) == '.'){
                answer2 = answer2.substring(1,answer2.length());
            }
        }
        if(answer2.length() > 0){
            if(answer2.charAt(answer2.length()-1) == '.'){
                answer2 = answer2.substring(0,answer2.length()-1);
            }
        }
        
        //5
        if(answer2.length() == 0){
            answer2+="a";
        }
        //6
        if(answer2.length() > 15){
            answer2 = answer2.substring(0,15);
            if(answer2.charAt(14) == '.'){
                answer2 = answer2.substring(0,14);
            }
        }
        
        //7
        if(answer2.length()<3){
            while (answer2.length()<3){
                answer2+=answer2.charAt(answer2.length()-1);
            }
        }
        return answer2;
    }
}