import java.io.*;

public class Main {
    static long[] dp = new long[21];

    public static void main(String[] args)throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        initDp();

        int N = Integer.parseInt(br.readLine());

        for(int i=0;i<N;i++){
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n]).append("\n");
        }

        System.out.print(sb.toString());
        br.close();

    }

    private static void initDp() {
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;  // (A, B) -> (B, A) 한 가지 경우

        for (int i = 3; i <= 20; i++) {
            dp[i] = (i - 1) * (dp[i - 1] + dp[i - 2]);
        }
    }
}
