import java.util.*;
class Solution {
    static boolean[] visited;
    static int answer = 0;
    public int solution(int n, int[][] computers) {       
        visited = new boolean[n+1];
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                dfs(n,i,computers);
                answer++;
            }
        }
        return answer;
    }
    static void dfs(int n, int depth,int[][] computers){
        visited[depth] = true;
        for(int i = 0; i < n; i++){
            if(computers[depth][i] == 1){
                if(!visited[i]){
                    dfs(n,i,computers);
                }
            }
        }
    }
}