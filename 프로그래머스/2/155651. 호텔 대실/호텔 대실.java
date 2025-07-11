import java.util.*;
//호텔 끝나는 시간과 들어가는 시간을 비교 후 방을 추가할지 갱신할지 

class Solution {
    public int solution(String[][] book_time) {
        int room = 0;
        Arrays.sort(book_time,(a,b) -> a[0].compareTo(b[0]));
        
        //시간 저장
        List<Integer> time = new ArrayList<>();
        
       
        //우선 기존의 머무는 사람들과 비교한다.
        //끝나는 시간의 방이 있다면 갱신한다.
        // 없다면 방을 추가한다.(room)
        //i가0 즉 처음 인사람은 무조건 입장 , 방 추가
        for(int i = 0; i<book_time.length; i++){
            String[] num = book_time[i];
            int start = time_change(num[0]);
            int finish = time_change(num[1])+10;
            
            
            boolean check = false;
            for(int j = 0; j<time.size(); j++){
                int end = time.get(j);
                if(start >= end){
                    check = true;
                    //방 시간 갱신.
                    time.set(j,finish);  
                    break; 
                }
            }
                
            if(!check){
                time.add(finish);
                room++;
                }
            }
      
        return room;
    }
    
    //끝나는 시간을 int형으로 변환.(비교 용이)
    public static int time_change(String t){
        String[] num = t.split(":");
        return Integer.parseInt(num[0]) * 60 + Integer.parseInt(num[1]);
    }
}