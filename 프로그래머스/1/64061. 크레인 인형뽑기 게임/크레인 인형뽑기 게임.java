import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int n = board.length;
        int count = moves.length;
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i<count; i++){
            int next = moves[i] - 1; 
            
            for(int j = 0; j<n; j++){
                if(board[j][next] > 0){
                    list.add(board[j][next]);
                    board[j][next] = 0;
                    break;
                }
            }
            if(list.size()>1){
                for (int k = 0; k<list.size()-1; k++){
                    if(list.get(k) == list.get(k+1)){
                        list.subList(k,k+2).clear();
                        answer+=2;
                    }
                }
            }
            
        }
        // System.out.println(list);
        
        return answer;
    }
}