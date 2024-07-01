import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] list ;
    static boolean[] v;
    static StringBuilder sb =new StringBuilder();

    static void dfs(int i){
        v[i] = true;
        sb.append(i).append(" ");
//        System.out.print(i);
        for(int j : list[i]) { //0->N
            if (!v[j]) {
                dfs(j);
            }
        }
    }

    static void bfs(int i){
        ArrayDeque<Integer> q = new ArrayDeque<>();
        v[i] = true;
        q.offer(i);
        while (!q.isEmpty()) {
            i = q.poll();
            sb.append(i).append(" ");
            for (int j : list[i]) { //0 -> N
                if (!v[j]) {
                    v[j] = true;
                    q.offer(j);
                }
            }
        }
    }

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;

        st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        list = new List[N+1];
        for(int i=1;i<=N;i++){
            list[i] = new ArrayList<>();
        }
        v = new boolean[N+1];
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            list[from].add(to);
            list[to].add(from);
        }
//        for (List<Integer> a : list) System.out.println(a);

        // 각 리스트를 정렬하여 작은 번호부터 방문하도록 설정
        for (int i = 1; i <= N; i++) {
            list[i].sort((a, b) -> Integer.compare(a, b));
        }
        
        dfs(V);
        sb.append("\n");
        v = new boolean[N+1];
        bfs(V);

        System.out.println(sb);

    }

}
