import java.util.*;
class Solution {
    static int win_total = 0;
    static int max_score = 0;
    static int[] apeach;
    static int[] rion;
    static int[] answer = new int[11];
    public int[] solution(int n, int[] info) {
        rion = new int[11];
        dfs(0,n,info);
        if(win_total == 0){
            return new int[]{-1};
        }
        return answer;
    }
    static void dfs(int idx, int n, int[] info){
        if(idx == 10){
            if(n > 0){
                rion[10] = n;
            }
            int rionScore = 0;
            int peachScore = 0;
            for(int i = 0; i<11; i++){
                // System.out.print(rion[i]+" ");
                if(rion[i] == 0 && info[i] == 0) continue;
                if(rion[i] > info[i]) {
                    rionScore+=(10-i);
                }else{
                    peachScore+=(10-i);
                }
            }
            // System.out.print(rionScore+" "+peachScore);
            // System.out.println();
            int win_score = rionScore - peachScore;
            if(win_score > max_score){
                max_score = win_score;
                win_total++;
                for(int i = 0; i<11; i++){
                    answer[i] = rion[i];
                }
            }else if(win_score == max_score){
                max_score = win_score;
                boolean change = false;
                for(int i = 10; i>=0; i--){
                    if(answer[i] < rion[i] ){
                        change = true;
                        break;
                    }else if(answer[i] > rion[i]){
                        break;
                    }
                }
                if(change){
                    for(int i = 0; i<11; i++){
                        answer[i] = rion[i];
                    }
                }
            }
            if(n > 0){
                rion[10]-=n;
            }
            
            return;
        }
        
        if(info[idx] < n){
            rion[idx] = info[idx] + 1;
            dfs(idx+1,n - (info[idx]+1),info);
            rion[idx] = 0;
        }
        
        dfs(idx+1,n,info);
    }
    
}