
import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static List<Integer>[] g;
    static int[] indegree;
    static int[] dur;
    static int[] dp;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        g = new List[N+1];
        indegree = new int[N+1];
        dur = new int[N+1];

        for(int i=1;i<N+1;i++){
            g[i] = new ArrayList<>();
        }

        for(int i=1;i<N+1;i++){
            st = new StringTokenizer(br.readLine()," ");
            dur[i] = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            for(int j=0;j<K;j++){
                int from = Integer.parseInt(st.nextToken());
                g[from].add(i);
                indegree[i]++;
            }
        }

        bfs();

        int answer =0;
        for(int i=0;i<N+1;i++){
            answer = Math.max(answer,dp[i]);
        }
        System.out.println(answer);
    }

    public static void bfs(){
        ArrayDeque<Integer> q = new ArrayDeque<>();
        dp = new int[N+1];
        for(int i=1;i<N+1;i++){
            dp[i] = dur[i];
            if(indegree[i] ==0 ) q.offer(i);
        }

        while(!q.isEmpty()){
            int i = q.poll();

            for(int j : g[i]){
                if(dp[j] < dp[i]+dur[j]){
                    dp[j] = dp[i]+dur[j];
                }
                indegree[j]--;
                if(indegree[j] ==0) q.offer(j);
            }
        }
    }
}
