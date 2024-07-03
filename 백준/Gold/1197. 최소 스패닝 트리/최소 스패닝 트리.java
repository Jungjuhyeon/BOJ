import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        List<int[]>[] g = new List[V+1];

        for(int i=0;i<=V;i++){
            g[i] = new ArrayList<>();
        }

        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine());
            int a =  Integer.parseInt(st.nextToken());
            int b =Integer.parseInt(st.nextToken());
            int cost =Integer.parseInt(st.nextToken());
            g[a].add(new int[] {b, cost});
            g[b].add(new int[] {a, cost});

        }

        boolean[] v = new boolean[V+1];
        int[] minEdge = new int[V+1];
        Arrays.fill(minEdge,Integer.MAX_VALUE);

        int sum=0,cnt=0;
        minEdge[1] =0;
        for(int i=1;i<V+1;i++){
            int minVertex = -1;
            int min = Integer.MAX_VALUE;

            for(int j=1;j<V+1;j++){
                if(!v[j] && min>minEdge[j]){
                    minVertex = j;
                    min = minEdge[j];
                }
            }

            v[minVertex] = true;
            sum += min;
            if(cnt++ == V-1) break;

            for(int[] j :g[minVertex]){
                if(!v[j[0]] && minEdge[j[0]]>j[1]){
                    minEdge[j[0]] =  j[1];
                }
            }


        }

        System.out.println(sum);
    }

}
