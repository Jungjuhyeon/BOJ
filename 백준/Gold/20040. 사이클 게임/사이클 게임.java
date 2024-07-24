import java.io.*;
import java.util.*;

public class Main {
    static int n,m;
    static int[] parent;

    static int find(int i){
        if(parent[i]==i) return i;
        else{
           return parent[i] =find(parent[i]);
        }
    }
    static void union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);
        parent[bRoot]= aRoot;
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        parent = new int[n];
        for(int i=0;i<n;i++){
            parent[i] =i;
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a= Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(find(a)==find(b)) {
                System.out.println(i+1);
                return;
            }else {
                union(a,b);
            }
        }
        System.out.println(0);
    }
}
