import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        StringTokenizer st;
        
        PriorityQueue<Integer> minpq = new PriorityQueue<>();
        PriorityQueue<Integer> maxpq = new PriorityQueue<>(Collections.reverseOrder());
        
        int length = operations.length;
        
        for(int i=0;i<length;i++){
            st = new StringTokenizer(operations[i]," ");
            String text = st.nextToken();
            int num = Integer.parseInt(st.nextToken()); 
            if(text.equals("I")){
                minpq.offer(num);
                maxpq.offer(num);
            }
            else{
            if(num ==-1){
                if(!minpq.isEmpty()){
                    maxpq.remove(minpq.poll());
                }
            }else{
                if(!maxpq.isEmpty()){
                    minpq.remove(maxpq.poll());
                    }
                }
            }
        }
        if(!maxpq.isEmpty()) answer[0] = maxpq.poll();
        if(!minpq.isEmpty()) answer[1] = minpq.poll();
    
        return answer;
    }
}