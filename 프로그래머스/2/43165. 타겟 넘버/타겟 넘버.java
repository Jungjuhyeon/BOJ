import java.util.*;

class Solution {
    static int answer = 0;
    public int solution(int[] numbers, int target) {
        
        dfs(numbers,target,0,0);
        
        return answer;
        
    }
        public static void dfs(int[] numbers, int target, int depth, int total) {
        if (depth == numbers.length) {
            if (total == target) answer++;
            return;
        }

        // 현재 숫자 더하는 경우
        dfs(numbers, target, depth + 1, total + numbers[depth]);
        // 현재 숫자 빼는 경우
        dfs(numbers, target, depth + 1, total - numbers[depth]);
    }
}

//해당문제는 dfs이지 않을까 싶음.
//