import java.util.*;
class Solution {
    public int solution(String dartResult) {
        ArrayList<Integer> list = new ArrayList<>();
        int answer = 0;
        int n = dartResult.length();
        String dart = "";
        for(int i = 0; i<n; i++){
            // System.out.println(dart);
            char word = dartResult.charAt(i);
            if(word == 'D'){
                list.add(Integer.parseInt(dart));
                int num = list.remove(list.size()-1);
                int num2 = (int) Math.pow(num,2);
                list.add(num2);
                dart ="";
            }else if(word =='T'){
                list.add(Integer.parseInt(dart));
                int num = list.remove(list.size()-1);
                int num2 = (int) Math.pow(num,3);
                list.add(num2);
                dart ="";
            }else if(word =='S'){
                list.add(Integer.parseInt(dart));
                dart ="";
            }else if(word =='*'){
                if(list.size() == 1){
                    int num = list.remove(list.size()-1);
                    list.add(num * 2);
                }else{
                
                    for(int k = list.size()-2; k<list.size(); k++){
                        int num = list.remove(k);
                        // System.out.println(num);
                        list.add(k,num*2);
                    }
                }
                dart ="";
                // System.out.println(list);
            }else if(word =='#'){
                int num = list.remove(list.size()-1);
                int num2 = num * -1;
                list.add(num2);
                dart ="";
            }else{
                dart+=word;
            }
        }
        for(int num: list){
            answer+=num;
        }
        return answer;
    }
}