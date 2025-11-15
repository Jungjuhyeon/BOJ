
import java.util.*;
import java.io.*;

public class Main {
    static int N,M,original;
    static List<int[]>[] g;
    static int[] indegree;
    static Map<Integer,Integer>[] dp;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb =new StringBuilder();

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        g = new List[N+1];
        indegree = new int[N+1];
        dp = new Map[N+1];

        for(int i=0;i<N+1;i++){
            g[i] = new ArrayList<>();
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());
            g[from].add(new int[]{to,count});
            indegree[to]++;
        }

        bfs();

        List<Integer> list = new ArrayList<>(dp[N].keySet());
        Collections.sort(list);

        for (int basic : list) {
            sb.append(basic).append(" ").append(dp[N].get(basic)).append("\n");
        }

        System.out.print(sb);

    }
    public static void bfs(){
        ArrayDeque<Integer> q = new ArrayDeque<>();
        original = 0;

        for (int i = 1; i <= N; i++) {
            dp[i] = new HashMap<>();
            if (indegree[i] == 0) {
                original++;
                dp[i].put(i, 1); // 기본 부품은 자기 자신 1개 필요
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int i = q.poll();

            for(int[] j : g[i]){
                int num = j[0];
                int count = j[1];

                for(int basic : dp[i].keySet()){
                    int need = dp[i].get(basic);
                    dp[num].put(basic,dp[num].getOrDefault(basic,0)+need*count);
                }

                indegree[num]--;
                if(indegree[num] ==0){
                    q.offer(num);
                }
            }
        }
    }
}

//진입차수 0인게 기본조립
//진출할떄마다, dp[]에 list<int[]>로 데이터 넣는 형식으로 메모이제이션을 진행한다.
