import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        int len = numbers.length;
        int answer = bfs(numbers,target,len);
        return answer;
    }
    
    private int bfs(int[] numbers,int target,int len){
        ArrayDeque<int[]> q = new ArrayDeque<>();

        q.offer(new int[]{numbers[0], 0});
        q.offer(new int[]{-numbers[0], 0});

        int count = 0;
        
        while(!q.isEmpty()){
            int[] ij = q.poll();
            int curNum = ij[0];
            int id = ij[1];
            
            // 마지막 숫자까지 사용한 경우
            if (id == len - 1) {
                if (curNum == target) {
                    count++;
                }
                continue;
            }
            
            
            q.offer(new int[]{curNum+(-1*numbers[id+1]),id+1});
            q.offer(new int[]{curNum+numbers[id+1],id+1});
            
        }
        return count; 
    }
}