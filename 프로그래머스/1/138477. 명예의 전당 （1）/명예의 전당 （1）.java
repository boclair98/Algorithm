import java.util.*;
class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        int idx = 0;
        List<Integer> list = new ArrayList<>();
        int n = score.length;
        for(int i = 0; i<n; i++){
            list.add(score[i]);
            Collections.sort(list);
            if(list.size()<=k){
                answer[i] = list.get(0); 
            }else{
                list.remove(0);
                answer[i] = list.get(0);
            }
        }
        return answer;
    }
}