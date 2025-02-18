import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static List<Integer>[] list;
    static int[] indegree;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new List[N+1];
        for(int i=0;i<N+1;i++){
            list[i] = new ArrayList<>();
        }

        indegree = new int[N+1];

        for(int i =0;i<M;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            list[from].add(to);
            indegree[to]++;
        }
        bfs();

        System.out.println(sb.toString());

    }
    public static void bfs(){
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=1;i<N+1;i++){
            if(indegree[i]== 0){
                pq.offer(i);
            }
        }

        while(!pq.isEmpty()){
            int index = pq.poll();
            sb.append(index).append(" ");

            for(int i : list[index]){
                indegree[i]--;
                if(indegree[i] == 0 ){
                    pq.offer(i);
                }
            }
        }

    }

}
