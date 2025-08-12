import java.util.*;
class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        List<List<Integer>> list = new ArrayList<>();
        int[] dist = new int[n+1];
        Arrays.fill(dist,-1);
        for(int i = 0 ; i<=n; i++){
            list.add(new ArrayList<>());
        }
        for(int i = 0; i<edge.length; i++){
            int start = edge[i][0];
            int end = edge[i][1];
            list.get(start).add(end);
            list.get(end).add(start);
        }
        dist[1] = 0;
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(1);
        while(!q.isEmpty()){
            int nums = q.poll();
            for(Integer number : list.get(nums)){
                if(dist[number] == -1){
                    dist[number] = dist[nums] + 1;
                    q.offer(number);
                }
            }
        }
        
        int max_val = 0;
        for(int number : dist){
            max_val = Math.max(max_val,number);
        }
        
        for(int i = 1; i<=n; i++){
            if(dist[i] == max_val) answer++;
        }
        return answer;
    }
    
}