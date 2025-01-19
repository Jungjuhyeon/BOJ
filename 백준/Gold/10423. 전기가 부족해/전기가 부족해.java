
import java.io.*;
import java.util.*;

public class Main {

    static int[] p;
    static int[][] g;
    static int N;
   public static void main(String[] args)throws Exception{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st;

       st = new StringTokenizer(br.readLine()," ");

       N = Integer.parseInt(st.nextToken());
       int M = Integer.parseInt(st.nextToken());
       int K = Integer.parseInt(st.nextToken());

       p = new int[N+1];
       g = new int[M][3];

       for(int i=1;i<N+1;i++){
           p[i] =i;
       }

       st = new StringTokenizer(br.readLine()," ");
       for(int i=0;i<K;i++){
           int k = Integer.parseInt(st.nextToken());
           p[k] = -1;
       }

       for(int i=0;i<M;i++){
           st = new StringTokenizer(br.readLine()," ");
           int u = Integer.parseInt(st.nextToken());
           int v = Integer.parseInt(st.nextToken());
           int w = Integer.parseInt(st.nextToken());
            g[i] = new int[]{u,v,w};
       }

       Arrays.sort(g,(a,b)->Integer.compare(a[2],b[2]));

       int total = 0;
       int edge = 0;
       for(int [] e: g){
           if(union(e[0],e[1])){
               total += e[2];
               edge++;
           }
           if(isAllConnect()){
               break;
           }
       }
       br.close();
       System.out.println(total);
   }
   static int find(int a){
       if(p[a] == -1){
           return -1;
       }
       if(p[a] != a){
           p[a] = find(p[a]);
       }
       return p[a];
   }
   static boolean union(int a,int b){
       int rootA = find(a);
       int rootB = find(b);

       if(rootA != rootB){
           if(rootA == -1){
               p[rootB] = rootA;
           }else if(rootB == -1){
               p[rootA] = rootB;
           }
           else {
               if(rootA>rootB){
                   p[rootA] = rootB;
               }else{
                   p[rootB] = rootA;
               }
           }
           return true;
       }
       return false;
   }
    // 모든 도시가 전부 연결되었는지 확인하는 메소드
    private static boolean isAllConnect() {
        for (int i = 1; i < N + 1; i++) {
            if (p[i] != -1) {
                return false;
            }
        }
        return true;
    }
}
