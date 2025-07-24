import java.util.*;
class Solution {
    static int min = Integer.MAX_VALUE;
    public int solution(int[] picks, String[] minerals) {
        int answer = 0; 
        //횟수 
        int count = picks[0] + picks[1] + picks[2];
        //백트래킹 적용.
        dfs(0,picks,minerals,0,count);
        return min;
    }
    // 더이상 캘 미네랄이 없거나 곡괭이가 없으면 return;
    static void dfs(int idx, int[] picks, String[] minerals, int total,int count){
        if(idx >= minerals.length || count == 0 ){
            min = Math.min(min,total);
            return;
        }
        
        for(int i = 0; i<3; i++){
            if(picks[i] > 0 ){
                int piro = 0;
                //idx부터 5번 미네랄 다 캘수 있을 때 까지.
                for(int j = idx; j < idx + 5; j++){
                    if( j < minerals.length){
                        String mineral = minerals[j];
                        //i = 0 다이아몬드
                        if(i == 0){
                            piro+=1;
                            //i = 1 철
                        }else if(i == 1){
                            if(mineral.equals("diamond")){
                                piro+=5;
                            }else{
                                piro+=1;
                            }
                            // 돌.
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
                }
                picks[i]--;
                dfs(idx+5,picks,minerals,total+piro,count-1);
                picks[i]++;
            }
        }
    }
}