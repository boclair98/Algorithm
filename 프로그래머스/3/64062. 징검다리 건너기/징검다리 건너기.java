class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int start = 1;
        int end = 0;
        for(Integer num : stones){
            if(num > end) {
                end = num;
            }
        }
        // System.out.println(end);
        while(start<=end){
            int mid = (start+end) / 2;
            if(next(stones,mid,k)){
                answer = mid;
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        
        return answer;
    }
    public static boolean next(int[] stones,int mid, int k){
        int count = 0;
        for(int i = 0; i<stones.length; i++){
            if(stones[i] - mid < 0 ) count++;
            else count = 0;
            if(count >= k) return false;
        }
        return true;
    }
}