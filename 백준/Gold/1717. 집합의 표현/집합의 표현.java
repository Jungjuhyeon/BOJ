
import java.util.*;
import java.io.*;
public class Main {
    static int[] p;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        p = new int[n+1];

        for(int i=0;i<=n;i++){
            p[i] = i;
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(a == 0){
                union(b,c);
            }
            if(a == 1){
                int bRoot = find(b);
                int cRoot = find(c);
                if(bRoot ==cRoot){
                    sb.append("YES").append("\n");
                }else{
                    sb.append("NO").append("\n");
                }
            }

        }

        System.out.println(sb);
    }

    public static int find(int i){
        if(p[i] == i )return i;
        else{
            return p[i] = find(p[i]);
        }
    }
    public static void union(int a,int b){
        int aRoot = find(a);
        int bRoot = find(b);
        p[bRoot] = aRoot;
    }
}

