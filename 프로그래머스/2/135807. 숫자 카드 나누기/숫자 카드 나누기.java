import java.util.*;
class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int n = arrayA.length;
        int gcdA = arrayA[0];
        for (int i = 1; i < arrayA.length; i++) {
            gcdA = gcd(gcdA, arrayA[i]);
        }
        int gcdB = arrayB[0];
        for (int i = 1; i < arrayB.length; i++) {
            gcdB = gcd(gcdB, arrayB[i]);
        }
        
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        int count4 = 0;
        int count5 = 0;
        int count6 = 0;
        int count7 = 0;
        int count8 = 0;
        for(int i = 0; i<n; i++){
            if(arrayA[i]%gcdA > 0){
                count1++;
            }else if(arrayA[i]%gcdA == 0){
                count2++;
            }
        }
        for(int i = 0; i<n; i++){
            if(arrayB[i]%gcdA > 0){
                count3++;
            }else if(arrayB[i]%gcdA == 0){
                count4++;
            }
        }
        
        for(int i = 0; i<n; i++){
            if(arrayA[i]%gcdB > 0){
                count5++;
            }else if(arrayA[i]%gcdB == 0){
                count6++;
            }
        }
        for(int i = 0; i<n; i++){
            if(arrayB[i]%gcdB > 0){
                count7++;
            }else if(arrayB[i]%gcdB == 0){
                count8++;
            }
        }
        // System.out.println(count1+" "+count2+" "+count3+" "+count4);
        // System.out.println(count5+" "+count6+" "+count7+" "+count8);
        int maxnum = 0;
        if(count1 == n && count2 == 0 && count3 == 0 && count4 == n){
            maxnum = Math.max(maxnum,gcdA);
        } else if(count1 == 0 && count2 == n && count3 == n && count4 == 0){
            maxnum = Math.max(maxnum,gcdA);
        }
        
        if(count5 == n && count6 == 0 && count7 == 0 && count8 == n){
            maxnum = Math.max(maxnum,gcdB);
        } else if(count5 == 0 && count6 == n && count7 == n && count8 == 0){
            maxnum = Math.max(maxnum,gcdB);
        }
        
        return maxnum;
    }
    
    //최소 공배수 활용
    private int gcd(int a, int b){
        while(b!=0){
            int div = a % b;
            a = b;
            b = div;
        }
        return a;
    }
}