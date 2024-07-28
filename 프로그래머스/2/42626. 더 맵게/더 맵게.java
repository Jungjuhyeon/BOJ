import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int answer =0;
        
        for(int i : scoville){
            pq.offer(i);
        }
        
        while(pq.peek()<K){
            if(pq.size() ==1){
                return -1;
            }
            int a = pq.poll(); //첫번쨰값
            int b = pq.poll(); //두번째값
            int mix = a + (b*2);
            pq.offer(mix);
            answer++;
        }
        
        return answer;
    }
}