import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int cur_weight = 0;
        ArrayDeque<Integer> bridge = new ArrayDeque<>();
        
        for (int i = 0; i < bridge_length; i++) {
            bridge.offer(0); // 다리 길이만큼 0으로 채움
        }
        
        int index = 0;
        
        while (index < truck_weights.length) {
            // 시간 경과
            answer++;
            
            // 다리에서 트럭 하나 내리기
            cur_weight -= bridge.poll();
            
            // 다음 트럭이 다리에 올라갈 수 있는지 확인
            if (cur_weight + truck_weights[index] <= weight) {
                // 트럭 다리에 올리기
                bridge.offer(truck_weights[index]);
                cur_weight += truck_weights[index];
                index++;
            } else {
                // 트럭 다리에 올리지 못하면 0을 올려서 다리의 길이 유지
                bridge.offer(0);
            }
        }
        
        // 마지막 트럭이 다리를 다 건너기까지 걸리는 시간 추가
        answer += bridge_length;
        
        return answer;
    }
}