import java.util.*;
import java.lang.*;

class Solution {
    public List<Integer> solution(String[] park, String[] routes) {
        List<Integer> answer = new ArrayList<>();
        int n = park.length;
        int m = park[0].length();
        int x = -1;
        int y = -1;
        int[] dy ={1,0,-1,0};
        int[] dx ={0,1,0,-1};
        Character [][] map = new Character[n][m];
        for(int i = 0; i<n; i++){
            String w = park[i];
            for(int j = 0; j<m; j++){
                map[i][j] = w.charAt(j);
                if(map[i][j] =='S'){
                    x = i;
                    y = j;
                }
            }
        }
        System.out.println(x+" "+y);
        int x1 = x;
        int y1 = y;
        
        for(int i = 0 ; i<routes.length; i++){
            String[] next = routes[i].split(" ");
            int direct = -1;
            if(next[0].equals("E")){
                direct = 0;
            }else if(next[0].equals("S")){
                direct = 1;
            }else if(next[0].equals("W")){
                direct = 2;
            }else if(next[0].equals("N")){
                direct = 3;
            }
            
            boolean vaild = true;
            int nx = x1;
            int ny = y1;
            for(int k = 0; k<Integer.parseInt(next[1]); k++){
                nx+=dx[direct];
                ny+=dy[direct];
                if(0 > nx || nx >= n || ny >= m || 0 > ny || map[nx][ny] =='X'){
                    vaild = false;
                    continue;
                }
                
            }
            if(vaild){
                x1 = nx;
                y1 = ny;
            }

            // System.out.println(x1+" "+y1);
        }
        answer.add(x1);
        answer.add(y1);
       
        return answer;
    }
}