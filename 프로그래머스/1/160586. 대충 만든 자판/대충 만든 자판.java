import java.util.*;
class Solution {
    public List<Integer> solution(String[] keymap, String[] targets) {
        List<Integer> list = new ArrayList<>();
        
        int n = keymap.length;
        int m = targets.length;
        
        //ABCD -> AABB 
        for(int i = 0; i<m; i++){
            String word = targets[i];
            int total = 0 ;
            boolean possible = true;
            for(int k = 0; k<word.length(); k++){
                char f = word.charAt(k);
                int min_val = Integer.MAX_VALUE;
                for(int j = 0; j<n; j++){
                    String key = keymap[j];
                    for(int y = 0; y<key.length(); y++){
                        if(f == key.charAt(y)){
                            min_val = Math.min(min_val,y+1);
                            break;
                        }
                    }
                }
                if(Integer.MAX_VALUE == min_val){
                    possible = false;
                    break;
                }
                total+=min_val;
            }
            if(possible){
                list.add(total);
            }else{
                list.add(-1);
            }
        }
    
        return list;
    }
}