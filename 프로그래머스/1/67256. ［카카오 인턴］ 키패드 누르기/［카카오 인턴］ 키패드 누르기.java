import java.lang.*;
class Solution {
    public String solution(int[] numbers, String hand) {
        String[][] number = {
            {"1","2","3"},
            {"4","5","6"},
            {"7","8","9"},
            {"*","0","#"}
        };
        StringBuilder sb = new StringBuilder();
        int left = -1;
        int lx = 3;
        int ly = 0;
        int right = -1;
        int rx = 3;
        int ry = 2;
        
        for(int i = 0; i<numbers.length; i++){
            int num = numbers[i];
            //System.out.println(lx+" "+ly);
            //System.out.println(rx+" "+ry);
            if(num == 1 || num == 4 || num == 7){
                sb.append("L");
                if(num == 1){
                    lx = 0;
                    ly = 0;
                }else if(num == 4){
                    lx = 1;
                    ly = 0;
                }else if(num == 7){
                    lx = 2;
                    ly = 0;
                }
            }else if(num == 3 || num == 6 || num == 9){
                sb.append("R");
                if(num == 3){
                    rx = 0;
                    ry = 2;
                }else if(num == 6){
                    rx = 1;
                    ry = 2;
                }else if(num == 9){
                    rx = 2;
                    ry = 2;
                }
            }else{
                if(num == 2){
                    int distace1 = Math.abs(rx-0) + Math.abs(ry-1);
                    int distace2 = Math.abs(lx-0) + Math.abs(ly-1);
                    if(distace1 > distace2){
                        sb.append("L");
                        lx = 0;
                        ly = 1;
                    }else if (distace1 < distace2){
                        sb.append("R");
                        rx = 0;
                        ry = 1;
                    }else{
                        if(hand.equals("right")){
                            sb.append("R");
                            rx = 0;
                            ry = 1;
                        }else{
                            sb.append("L");
                            lx = 0;
                            ly = 1;
                        }
                    }
                }
                if(num == 5){
                    int distace1 = Math.abs(rx-1) + Math.abs(ry-1);
                    int distace2 = Math.abs(lx-1) + Math.abs(ly-1);
                    if(distace1 > distace2){
                        sb.append("L");
                        lx = 1;
                        ly = 1;
                    }else if (distace1 < distace2){
                        sb.append("R");
                        rx = 1;
                        ry = 1;
                    }else{
                        if(hand.equals("right")){
                            sb.append("R");
                            rx = 1;
                            ry = 1;
                        }else{
                            sb.append("L");
                            lx = 1;
                            ly = 1;
                        }
                    }
                }
                if(num == 8){
                    int distace1 = Math.abs(rx-2) + Math.abs(ry-1);
                    int distace2 = Math.abs(lx-2) + Math.abs(ly-1);
                    if(distace1 > distace2){
                        sb.append("L");
                        lx = 2;
                        ly = 1;
                    }else if (distace1 < distace2){
                        sb.append("R");
                        rx = 2;
                        ry = 1;
                    }else{
                        if(hand.equals("right")){
                            sb.append("R");
                            rx = 2;
                            ry = 1;
                        }else{
                            sb.append("L");
                            lx = 2;
                            ly = 1;
                        }
                    }
                }
                if(num == 0){
                    int distace1 = Math.abs(rx-3) + Math.abs(ry-1);
                    int distace2 = Math.abs(lx-3) + Math.abs(ly-1);
                    if(distace1 > distace2){
                        sb.append("L");
                        lx = 3;
                        ly = 1;
                    }else if (distace1 < distace2){
                        sb.append("R");
                        rx = 3;
                        ry = 1;
                    }else{
                        if(hand.equals("right")){
                            sb.append("R");
                            rx = 3;
                            ry = 1;
                        }else{
                            sb.append("L");
                            lx = 3;
                            ly = 1;
                        }
                    }
                }
            }
            //System.out.println(lx+" "+ly);
            //System.out.println(rx+" "+ry);
            //System.out.println("=======================");
           
        }
        return sb.toString();
    }
}