
import java.io.*;
import java.util.*;

public class Main {
    static int[] a;
    static boolean[] v = new boolean[101];
    public static void main(String[] args)throws Exception{
        BufferedReader br  =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        a = new int[101];
        for(int i=0;i<N+M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a1 = Integer.parseInt(st.nextToken());
            int a2 = Integer.parseInt(st.nextToken());
            a[a1] = a2;
        }
        int answer = bfs();
        System.out.println(answer);
    }

    public static int bfs(){
        ArrayDeque<int[]> q = new ArrayDeque<>();

        q.offer(new int[]{1,0});
        v[1] = true;
        int len = 0;

        while(!q.isEmpty()){
            int[] ij = q.poll();
            int curI = ij[0];
            int curLen = ij[1];

            if(curI ==100){
                return curLen;
            }

            for(int i=1;i<=6;i++){
                int ni = curI+ i;
                if(ni>=1 && ni<101 && !v[ni]){
                    if(a[ni]==0){
                        q.offer(new int[]{ni,curLen+1});
                        v[ni] = true;
                    }else{
                        q.offer(new int[]{a[ni],curLen+1});
                        v[ni] = true;
                    }
                }
            }
        }
        return -1;
    }
}
