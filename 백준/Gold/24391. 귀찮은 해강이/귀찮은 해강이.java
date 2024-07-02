import java.io.*;
import java.util.*;

public class Main
{

    static int[] p;

    static int find(int i){
        if( p[i] == i) return i;
        else{
            return find(p[i]);
        }
    }

    static void union(int a,int b){
        int aRoot = find(a);
        int bRoot = find(b);

        if(aRoot == bRoot) return;
        if(aRoot>bRoot){
            p[aRoot] =bRoot;
        }else{
            p[bRoot] = aRoot;
        }
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        p =new int[N+1];
        for(int i=0;i<N+1;i++){
            p[i] =i;
        }
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            union(a, b);
        }

        int[] route = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            route[i] = Integer.parseInt(st.nextToken());
        }

        int count =0;
        for(int i=0;i<N-1;i++){
            int a = route[i];
            int b = route[i+1];

            int aRoot = find(a);
            int bRoot = find(b);
            if(aRoot != bRoot) count++;
        }

        System.out.println(count);
        br.close();





    }
}