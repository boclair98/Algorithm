import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        List<Integer> room = new ArrayList<>();
        int answer = 0;
        
        //정렬
        Arrays.sort(book_time, (o1, o2) -> {
            if (o1[0].equals(o2[0])) {
                return o1[1].compareTo(o2[1]);
            }
            return o1[0].compareTo(o2[0]);
        });
        
        for(int i = 0; i < book_time.length; i++){
            Collections.sort(room);
            String[] rook_check = book_time[i];
            int a = change(rook_check[0]);
            int b = change(rook_check[1]);
            if(room.size() == 0){
                room.add(b);
                answer++;
            }else{
                boolean check = false;
                for(int j = 0; j < room.size(); j++){
                    if(room.get(j) <= a ){
                        room.set(j,(b+10));
                        check = true;
                        break;
                    }
                }
                if(!check){
                    answer++;
                    room.add(b+10);
                }
            }
        }
        return answer;
    }
    static int change (String time){
        String[] a = time.split(":");
        return Integer.parseInt(a[0]) * 60 + Integer.parseInt(a[1]);
    }
}