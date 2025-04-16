import java.util.*;
class Solution {
    public List<Integer> solution(int[] answers) {
        List<Integer> list = new ArrayList<>();
        int max_val = 0 ;
        int max_val2 = 0;
        int max_val3 = 0;
        int n = answers.length;
        int[] s1 = {1,2,3,4,5};
        int[] s2 = {2,1,2,3,2,4,2,5};
        int[] s3 = {3,3,1,1,2,2,4,4,5,5};
        int s1n = s1.length;
        int s2n = s2.length;
        int s3n = s3.length;
        int score1 = 0;
        int score2 = 0;
        int score3 = 0;
        for(int i =0; i<n; i++){
            if(answers[i] == s1[i%s1n] ){
                score1++;
            }
            if(answers[i] == s2[i%s2n]){
                score2++;
            }
            if(answers[i] == s3[i%s3n]){
                score3++;
            }
        }
        max_val = Math.max(max_val,score1);
        max_val2 = Math.max(max_val,score2);
        max_val3 = Math.max(max_val2,score3);
        if(score1 == max_val3){
            list.add(1);
        }
        if(score2 == max_val3){
            list.add(2);
        }
        if(score3 == max_val3){
            list.add(3);
        }
        return list;
    }
}