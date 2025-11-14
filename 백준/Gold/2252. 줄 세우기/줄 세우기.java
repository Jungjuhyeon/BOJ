
import java.util.*;
import java.io.*;

public class Main {
    static int N,M;
    static List<Integer>[] g;
    static int[] indegree; //진입차수 메모
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        g = new ArrayList[N+1];

        for(int i=0;i<N+1;i++){
            g[i] = new ArrayList<>();
        }
        indegree = new int[N+1];

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            g[from].add(to);
            indegree[to]++;
        }
        bfs();

        System.out.println(sb);
    }

    public static void bfs(){
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for(int i=1;i<=N;i++){
            if(indegree[i] ==0 ) q.offer(i);
        }

        while(!q.isEmpty()){
            int i= q.poll();
            sb.append(i).append(" ");
            for(int j : g[i]){
                indegree[j]--;
                if(indegree[j] ==0){
                    q.offer(j);
                }
            }
        }
    }
}
