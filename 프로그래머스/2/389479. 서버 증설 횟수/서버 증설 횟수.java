import java.util.*;
//m명 늘어날 때 마다 서버 1대 추가
//m명 미만 서버 x
//n*m명 이상 (n+1)*m 미만이라면 n대의 서버 운영
//k시간 동안 운영
//만료된 서버는 제거해주고, 몇대를 서버 증설해야할지 구현
class Solution {
    public int solution(int[] players, int m, int k) {
        
        int answer = 0;
        int n = 24;
        //시간을 집어 넣을 큐 
        Queue<Integer> time = new ArrayDeque<>();
        
        for(int i = 0; i<n; i++){
            // 서버 시간이 만료되면 제거해주기 위한 iterator
            Iterator<Integer> iter = time.iterator();
            while (iter.hasNext()) {
                int val = iter.next();
                if (val == i) {
                    iter.remove(); 
                }
            }
            
            // 몇대의 서버가 필요한지 인원.
            int server = players[i] / m ;
            
            
            //현재 서버 갯수
            int serverSize = time.size();
            
            
            //실질적으로 추가해야 할 서버 사이즈
            //음수면 없다고 가정, 양수면 있음.
            int needSize = server - serverSize;
            
            //서버 추가.
            for(int j = 0; j<needSize; j++){
                //끝나는 시간
                time.offer(i+k);
                //서버 한대 추가
                answer++;
            }
            System.out.println(time+" "+answer);
            
        }
        
        return answer;
    }
    
    
}