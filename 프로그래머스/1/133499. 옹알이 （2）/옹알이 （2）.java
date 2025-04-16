class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] word ={"aya","ye","woo","ma"};
        for(String w : babbling){
    
            String prev ="";
            boolean vaild = true;
            
            while (!w.isEmpty()){
                boolean found = false;    
                for(String wod : word){
                    if(w.startsWith(wod)){
                        if(wod.equals(prev)){
                            vaild = false;
                            break;
                        }
                        
                        w = w.substring(wod.length());
                        prev = wod;
                        found = true;
                        break;
                    }
                }
                if(!found){
                    vaild = false;
                    break;
                }
            
            }
            if(vaild){
                answer++;
            }
        }
        return answer;
    }
}