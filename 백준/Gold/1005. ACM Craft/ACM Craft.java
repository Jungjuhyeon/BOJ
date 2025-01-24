
import java.io.*;
import java.util.*;

public class Main {
    static int T; //테스트 개수
    static int N; //건물 개수
    static int K; //순서
    static int[] cost;//비용
    static int[] indegree; //진입차수
    static List<Integer>[] g;
    static int[] answer;

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        for(int i=0;i<T;i++){
            st = new StringTokenizer(br.readLine()," ");

            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            indegree = new int[N+1];
            cost = new int[N+1];
            g = new List[N + 1];
            answer = new int[N+1];

            for(int z=0;z<=N;z++){
                g[z] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine()," ");
            for(int j=1;j<=N;j++){
                cost[j] = Integer.parseInt(st.nextToken());
            }
            for(int k=0;k<K;k++){
                st = new StringTokenizer(br.readLine()," ");
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                g[from].add(to);
                indegree[to]++;
            }

            int destination = Integer.parseInt(br.readLine());

            mst();
            sb.append(answer[destination]).append("\n");
        }
        br.close();
        System.out.println(sb);

    }
    static void mst(){
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for(int i=1;i<=N;i++){
            if(indegree[i]==0) q.offer(i);
            answer[i] = cost[i];
        }

        while(!q.isEmpty()){
            int current = q.poll();
            for(int next : g[current]){
                indegree[next]--;

                answer[next] = Math.max(answer[next],answer[current]+cost[next]);

                if(indegree[next]==0){
                    q.offer(next);
                }
            }
        }
    }

}

/**
 * 해당 문제는 위상정렬문제이다. 순서가 정해져있기 때문이다.
 * 위상정렬의 시간복잡도는 O(N+E)이므로, O(1000+100,000)이므로 시간초과가 발생하지 않는다.
 */