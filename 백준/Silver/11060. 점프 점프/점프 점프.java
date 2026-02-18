
import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[] a;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        a = new int[n];

        st = new StringTokenizer(br.readLine());

        for(int i=0;i<n;i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        bfs();
    }
//0: 위치, 1: 횟수
    private static void bfs(){
        boolean[] v = new boolean[n];
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0,0});
        v[0] = true;

        while(!q.isEmpty()){
            int[] ij = q.poll();
            int nextI = ij[0];
            int nextCount = ij[1];

            if(nextI == n-1) {
                System.out.println(nextCount);
                return;
            }
            for(int i=1;i<=a[nextI];i++){
                int newI = nextI+i;
                if(newI<n && !v[newI]){
                    v[newI] = true;
                    q.offer(new int[]{newI,nextCount+1});
                }
            }
        }
        System.out.println(-1);

    }
}
