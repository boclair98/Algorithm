class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        int max_number = -1;
        for(int i = 0; i<arr.length; i++){
            max_number = Math.max(max_number,arr[i]);
        }
        int number = max_number;
        System.out.println(max_number);
        boolean check = false;
        while (true){
            if(check){
                break;
            }
            for (int i = 0; i<arr.length; i++){
                if(max_number % arr[i] != 0){
                    check = false;
                    max_number+=number;
                    break;
                }else{
                    check = true;
                }
            }
        }
        return max_number;
    }
}