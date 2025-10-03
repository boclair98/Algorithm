import java.util.*;

class Solution {
    static int[] discount = new int[]{40,30,20,10};
    static List<Integer> list = new ArrayList<>();
    static boolean[] visited;
    static int max_human = 0;
    static int max_price = 0;
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];
        visited = new boolean[emoticons.length];
        dfs(0,emoticons,users);
        answer[0] = max_human;
        answer[1] = max_price;
        return answer;
    }
    static void dfs(int idx, int[] emoticons, int[][] users){
        if(idx == emoticons.length){
            // System.out.println(list);
            int human = 0;
            int total = 0;
            for(int i = 0; i<users.length; i++){
                int dis = users[i][0];
                int price = users[i][1];
                int total_price = 0;
                for(int j = 0; j<list.size(); j++){
                    if(dis <= list.get(j)){
                        total_price += emoticons[j] * (100 - list.get(j)) / 100;           
                    }
                }
                
                if(total_price >= price){
                    human++;
                }else{
                    total+=total_price;
                }
            }
            if(human > max_human){
                max_human = human;
                max_price = total;
            }else if(human == max_human){
                max_price = Math.max(max_price, total);
            }
            return;
        }
        for(int i = 0; i<4; i++){
        
            list.add(discount[i]);
            dfs(idx+1,emoticons,users);
            list.remove(list.size()-1);

        }
        
    }
}