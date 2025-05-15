import java.util.*;
class Solution {
    public int solution(String dirs) {
        Set<String> set = new HashSet<>();
        int answer = 0;
        int x = 0 ;
        int y = 0 ;
        for(int i = 0; i<dirs.length(); i++){
            char d = dirs.charAt(i);
            // System.out.println(d);
            int nx = -1;
            int ny = -1;
            if(d == 'L'){
                 nx = x;
                 ny = y - 1;
            }
            if(d == 'R'){
                nx = x;
                ny = y + 1;
            }
            if(d == 'U'){
                nx = x -1;
                ny = y;
            }
            if(d=='D'){
                nx = x + 1;
                ny = y;
            }
            
            if (nx < -5 || nx > 5 || ny < -5 || ny > 5) continue;
            String first = x+" "+y+" "+nx+" "+ny;
            String second = nx+" "+ny+" "+x+" "+y;
            if(!set.contains(first) && !set.contains(second)){
                set.add(first);
                set.add(second);
                answer++;
            }
            x = nx;
            y = ny;
        }
        return answer;
    }
}