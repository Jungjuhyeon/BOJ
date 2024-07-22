import java.io.*;
import java.util.*;


public class Main {
    static int N,M;
    static int[] parent;

    static int find(int i){
        if(parent[i] ==i) return i;
        return parent[i] = find(parent[i]);
    }

    static void union(int a,int b){
        int aRoot = find(a);
        int bRoot = find(b);
        parent[bRoot] = aRoot;
    }

    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb =new StringBuilder();

        st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N+1];

        for(int i=0;i<N+1;i++){
            parent[i] = i;
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(a == 0){
                union(b,c);
            }else{
                if(find(b)==find(c)){
                    sb.append("YES").append("\n");
                }else{
                    sb.append("NO").append("\n");
                }
            }

        }

        br.close();

        System.out.println(sb);


    }
}
