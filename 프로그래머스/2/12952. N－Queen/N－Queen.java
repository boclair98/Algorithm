import java.util.*;
class Solution {
    static int[][] visited;
    static int answer;
    public int solution(int n) {
        answer = 0;
        visited = new int[n][n];
        back(0,n);
        return answer;
    }
    static void back(int depth,int n){
        if(depth == n){
            answer++;
            return;
        }
        for(int i = 0; i<n; i++){
            if(visited[depth][i]==0){
                change(depth,i,n,+1);
                back(depth+1,n);
                change(depth,i,n,-1);
            }
        }
    }
    static void change(int x, int y, int n,int value){
        for(int i = 0; i<n; i++){
            visited[i][y]+=value;
        }
        for(int i = 0; i<n; i++){
            if(i != x){
                visited[x][i]+=value;
            }
        }
        
        for(int i = 1; x+i<n && y+i<n; i++){
            visited[x+i][y+i]+=value;
        }
        
        for(int i = 1; x+i<n && y-i >=0; i++){
            visited[x+i][y-i]+=value;
        }
        
        for(int i = 1; x-i>=0 && y+i<n; i++){
            visited[x-i][y+i]+=value;
        }
        for(int i =1; x-i>=0 && y-i >=0; i++){
            visited[x-i][y-i]+=value;
        }
        
    }
    
    
    
    
}