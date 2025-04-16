class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int n = nums.length;
        for(int i = 0; i<n; i++){
            for(int j = i+1; j<n; j++){
                for(int k = j+1; k<n; k++){
                    int num = nums[i] + nums[j] + nums[k];
                    int count = 0 ;
                    for(int z = 1; z<=num; z++){
                        if(num % z == 0){
                            count++;
                        }
                    }
                    if(count == 2){
                        answer++;
                    }
                    
                }
            }
        }
        return answer;
    }
}