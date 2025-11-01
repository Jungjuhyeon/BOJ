import java.util.*;

class Solution {
    static int[] parent;
    public int solution(int n, int[][] computers) {
        
        parent = new int[n];
        
        //부모 초기화
        for(int i=0;i<n;i++){
            parent[i] = i;
        }
        
        for(int i=0 ; i<n;i++){
            for(int j=0;j<n;j++)
                {
                if(i != j && computers[i][j] ==1){
                    union(i,j);
                    }
                }
            }
        
        Set<Integer> set = new HashSet<>();
        
        for(int i : parent){
            set.add(find(i)); // ← 핵심 수정
        }
        return set.size();
        
    }
    
    public static void union(int a,int b){
        int aRoot = find(a);
        int bRoot = find(b);
        if(aRoot != bRoot){
            parent[bRoot] = aRoot;
        }
    }
    public static int find(int i){
        if(parent[i] == i )return i;
        else{
            return parent[i] = find(parent[i]);
        }
    }
}