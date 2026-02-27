import java.util.*;

class Solution {
    public int[] solution(String s) {
        s = s.substring(2,s.length()-2);
        String[] arg = s.split("\\},\\{");
        Arrays.sort(arg, (a, b) -> Integer.compare(a.length(), b.length()));        
        
        Set<String> set = new HashSet<>();
        int[] answer = new int[arg.length];
        
        for(int i=0;i<arg.length;i++){
            String[] a = arg[i].split(",");
            
            for(int j=0;j<a.length;j++){
                if(!set.contains(a[j])){
                    set.add(a[j]);
                    answer[i] = Integer.parseInt(a[j]);
                }
            }
        }
        return answer;
    }
}