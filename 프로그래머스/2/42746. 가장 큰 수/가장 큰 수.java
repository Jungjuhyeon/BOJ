import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        int N = numbers.length;
        String answer ="";
        
        String[] str = new String[N];
        
        for(int i=0;i<N;i++){
            str[i] = Integer.toString(numbers[i]);
        }
        
        Arrays.sort(str,(o1,o2)->(o2+o1).compareTo(o1+o2));
        
        if(str[0].equals("0")){
            return "0";
        }
        
        for(String s : str){
            answer+=s;
        }
        
        return answer;
    }
}