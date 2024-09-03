import java.util.*;

class Solution {
    boolean[] v;
    ArrayList<String> list = new ArrayList<>();
    int length;
    public String[] solution(String[][] tickets) {
        length = tickets.length; 
        v = new boolean[length];
        
        dfs(0,"ICN", "ICN",tickets);
        
        Collections.sort(list);

        return list.get(0).split(" ");
             
    }
    public void dfs(int depth,String start, String path,String[][] tickets){
        if(depth == length){
            list.add(path);
            return;
        }
        for(int i=0; i<length;i++){
            if(!v[i] && tickets[i][0].equals(start)){
                v[i] =true;
                dfs(depth+1,tickets[i][1],path+ " "+tickets[i][1], tickets);
                v[i] = false;
            }
        }
    }
}