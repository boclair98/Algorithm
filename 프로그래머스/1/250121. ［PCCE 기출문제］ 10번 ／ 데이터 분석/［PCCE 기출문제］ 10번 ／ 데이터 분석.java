import java.util.*;
class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int n = data.length;
        int[][] answer = new int[n][4];
        int idx = 0 ;
        for(int i = 0; i<n; i++){
            int code = data[i][0];
            int date = data[i][1];
            int maximum = data[i][2];
            int remain = data[i][3];
            if(ext.equals("code")){
                if(val_ext>code){
                    answer[idx][0] = code;
                    answer[idx][1] = date;
                    answer[idx][2] = maximum;
                    answer[idx][3] = remain;
                    idx++;
                }
            }else if(ext.equals("date")){
                if(val_ext>date){
                    answer[idx][0] = code;
                    answer[idx][1] = date;
                    answer[idx][2] = maximum;
                    answer[idx][3] = remain;
                    idx++;
                }
            }else if(ext.equals("maximum")){
                if(val_ext>maximum){
                    answer[idx][0] = code;
                    answer[idx][1] = date;
                    answer[idx][2] = maximum;
                    answer[idx][3] = remain;
                    idx++;
                }
            }else if(ext.equals("remain")){
                if(val_ext>remain){
                    answer[idx][0] = code;
                    answer[idx][1] = date;
                    answer[idx][2] = maximum;
                    answer[idx][3] = remain;
                    idx++;
                }
            }
            
        }
        int[][] map = Arrays.copyOf(answer,idx);
        if(sort_by.equals("remain")){
            Arrays.sort(map,Comparator.comparingInt(a->a[3]));
        }else if(sort_by.equals("maximum")){
            Arrays.sort(map,Comparator.comparingInt(a->a[2]));
        }else if(sort_by.equals("date")){
            Arrays.sort(map,Comparator.comparingInt(a->a[1]));
        }else if(sort_by.equals("code")){
            Arrays.sort(map,Comparator.comparingInt(a->a[0]));
        }
        return map;
}
}