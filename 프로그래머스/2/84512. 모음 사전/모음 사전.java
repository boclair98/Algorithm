import java.util.*;
class Solution {
    public int solution(String word) {
        int answer = 0;
        List<String> words = new ArrayList<>();
        String[] alpha = {"A","E","I","O","U"};
        String w ="";
        DFS(0,words,alpha,w);
        // System.out.println(words);
        for(int i =1; i<words.size(); i++){
            if(word.equals(words.get(i))){
                answer = i;
                break;
            }
        }
        return answer;
        
    }
    static void DFS(int idx, List<String> words, String[] alpha,String w){
        if(idx > 5){
            return;
        }
        for(int i = 0; i<5; i++){
            if(!words.contains(w)){
                words.add(w);
            }
            DFS(idx+1,words,alpha,w+alpha[i]);
        }
    }
}