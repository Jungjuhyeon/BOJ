import java.util.*;

class Solution {
    boolean[] v;
    List<String> answer = new ArrayList<>();
    public String[] solution(String[][] tickets) {
        
        v = new boolean[tickets.length];
        
        Arrays.sort(tickets, (a,b) -> {
            if(a[0].equals(b[0])){
                return a[1].compareTo(b[1]);
            }
            return a[0].compareTo(b[0]);
        });
        
        List<String> path = new ArrayList<>();
        path.add("ICN");
        
        dfs("ICN", "ICN", tickets,path,0);
        
        return answer.toArray(new String[0]);
    }
    public boolean dfs(String start,String cur,
                      String[][] tickets,
                      List<String> path,
                      int depth){
        if(depth==tickets.length){
            answer = new ArrayList<>(path);
            return true;
        }
        
        for(int i=0;i<tickets.length;i++){
            
            String from = tickets[i][0];
            String to = tickets[i][1];
            
            if(v[i]) continue;
            
            if(cur.equals(from)){
                v[i] = true;
                path.add(to);
                
                if(dfs(start, to, tickets, path, depth + 1)) {
                    return true;
                }
                
                v[i] = false;
                path.remove(path.size() -1);
            }
        }
        return false;
    }
}
