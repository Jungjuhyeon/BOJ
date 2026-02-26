import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] arg = new String[numbers.length];
        
        for(int i=0;i<numbers.length;i++){
            arg[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(arg,(a,b)-> (b+a).compareTo(a+b));
        
        if(arg[0].equals("0")) return "0";

        String answer = "";
        
        for(int i=0;i<numbers.length;i++){
            answer+= arg[i];
        }    
        return answer;
    }
}

