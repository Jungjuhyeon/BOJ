
import java.util.*;
import java.io.*;


public class Main {
    static int[] p;

    static void union(int a,int b){
        int aRoot = find(a);
        int bRoot = find(b);
        p[bRoot] = aRoot;
    }
    static int find(int i){
        if(p[i] == i) return i;
        return p[i] = find(p[i]);
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb =new StringBuilder();

        int N  = Integer.parseInt(br.readLine());
        int M  = Integer.parseInt(br.readLine());
        p = new int[N+1];
        for(int i=1;i<N+1;i++){
            p[i] =i;
        }

        for(int i=1;i<N+1;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=1;j<N+1;j++){
                int n = Integer.parseInt(st.nextToken());
                if(n ==1){
                    union(i,j);
                }
            }
        }
        st = new StringTokenizer(br.readLine()," ");
        int start = find(Integer.parseInt(st.nextToken()));
        boolean isPossible = true;

        for (int i = 1; i < M; i++) {
            int city = Integer.parseInt(st.nextToken());
            if (find(city) != start) {
                isPossible = false;
                break;
            }
        }

        System.out.println(isPossible ? "YES" : "NO");

    }
}
