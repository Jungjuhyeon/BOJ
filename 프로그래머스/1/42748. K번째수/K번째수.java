import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
    
        int[] answer = new int[commands.length];
        
        int idx =0;
        for(int[] arr: commands){
            ArrayList<Integer> list = new ArrayList<>();
            for(int i = arr[0]-1 ; i<arr[1];i++){
                list.add(array[i]);
            }
            Collections.sort(list);
            answer[idx] = list.get(arr[2]-1);
            idx++;
            list.clear();
        }
        return answer;
    }
}