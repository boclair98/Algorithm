import java.util.*;
class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        int[][] box = new int[100][w];
        int count = 1;
        int x = -1 ;
        int y = -1 ;
        createbox(count,n,box,w);

        for(int i = 0; i<100; i++){
            for(int j = 0; j<w; j++){
                if(box[i][j] == num){
                    x = i;
                    y = j;
                }
            }
        }
        
        for(int i = x; i<100; i++){
            if(box[i][y] == 0){
                break;
            }else{
                answer++;
            }
        }
        return answer;
    }
    
    //박스 생성
    static void createbox(int count,int n,int[][] box,int w){
        while (count<=n){
            for(int i = 0; i<100; i++){
                if(i%2 == 0){
                    for(int j = 0; j<w; j++){
                        box[i][j] = count++;
                        if(count > n){
                            return;
                        }
                    }
                }else{
                    for(int j = w-1; j>=0; j--){
                        box[i][j] = count++;
                        if(count > n){
                            return;
                        }
                    }
                }
            }
        }
    }
}