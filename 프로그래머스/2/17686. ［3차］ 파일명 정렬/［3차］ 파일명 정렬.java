import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        
        Arrays.sort(files,(a,b)->{
            
            String[] aSplit = split(a);
            String[] bSplit = split(b);
            
            int headCompare = aSplit[0].toLowerCase()
                    .compareTo(bSplit[0].toLowerCase());
            if(headCompare!=0) return headCompare;
            
            int numA = Integer.parseInt(aSplit[1]);
            int numB = Integer.parseInt(bSplit[1]);
            return Integer.compare(numA, numB);
        }
                
        );
        return files;
       
    }
    private String[] split(String word){
        
        int i=0;
        while(i<word.length() && !Character.isDigit(word.charAt(i))){
            i++;
        }
        String head = word.substring(0,i);
        
        int numberIdx = i;
        while(i<word.length() && Character.isDigit(word.charAt(i))){
            i++;
        }
        String number = word.substring(numberIdx,i);
    
        return new String[]{head,number};
    }
}