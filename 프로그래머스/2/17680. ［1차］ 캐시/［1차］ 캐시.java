import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        int n = cities.length;
        List<String> w = new ArrayList<>();
        for(int i = 0; i<n; i++){
            String word = cities[i].toLowerCase();
            if(w.contains(word)){
                w.remove(word);
                w.add(word);
                answer++;
            }else{
                answer+=5;
                w.add(word);
                if(w.size() > cacheSize){
                    w.remove(0);
                }
            }
        }
    
        return answer;
    }
}