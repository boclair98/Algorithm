import java.util.*;
class Solution {
    static int[] dx ={1,0,-1,0};
    static int[] dy ={0,1,0,-1};
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        for(int i = 0; i<5; i++){
            String[] maps = places[i];
            char[][] map = new char[5][5];
            
            for(int j = 0; j<5; j++){
                for(int k = 0; k<5; k++){
                    map[j][k] = maps[j].charAt(k);
                }
            }
            boolean check = true;
            for(int j = 0; j<5; j++){
                for(int k = 0; k<5; k++){
                    if(map[j][k] =='P'){
                        if(j+1 < 5){
                            if(map[j+1][k] == 'P'){
                                check = false;
                            }
                        }
                        if(k+1 < 5){
                            if(map[j][k+1] == 'P'){
                                check = false;
                            }
                        }
                        if(j+2 < 5 ){
                            if(map[j+1][k] == 'O' && map[j+2][k] == 'P'){
                                check = false;
                            }
                        }
                        if(k+2<5){
                            if(map[j][k+1] == 'O' && map[j][k+2] == 'P'){
                                check = false;
                            }
                        }
                        
                        if(j+1 < 5 && k+1 < 5){
                            if(map[j+1][k] == 'O' && map[j+1][k+1] == 'P'){
                                check = false;
                            }
                            if(map[j][k+1] == 'O' && map[j+1][k+1] == 'P'){
                                check = false;
                            }
                        }
                        
                        if(j-1 >=0 && k+1 < 5){
                            if(map[j-1][k] == 'O' && map[j-1][k+1] == 'P'){
                                check = false;
                            }
                            if(map[j][k+1] == 'O' && map[j-1][k+1] == 'P'){
                                check = false;
                            }
                        }
                        if(j+1<5 && k-1 >=0){
                            if(map[j][k-1] == 'O' && map[j+1][k-1] == 'P'){
                                check = false;
                            }
                            if(map[j+1][k] == 'O' && map[j+1][k-1] == 'P' ){
                                check = false;
                            }
                        }
                    }
                }
            }
            if(!check){
                answer[i] = 0;
            }else{
                answer[i] = 1;
            }    
        }
        
        return answer;
    }  
}