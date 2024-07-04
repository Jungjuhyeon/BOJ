import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        List<int[]>[] g = new List[N+1];

        for(int i=0;i<N+1;i++){
            g[i] = new ArrayList<>();
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int j = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            int cost =Integer.parseInt(st.nextToken());
            g[j].add(new int[]{z,cost});
            g[z].add(new int[]{j,cost});
        }

        boolean[] v =new boolean[N+1];
        int[] minEdge = new int[N+1];
        Arrays.fill(minEdge,Integer.MAX_VALUE);

        int sum =0,cnt =0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->Integer.compare(o1[1],o2[1]));

        minEdge[1] = 0;
        pq.offer(new int[]{1,minEdge[1]});

        while(!pq.isEmpty()){
            int[] i= pq.poll();
            int min = i[1];
            int minVertex = i[0];
            if(v[minVertex]) continue;

            v[minVertex] = true;
            sum += min;

            if(cnt++ == N-1) break;

            for(int[] j:g[minVertex]){
                if(!v[j[0]]&& minEdge[j[0]]>j[1]){
                    minEdge[j[0]]= j[1];
                    pq.offer(new int[]{j[0],minEdge[j[0]]});
                }
            }

        }

        System.out.println(sum);
    }
}
