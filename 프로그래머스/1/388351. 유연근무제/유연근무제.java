import java.util.*;

class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        
        int answer =0;
        for(int i=0; i<schedules.length; i++){
            int h = schedules[i]/100;
            int m = schedules[i]%100+10;
            
            if(m>=60){
                h++;
                m = m%60;
            }
            
            int scheduleTime = h*100 + m;
            
            int day = startday-1;
            boolean checked = true;
            for(int j=0;j<7;j++)
            {
                day %= 7;
                if(day>=5){
                    day++;
                    continue;
                }
                if(scheduleTime < timelogs[i][j]){
                    checked = false;
                    break;
                }
                day++;
            }
            if(checked){
                answer++;
            }
        }
        return answer;
    }
}
//1. 토요일,일요일 idx 찾기 계쏙 계산하기? 0 1 2 3 4 5 6
//2. schedules for문으로 가져와서 +10하고 timelogs와 비교하기 
