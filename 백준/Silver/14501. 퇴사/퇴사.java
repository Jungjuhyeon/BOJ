
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] T = new int[N];
        int[] P = new int[N];
        int[] dp = new int[N + 1]; // i일차부터 퇴사일까지 최대 수익

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            int day = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            T[i] = day;
            P[i] = price;
        }

        // DP 배열 채우기 (뒤에서부터)
        for (int i = N - 1; i >= 0; i--) {
            if (i + T[i] > N) { // 상담 불가능
                dp[i] = dp[i + 1];
            } else { // 상담 가능
                dp[i] = Math.max(dp[i + 1], P[i] + dp[i + T[i]]);
            }
        }

        System.out.println(dp[0]); // 0일부터 시작하는 최대 이익
    }
    
}
