import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int i=0;
        for(int[] ar : commands){
            int start = ar[0];
            int end = ar[1];
            int k = ar[2];
            int[] newArr = Arrays.copyOfRange(array,start-1,end);
            Arrays.sort(newArr);
            answer[i++] = newArr[k-1];
        }
        return answer;
    }
}