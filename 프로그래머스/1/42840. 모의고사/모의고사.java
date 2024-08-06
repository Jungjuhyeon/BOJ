import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] a = {1,2,3,4,5};
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int z=0;
        int x=0;
        int k=0;
        for(int i=0;i<answers.length;i++){
            if(a[i%5] == answers[i]) z++;
            if(b[i%8] == answers[i]) x++;
            if(c[i%9] == answers[i]) k++;
        }
        
        int[] answer = {z,x,k};
        Arrays.sort(answer);
        
        return answer;
        
    }
}