import java.util.*;
class Solution {
    public List<Integer> solution(String s) {
        List<Integer> list = new ArrayList<>();
        s = s.substring(2,s.length()-2).replace("},{","-");
        String[] arr = s.split("-");
        Arrays.sort(arr, Comparator.comparingInt(a -> a.length()));
        // for(int i = 0; i<arr.length; i++){
        //     System.out.println(arr[i]);
        // }
        
        for(int i = 0; i<arr.length; i++){
            String[] num = arr[i].split(",");
            for(int j = 0; j<num.length; j++){
                int number = Integer.parseInt(num[j]);
                if(!list.contains(number)){
                    list.add(number);
                }
            }
        }
        return list;
    }
}