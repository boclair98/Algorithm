import java.util.*;
class Solution {
    static boolean[] visited;
    static List<String> airport = new ArrayList<>();
    static int n;
    public List<String> solution(String[][] tickets) {
        List<String> answer = new ArrayList<>();
        n = tickets.length;
        visited = new boolean[n];
        
        DFS(0,"ICN","ICN",tickets);
        Collections.sort(airport);
        // System.out.println(airport);
        String answers = airport.get(0);
        String[] word = answers.split(" ");
        for(int i = 0; i<word.length; i++){
            answer.add(word[i]);
        }    
        
        return answer;
    }
    public static void DFS(int idx, String start,String route, String[][] tickets){
        if(idx == n){
            airport.add(route);
            return;
        }
        for(int i = 0; i<n; i++){
            if(tickets[i][0].equals(start) && !visited[i]){
                visited[i] = true;
                
                DFS(idx+1,tickets[i][1],route+" "+tickets[i][1], tickets);
                visited[i] = false;
            }
        }
    }
    
}