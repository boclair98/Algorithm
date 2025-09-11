class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int left = 1;
        int right = 100000;
        return binary(left,right,diffs,times,limit);
    }

    static int binary(int left, int right,int[] diffs, int[] times, long limit){
        while(left <= right){
            int mid = (right + left) / 2;
            long time = cal(diffs,times,mid);
            if(time <= limit){
                right = mid -1;
            } else if(time > limit){
                left = mid + 1;
            }
        }
        return left; 
    }

    static long cal(int[] diffs, int[] times,int mid){
        long total = 0;
        int prev = 0;
        for(int i = 0; i<diffs.length; i++){
            if(diffs[i] <= mid){
                total += times[i];
                prev = times[i];
            } else {
                int num = diffs[i] - mid;
                total += ((times[i] + prev) * num) + times[i];
                prev = times[i];
            }
        }
        return total;
    }
}
