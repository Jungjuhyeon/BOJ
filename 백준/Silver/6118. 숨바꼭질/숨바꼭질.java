
import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static List<Integer>[] graph;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];

        for(int i=0;i<=N;i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a1 = Integer.parseInt(st.nextToken());
            int b1 = Integer.parseInt(st.nextToken());
            graph[a1].add(b1);
            graph[b1].add(a1);
        }

        bfs();
        System.out.println(sb);

    }

    private static void bfs(){
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{1,0});
        boolean[] v = new boolean[N+1];
        v[1] = true;
        int max = Integer.MIN_VALUE;
        ArrayList<Integer> list = new ArrayList<>();

        while(!q.isEmpty()){
            int[] ij = q.poll();
            int curI = ij[0];
            int depth = ij[1];

            if(depth>max){
                list.clear();
                list.add(curI);
                max = depth;
            }
            else if(depth == max){
                list.add(curI);
            }
            for(int i=0; i<graph[curI].size(); i++){
                int nextI = graph[curI].get(i);
                if(!v[nextI]){
                    q.offer(new int[]{nextI,depth+1});
                    v[nextI] = true;
                }
            }
        }
        Collections.sort(list);
        sb.append(list.get(0)).append(" ");
        sb.append(max).append(" ");
        sb.append(list.size()).append(" ");

    }

}
