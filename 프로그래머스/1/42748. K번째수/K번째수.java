import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int len = commands.length;
        int[] answer = new int[len];
        
        for(int i=0;i<len;i++){
            int a = commands[i][0];
            int b = commands[i][1];
            int c = commands[i][2];
            ArrayList<Integer> list = new ArrayList<>();
            for(int j=a-1;j<b;j++){
                list.add(array[j]);
            }
            Collections.sort(list);
            answer[i] = list.get(c-1);
        }
        return answer;
    }
}