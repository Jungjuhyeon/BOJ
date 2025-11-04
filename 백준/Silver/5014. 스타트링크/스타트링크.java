
import java.util.*;
import java.io.*;
public class Main {
    static boolean[] v;
    static int F,G,U,D;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine()," ");

        F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        v = new boolean[F+1];
        bfs(S,0);


    }
    static void bfs(int start,int depth){
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[]{start,depth});
        v[start] = true;

        while(!dq.isEmpty()){
            int[] ij = dq.poll();
            int cur = ij[0];
            int count = ij[1];

            if(cur == G){
                System.out.println(count);
                return;
            }

            int up = cur+U;
            if(up<=F && !v[up]){
                dq.offer(new int[]{up,count+1});
                v[up] = true;
            }

            int down = cur-D;
            if( down>=1 && !v[down]){
                dq.offer(new int[]{down,count+1});
                v[down] = true;
            }
        }
        System.out.println("use the stairs");

    }
}
