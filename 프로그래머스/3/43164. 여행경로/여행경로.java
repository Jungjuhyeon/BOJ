import java.util.*;

class Solution {
    static boolean[] v;
    static int R;
    static List<String[]> list;
    public String[] solution(String[][] tickets) {
        list = new ArrayList<>();
        R = tickets.length;
        
        for(int i=0 ; i<tickets.length ; i++){
            v = new boolean[tickets.length];
            if(tickets[i][0].equals("ICN")){
                v[i] = true;
                String[] path = new String[tickets.length + 1];
                path[0] = "ICN";
                dfs(i, tickets, path, 1); 
            }
        }
        
        
        // 사전순으로 정렬
        list.sort((a, b) -> Arrays.compare(a,b));

        return list.get(0); // 가장 앞선 경로 반환
    }
    
    public void dfs(int idx, String[][] tickets, String[] path, int depth) {
        path[depth] = tickets[idx][1];

        if(depth ==R){
            list.add(path.clone());
            return;
        }
        
        for (int i = 0; i < tickets.length; i++) {
            if (!v[i] && tickets[idx][1].equals(tickets[i][0])) {
                v[i] = true;
                dfs(i, tickets, path, depth + 1);
                v[i] = false;
            }
        }
       
        
        
    }
}