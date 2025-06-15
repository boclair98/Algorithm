import java.util.*;
import java.io.*;
class Solution {
    public List<Integer> solution(String today, String[] terms, String[] privacies) throws IOException {
        //today 숫자 배열로 만들어줌.
        String answer ="";
        List<Integer> list = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        int[] todays = new int[3];
        int idx = 0 ;
        for(int i = 0; i<today.length(); i++){
            char word = today.charAt(i);
            if(word == '.'){
                todays[idx] = Integer.parseInt(answer);
                idx++;
                answer = "";
            }else{
                answer+=word;
            }
        }
        todays[idx] = Integer.parseInt(answer);
        
        //달력 map에 저장
        for(int i = 1; i<=12; i++){
            map.put(i,28);
        }
        
        //로직 작성 
        int count = 0 ;
        for(int i = 0; i<privacies.length; i++){
            String[] date = privacies[i].split(" ");
            String alpha = date[1];
            count = 0 ;
            for(int j = 0; j<terms.length; j++){
                String[] term = terms[j].split(" ");
                if(term[0].equals(alpha)){
                    count = Integer.parseInt(term[1]) * 28;
                    int[] day = new int[3];
                    String date1 = date[0];
                    String num ="";
                    int idx1 = 0 ;
                    for(int k = 0; k<date1.length(); k++){
                        if(date1.charAt(k) =='.'){
                            day[idx1] = Integer.parseInt(num);
                            num ="";
                            idx1++;
                        }else{
                            num+=date1.charAt(k);
                        }
                    }
                    day[idx1] = Integer.parseInt(num);
                    // for(Integer m:day){
                    //     System.out.print(m+" ");
                    // }
                    System.out.println();
                    while (count > 0 ){
                        day[2] ++ ;
                        if(map.get(day[1]) < day[2]){
                            day[1] ++;
                            day[2] = 1;
                            if(day[1]>12){
                                day[1] = 1;
                                day[0]++;
                            }
                        }
                        count--;
                    }
                    for(int s = 0 ; s<3; s++){
                        System.out.print(day[s]+" ");
                    }
                    System.out.println();
                    
                    if(day[0] < todays[0]){
                        list.add(i+1);
                    }
                    if(day[0] == todays[0]){
                        if(day[1] < todays[1]){
                            list.add(i+1);
                        }
                    }
                    if(day[0] == todays[0]){
                        if(day[1] == todays[1]){
                            if(day[2] < todays[2]){
                                list.add(i+1);
                            }
                        }
                    }
                    if(day[0] == todays[0] && day[1] == todays[1] && day[2] == todays[2]){
                        list.add(i+1);
                    }
                    
                }
            }
        }
        return list;
    }
}