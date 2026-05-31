import java.util.*;
class Solution {
    static boolean[] visited;
    static int n, answer;
    public int solution(int k, int[][] dungeons) {
        answer = 0;
        n = dungeons.length;
        visited = new boolean[n];
        backTracking(k,0,dungeons);
        return answer;
    }
    static void backTracking(int nowK,int cnt,int[][] dungeons){
        answer = Math.max(answer, cnt);
        if(cnt == n) return;
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                if(dungeons[i][0]<=nowK){
                    visited[i] = true;
                    backTracking(nowK-dungeons[i][1],cnt+1,dungeons);
                    visited[i] = false;
                }
            }
        }
    }
}