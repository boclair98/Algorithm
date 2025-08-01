import java.util.*;
class Solution {
    static boolean[] visited;
    static int min_value =Integer.MAX_VALUE;
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        visited = new boolean[words.length];
        DFS(0, begin,target,words,0);
        if(min_value == Integer.MAX_VALUE ) return 0;
        return min_value;
    }
    public static void DFS(int index, String begin, String target,String[] words,int count){
        if(begin.equals(target)){
            min_value = Math.min(min_value,count);
            return;
        }
        for(int i = 0; i<words.length; i++){
            if(!visited[i]){
                visited[i] = true;
                if(check(begin,words[i])){
                    DFS(i+1,words[i],target,words,count+1);                    
                }
                visited[i] = false;
            }
        }
    }
    public static boolean check(String word1, String word2){
        int count = 0;
        for(int i = 0; i<word1.length(); i++){
            if(word1.charAt(i)!=word2.charAt(i)){
                count++;
            }
        }
        if(count == 1) return true;
        return false;
    }
}