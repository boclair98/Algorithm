//진열된 모든 종류의 보석을 적어도 1개 이상 포함하는 가장 짧은 구간을 찾아서 구매
import java.util.*;
class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        int n = gems.length;
        List<int[]> list = new ArrayList<>();
        //set에 gems을 담아둠.
        Set<String> set = new HashSet<>(Arrays.asList(gems));
        
        //투포인터 
        int left = 0;
        int right = 0;
        Map<String,Integer> map = new HashMap<>();
        while(right < n){
            map.put(gems[right],map.getOrDefault(gems[right],0)+1);
            right++;
            while(map.size() == set.size()){
                list.add(new int[]{left,right});
                map.put(gems[left],map.get(gems[left]) - 1);
                if(map.get(gems[left]) == 0){
                    map.remove(gems[left]);
                }
                left++;
            }
        }
        list.sort((o1,o2) -> {
            int len1 = o1[1] - o1[0];
            int len2 = o2[1] - o2[0];
            if(len1 != len2) return Integer.compare(len1,len2);
            else return Integer.compare(o1[0],o2[0]);
        });
        
        answer[0] = list.get(0)[0] + 1;
        answer[1] = list.get(0)[1];
        return answer;
    }
    

}