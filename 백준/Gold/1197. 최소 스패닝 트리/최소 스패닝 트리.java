import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine()," ");
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        List<int[]>[] list = new List[V+1];

        for(int i=1;i<V+1;i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            list[a].add(new int[]{b,C});
            list[b].add(new int[]{a,C});

        }

        boolean[] v = new boolean[V+1];
        int[] minEdge = new int[V+1];
        Arrays.fill(minEdge,Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)-> Integer.compare(o1[1],o2[1]));

        int sum =0,cnt =0;
        minEdge[1]=0;
        pq.offer(new int[]{1,minEdge[1]});

        while(!pq.isEmpty()){
            int[] vw =pq.poll();
            int min = vw[1];
            int minVertex = vw[0];
            if(v[minVertex]) continue;

            v[minVertex] =true;
            sum += min;
            if(cnt++ ==V-1) break;

            for(int[] i : list[minVertex]){
                if(!v[i[0]] && minEdge[i[0]]>i[1]){
                    minEdge[i[0]] = i[1];
                    pq.offer(new int[]{i[0],minEdge[i[0]]});
                }
            }
        }
        System.out.println(sum);


    }
}
