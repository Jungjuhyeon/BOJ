import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] a = {1,2,3,4,5};
        int[] b = {2,1,2,3,2,4,2,5};
        int[] c = {3,3,1,1,2,2,4,4,5,5};
        int a_count=0;
        int b_count=0;
        int c_count=0;
        for(int i=0;i<answers.length;i++){
            if(a[i % a.length] == answers[i]) a_count++;
            if(b[i%b.length] == answers[i]) b_count++;
            if(c[i%c.length] == answers[i]) c_count++;
        }
        int[][] ar = {{1,a_count},{2,b_count},{3,c_count}};
        Arrays.sort(ar,(o1,o2)-> -Integer.compare(o1[1],o2[1]));
        ArrayList<Integer> list = new ArrayList<>();
        list.add(ar[0][0]);
        if(ar[0][1] == ar[1][1]){
            list.add(ar[1][0]);
            if(ar[1][1] == ar[2][1]){
                list.add(ar[2][0]);
            }
        }
        int[] answer = new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i);
        }
            
        return answer;
    }
}