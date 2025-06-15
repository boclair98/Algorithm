import java.util.*;
class Solution {
    public List<String> solution(String[] players, String[] callings) {
        String[] answer = {};
        int n = callings.length;
        //플레이어 
        List<String> player = new ArrayList<>(Arrays.asList(players));
        Map<String,Integer> rank = new HashMap<>();
        for(int i = 0; i<players.length; i++){
            rank.put(players[i],i+1);
        }
        // System.out.println(rank);
        
        for(String name:callings){
            int nowrank = rank.get(name);
            if(nowrank > 1 ){
                String names = player.get(nowrank-2);
                
                rank.put(names,nowrank);
                rank.put(name,nowrank-1);
                // System.out.println(rank);
                player.set(nowrank-2,name);
                player.set(nowrank-1,names);
            }
            
        }
        return player;
    }
}