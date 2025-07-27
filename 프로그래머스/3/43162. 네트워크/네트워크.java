import java.util.*;
class Solution {
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n+1];
        
        
        for(int i = 0; i<n; i++){
            if(!visited[i]){
                answer++;
                dfs(i,computers,n);
                
            }
        }
        
        return answer;
    }
    public static void dfs(int idx, int[][] computers, int n){
        visited[idx] = true;
        for(int i = 0; i<n; i++){
            if(!visited[i]){
                if(computers[idx][i] == 1){
                    dfs(i,computers,n);
                }
            }
        }
        
    }
    
}