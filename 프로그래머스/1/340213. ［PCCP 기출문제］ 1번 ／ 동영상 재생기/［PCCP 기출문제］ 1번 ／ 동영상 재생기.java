//10초전 - 사용자가 prev입력, 10초전으로 단 10초 미만인경우 영상의 처음 위치
//10초후 - next입력하면 10초 후 단 남은 시간이 10초 미만일 경우 마지막 위치
//오프닝 건너뛰기 - 오프닝이 끝나는 위치로 이동

class Solution {
    static int creattime(String videotime){
        String[] word = videotime.split(":");
        int a = Integer.parseInt(word[0]);
        int b = Integer.parseInt(word[1]);
        return a * 60 + b;
    }
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        int videotime = creattime(video_len);
        int postime = creattime(pos);
        int opstarttime = creattime(op_start);
        int opendtime = creattime(op_end);
        if(postime >= opstarttime && postime<=opendtime){
            postime = opendtime;
        }
    
        for(int i = 0; i<commands.length; i++){
            String word = commands[i];
            if(word.equals("next")){
                if(videotime - postime < 10){
                    postime = videotime;
                } else{
                    postime+=10;
                    if(postime >= opstarttime && postime<=opendtime){
                        postime = opendtime;
                    }
                }
            }else if(word.equals("prev")){
                if(postime - 10 <0){
                    postime = 0 ;
                    if(postime >= opstarttime && postime<=opendtime){
                        postime = opendtime;
                    }
                }else{
                    postime-=10;
                    if(postime >= opstarttime && postime<=opendtime){
                        postime = opendtime;
                    }
                }
            }
        }
        int h = postime / 60;
        int m = postime % 60;
        if(h < 10){
            answer+="0";
            answer+=h;
            answer+=":";
        }else{
            answer+=h;
            answer+=":";
        }
        if(m < 10){
            answer+="0";
            answer+=m;
        }else{
            answer+=m;
        }
        
        
        return answer;
    }
}