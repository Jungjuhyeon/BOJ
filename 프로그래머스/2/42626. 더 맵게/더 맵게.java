import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int answer =0;
        
        for(int i : scoville){
            pq.add(i);
        }
        
        while(pq.peek()<K){
            if(pq.size() ==1){ //만약 처음값이 K보다 작은데, pq에 1개만 있다면, 불가능하므로 -1을 리턴함.
                return -1;
            }
            int a = pq.poll(); //첫번쨰값
            int b = pq.poll(); //두번째값
            int mix = a + (b*2);
            pq.add(mix);
            answer++;
        }
        
        return answer;
    }
}