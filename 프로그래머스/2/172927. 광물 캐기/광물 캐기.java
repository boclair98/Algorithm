import java.util.*;
class Solution {
    static int min = Integer.MAX_VALUE;
    public int solution(int[] picks, String[] minerals) {
        int answer = 0; 
        int count = picks[0] + picks[1] + picks[2];
        dfs(0,picks,minerals,0,count);
        return min;
    }
    static void dfs(int idx, int[] picks, String[] minerals, int total,int count){
        if(idx >= minerals.length || count == 0 ){
            min = Math.min(min,total);
            return;
        }
        for(int i = 0; i<3; i++){
            if(picks[i] > 0 ){
                int piro = 0;
                for(int j = idx; j < idx + 5 && j < minerals.length; j++){
                    String mineral = minerals[j];
                    if(i == 0){
                        piro+=1;
                    }else if(i == 1){
                        if(mineral.equals("diamond")){
                            piro+=5;
                        }else{
                            piro+=1;
                        }
                    }else{
                        if(mineral.equals("diamond")){
                            piro+=25;
                        }else if(mineral.equals("iron")){
                            piro+=5;
                        }else{
                            piro+=1;
                        }
                    }
                }
                picks[i]--;
                dfs(idx+5,picks,minerals,total+piro,count-1);
                picks[i]++;
            }
        }
    }
}