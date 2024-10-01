import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int cnt = 0;
        
        int[] arr = new int[n+1];

        ArrayList<Integer>[] list = new ArrayList[n+1];
        boolean[] v = new boolean[n+1];
        
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        
        for(int[] l : edge){
            int a = l[0];
            int b = l[1];
            
            list[a].add(b);
            list[b].add(a);
        }
        
        ArrayDeque<Integer> q = new ArrayDeque<>();
        
        
        q.add(1);
        v[1] = true;
        
        while(!q.isEmpty()){
            int p = q.poll();
            for(int a: list[p]){
                if(!v[a]){
                    q.add(a);
                    v[a]= true;
                    arr[a] = arr[p]+1;
                }
                continue;
            }
        }
        Arrays.sort(arr);
        
        int max = arr[n];
        
        for(int i=n; i>=1; i--) {
            if(max == arr[i]) {
                cnt++;
            }
            else {
                break;
            }
        }
        
        return cnt;
         
    }
}