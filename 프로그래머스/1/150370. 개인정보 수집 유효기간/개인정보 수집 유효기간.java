import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        String[] t = today.split("\\.");
        int t_y = Integer.parseInt(t[0]);
        int t_m = Integer.parseInt(t[1]);
        int t_d = Integer.parseInt(t[2]);
        int t_ymd = t_y*10000 + t_m*100 + t_d;

        Map<String,Integer> termsMap = new HashMap<>();
        for(String term : terms){
            String[] ts = term.split(" ");
            termsMap.put(ts[0],Integer.parseInt(ts[1]));
        }
        ArrayList<Integer> list = new ArrayList<>();
        int idx =1;
        for(String privacie : privacies){
            
            String[] tt = privacie.split(" ");
            String alpha = tt[1];
            
            String[] ttt = tt[0].split("\\.");
            int p_y = Integer.parseInt(ttt[0]);
            int p_m = Integer.parseInt(ttt[1]);
            int p_d = Integer.parseInt(ttt[2]);
            
            p_m += termsMap.get(alpha);
            p_y += (p_m - 1) / 12;
            p_m = (p_m - 1) % 12 + 1;
            
            if(p_d ==1){
                p_d=28;
                if(p_m ==1){
                    p_m =12;
                    p_y--;
                }else{
                    p_m--;
                }
            }else{
                p_d--;
            }
            
            int p_ymd = p_y*10000 + p_m*100 + p_d;
            if(t_ymd>p_ymd) list.add(idx);
            idx++;
        }
        
        int[] answer = new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i]= list.get(i);
        }
        return answer;
    }
}