// 실패율은 다음과 같이 정의한다.
// 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
import java.util.*;
class Solution {
    public  List<Integer> solution(int N, int[] stages) {
        List<Integer> rank = new ArrayList<>();
        boolean[] visited = new boolean[N];
        int n = stages.length;
        int m = n; 
        List<Double> list1 = new ArrayList<>();
        List<Double> list2 = new ArrayList<>();
        
        for(int i = 1; i<=N; i++){
            int count = 0 ;
            for(int j = 0; j<n; j++){
                if(stages[j] == i){
                    count++;
                }
            }
            if(m>0){
                list1.add((double)count/m);
                list2.add((double)count/m);
                m-=count;
            }else{
                list1.add(0.0);
                list2.add(0.0);
            }
            
        }
        
        
        System.out.println(list1);
        System.out.println(list2);
        Collections.sort(list1);
        Collections.reverse(list1);

        
        for(int i = 0; i<N; i++){
            for(int j = 0 ; j<N; j++){
                if (Double.compare(list1.get(i), list2.get(j)) == 0){
                    if(!visited[j]){
                        visited[j] =true;
                        rank.add(j+1);
                    }
                }
            }
        }
        return rank;
    }
}