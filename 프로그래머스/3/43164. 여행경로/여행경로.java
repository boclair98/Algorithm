import java.util.*;
class Solution {
    static List<String> list = new ArrayList<>();
    static boolean[] visited;
    static void dfs(String start, String path, String[][] tickets ,int count){
        if(count == tickets.length){
            list.add(path);
            return;
        }
        for(int i = 0; i < tickets.length; i++){
            if(!visited[i] && tickets[i][0].equals(start)){
                visited[i] = true;
                dfs(tickets[i][1],path+","+tickets[i][1] ,tickets,count+1);
                visited[i] = false;
            }
        }
    }
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        visited = new boolean[tickets.length];
        dfs("ICN","ICN",tickets,0);
        Collections.sort(list);
        //System.out.println(list);
        return list.get(0).split(",");
    }
}