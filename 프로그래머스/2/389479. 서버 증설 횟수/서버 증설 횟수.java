import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer =0;
        ArrayDeque<Integer> server = new ArrayDeque<>();
        
        for(int i=0;i<players.length;i++){
            
            int expanServer = players[i]/m; //필요한 서버수
            
            while(!server.isEmpty() && server.peek() <=i){
                server.poll();
            }
            
            if(expanServer>server.size()){
                int count = expanServer-server.size();
                for(int n=0 ;n<count ;n++){
                    server.add(i+k);
                    answer++;
                }
            }
        }
        return answer;
    }
}

//list에 시간을 넣어서 집어넣는다.