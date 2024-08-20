import java.util.*;
class Solution {
  
    public int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[n+1][m+1];
        int[][] dp = new int[n+1][m+1];
        dp[1][1] =1;
        
        for(int[] a: puddles){
            int q = a[0];
            int w = a[1];
            map[w][q] = 1;
        }
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(map[i][j] ==1) continue;
                
                if(i-1>=1) dp[i][j] += dp[i-1][j]; //위 ->아래
                if(j-1>=1) dp[i][j] += dp[i][j-1]; //위 -> 오른쪽
                
                dp[i][j] %= 1000000007;
            }
        }
        int answer =dp[n][m];
        return answer;
        
    }
}

// 무조건 아래 오른쪽 밖에 없으니까, 최단거리가 되는거네

