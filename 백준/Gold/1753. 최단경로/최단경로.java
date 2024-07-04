import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine()," ");

        int V = Integer.parseInt(st.nextToken());
        int E =Integer.parseInt(st.nextToken());

        int K = Integer.parseInt(br.readLine());

        List<int[]>[] g = new List[V+1];

        for(int i=0;i<V+1;i++){
            g[i] = new ArrayList<>();
        }

        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            g[a].add(new int[]{b,cost});
        }

        boolean[] v = new boolean[V+1];
        int[] w = new int[V+1];
        Arrays.fill(w,Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->Integer.compare(o1[1],o2[1]));
        w[K] =0;

        pq.offer(new int[]{K,w[K]});

        while(! pq.isEmpty()){
            int [] vw = pq.poll();
            int min = vw[1];
            int minVertex = vw[0];
            if(v[minVertex]) continue;

            v[minVertex] =true;

//            if(minVertex ==V-1)break;

            for(int [] j: g[minVertex]){
                if(!v[j[0]] && w[j[0]] >(min+j[1])){
                    w[j[0]] = min+j[1];
                    pq.offer(new int[]{j[0],min+j[1]});
                }
            }
        }

       for(int i=1; i<V+1; i++){
           if(w[i] == Integer.MAX_VALUE){
               sb.append("INF");
           }else{
               sb.append(w[i]);
           }
           sb.append("\n");
       }

       System.out.println(sb);
       br.close();


    }
}
