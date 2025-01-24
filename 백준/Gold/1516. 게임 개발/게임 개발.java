
import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static List<Integer>[] g;
    static int[] indegree;
    static int[] cost;
    static int[] answer;

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        indegree = new int[N+1];
        cost = new int[N+1];
        answer = new int[N+1];
        g = new List[N + 1];

        for(int i=0;i<=N;i++){
            g[i] = new ArrayList<>();
        }

        for(int to=1;to<=N;to++){
            st = new StringTokenizer(br.readLine()," ");
            int curCost = Integer.parseInt(st.nextToken());
            cost[to] = curCost;

            while(true){
                int from = Integer.parseInt(st.nextToken());
                if( from ==-1){
                    break;
                }
                g[from].add(to);
                indegree[to]++;
            }
        }
        mst();

        for (int i = 1; i <= N; i++) {
            System.out.println(answer[i]);
        }
    }
    static void mst(){
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for(int i=1;i<=N;i++){
            if(indegree[i]==0){
                q.offer(i);
                answer[i] = cost[i];
            }
        }
        while(!q.isEmpty()){
            int current = q.poll();
            for(int next: g[current]){
                indegree[next]--;
                // 최소 건설 시간 갱신
                answer[next] = Math.max(answer[next], answer[current] + cost[next]);

                if (indegree[next] == 0) {
                    q.offer(next);
                }
            }
        }

    }

    /**
     * 일단 건물을 짓기위해서, 먼저 지어야하는 순서가 정해져있으므로, 이는 위상정렬이다.
     */
}
