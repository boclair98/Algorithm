import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        // for(int i = 0; i<phone_book.length; i++){
        //     System.out.println(phone_book[i]);
        // }
        
        for(int i = 0; i<phone_book.length-1; i++){
            int first = phone_book[i].length();
            int second = phone_book[i+1].length();
            if(first < second){
                if(phone_book[i].equals(phone_book[i+1].substring(0,first))){
                    return false;
                }
            }
        }
    
        return answer;
    }
}