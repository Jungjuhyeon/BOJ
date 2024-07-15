import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        ArrayDeque<Integer> q = new ArrayDeque<>();
        
        for(int i=0;i<progresses.length;i++){
            q.offer(progresses[i]);
        }
        
        List<Integer> answerList = new ArrayList<>();
        int day = 0;
        int idx=0;
            
        while(!q.isEmpty()){
            int count =0;
            
            while (!q.isEmpty() && q.peek() + day * speeds[idx] >= 100) {
                q.poll();
                count++;
                idx++;
            }
            
            if(count>0){
            answerList.add(count);
            }
            day++;
            
        }
        int[] answer = new int[answerList.size()];

        for(int i=0;i<answer.length; i++){
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}