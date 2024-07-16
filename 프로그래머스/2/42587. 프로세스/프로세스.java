import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        ArrayDeque<Integer> q = new ArrayDeque<>();
        
        for(int i=0;i<priorities.length;i++){
            q.offer(i);
            pq.offer(priorities[i]);
        }
        
        int count = 0;

        while(!q.isEmpty()){
            int idx = q.poll();
                
            if(priorities[idx] == pq.peek()){
                pq.poll();
                count++;
                
                if(idx == location){
                    break;
                }
            }
            else{
                q.offer(idx);
            }
        }
        return count;
        
    }
}