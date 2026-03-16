import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        int max =0;
        
        for(int[] edge : edges){
            max = Math.max(max,Math.max(edge[0],edge[1]));
        }
        
        int[] in = new int[max+1];
        int[] out = new int[max+1];
        
        for(int[] edge : edges){
            int outN = edge[0];
            int inN = edge[1];
            in[inN]++;
            out[outN]++;
        }
        int jung =0;
        int mak =0;
        int pal =0;
        int donut =0;
        for(int i=1;i<=max;i++){
            
            //정점
            if(in[i]==0 && out[i]>=2){
                jung = i;
            }
            //막대
            if(in[i] >=1 && out[i]==0){
                mak++;
            }
            
            //8
            if(in[i]>=2 && out[i]==2){
                pal++;
            }
        }
        donut = out[jung] - pal - mak;
        
        return new int[]{jung,donut,mak,pal};
    }
    
}
//정점 : in=0, out>=2
//막대 : in =1, out =0;
//8   : in>=2 out =2
//도넛 : 정점갯수 - 막대 -8