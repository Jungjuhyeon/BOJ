import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] w = new int[N+1];
        int[] p = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++){
            w[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++){
            p[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N + 1][101]; // 체력이 0이 되는 경우를 고려하여 최대 체력을 100으로 설정
        for (int i = 1; i <= N; i++) {
            for (int W = 1; W < 100; W++) {
                if (w[i] <= W) {
                    dp[i][W] = Math.max(dp[i - 1][W], p[i] + dp[i - 1][W - w[i]]);
                } else {
                    dp[i][W] = dp[i - 1][W];
                }
            }
        }

        System.out.println(dp[N][99]);


    }
}