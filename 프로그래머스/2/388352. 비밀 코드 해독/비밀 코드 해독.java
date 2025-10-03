import java.util.*;
class Solution {
    static boolean[] visited;
    static List<Integer> list = new ArrayList<>();
    static int answer = 0;
    public int solution(int n, int[][] q, int[] ans) {
        visited = new boolean[n+1];
        dfs(0,ans,q,n,1);
        return answer;
    }
    
    static void dfs(int idx,int[] ans,int[][] q, int n,int start){
        if(idx == 5){
            int succes = 0;
            for(int i = 0; i<q.length; i++){
                int cnt = 0;
                for(int j = 0; j<5; j++){
                    if(list.contains(q[i][j])){
                        cnt++;
                    }
                }
                if(cnt == ans[i]){
                    succes++;
                }
            }
            if(succes == q.length){
                answer++;
            }
            return;
        }
        
        for(int i = start; i<=n; i++){
            if(!visited[i]){
                visited[i] = true;
                list.add(i);
                dfs(idx+1,ans,q,n,i+1);
                list.remove(list.size()-1);
                visited[i] = false;
            }
        }
    }
}