import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static int[][] g;
    static int[] parent;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parent = new int[N+1];
        g = new int[M][3];

        for(int i=0;i<N+1;i++){
            parent[i] =i;
        }

        long total =0;

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            total += c;
            g[i] = new int[]{a,b,c};
        }

        Arrays.sort(g,(a,b)->Integer.compare(a[2],b[2]));

        long answer = 0;
        int edge = 0;

        for(int[] e :g){
            if(union(e[0],e[1])){
                answer +=e[2];
                edge++;
            }
            if(edge == N-1){
                break;
            }
        }


        br.close();
        if(edge !=N-1){
            System.out.println("-1");

        }else{
            System.out.println(total - answer);
        }
    }
    static int find(int a){
        if(parent[a] != a){
            parent[a] = find(parent[a]);
        }
        return parent[a];
    }
    static boolean union(int a,int b){
        int rootA = find(a);
        int rootB = find(b);

        if(rootA != rootB){
            parent[rootB] = rootA;
            return true;
        }
        return false;
    }

}
