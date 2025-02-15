import java.io.*;
import java.util.*;

class Solution {
    ArrayList<String> list = new ArrayList<>();
    boolean[] v;
    int length;
    public String[] solution(String[][] tickets) {
        length = tickets.length;
        v = new boolean[length];
        
        perm(0,"ICN","ICN",tickets);
        
        Collections.sort(list);
                
        return list.get(0).split(" ");
    }
    
    public void perm(int depth,String start, String path,String[][] tickets){
        if(depth == length){
            list.add(path);
            return;
        }
        for(int i=0;i<length;i++){
            if(tickets[i][0].equals(start)){
                if(v[i]) continue;
                v[i] = true;
                perm(depth+1,tickets[i][1],path +" "+ tickets[i][1],tickets);
                v[i] = false;
            }
        }
    }
}
 