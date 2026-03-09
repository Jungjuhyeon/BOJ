import java.util.*;

class Solution{
    static int[] a = new int[5];
    static Set<Integer>[] set;
    static int answer =0;
    public int solution(int n, int[][] q, int[] ans) {
        
        set = new Set[q.length];
        for(int i=0;i<q.length;i++){
            set[i] = new HashSet<>();
            for(int j=0;j<5;j++){
                set[i].add(q[i][j]);
            }
        }
        
        search(0,1,n,q,ans);
        return answer;
    }
    private void search(int cnt,int start,int n,int[][] q,int[] ans){
        if(cnt == 5){
            if(Valid(q,ans)) answer++;
            return;
        }
        
        for(int i =start ;i<=n;i++){
            a[cnt] = i;
            search(cnt+1,i+1,n,q,ans);
        }
    }
    
    private boolean Valid(int[][] q, int[] ans){
        for(int i=0;i<q.length;i++){
            int sum =0;
            for(int j=0;j<5;j++){
                if(set[i].contains(a[j])){
                    sum++;
                }
            }
            if(ans[i] != sum){
                return false;
            }
        }
        return true;
    }

}