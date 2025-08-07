class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
//         boolean[] visited = new boolean[n+1];
//         for(int i = 0; i<stations.length; i++){
//             int num = stations[i];
//             for(int j = num; j>=num - w && j>=0; j--){
//                 visited[j] = true;
//             }
//             for(int j = num+1; j<=num+w && j<=n; j++ ){
//                 visited[j] = true;
//             }
//         }
        
//         int idx = 1;
//         while(idx<=n){
//             if(!visited[idx]){
//                 idx+=(2*w+1);
//                 answer++;
//             }else{
//                 idx++;
//             }
           
//         }
        int idx = 1;
        int make = 2 * w + 1;
        for(int i = 0; i<stations.length; i++){
            int num = stations[i];
            int start = num - w;
            int end = num + w;
            
            if(idx < start){
                int dist = start - idx;
                answer+= (dist+ make -1 ) / make;
            }
            idx = end + 1;
            
        }
        
        if (idx <= n) {
            int dist = n - idx + 1;
            answer += (dist + make - 1) / make;
        }
        
        return answer;
    }
}