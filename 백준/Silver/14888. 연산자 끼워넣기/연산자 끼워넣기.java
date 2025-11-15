
import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] a,yun,b;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    static boolean[] v;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        a = new int[N];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            a[i] = Integer.parseInt(st.nextToken());
        }

        yun = new int[N-1];
        st = new StringTokenizer(br.readLine()," ");
        int idx =0;
        for(int i=0;i<4;i++){
            int num = Integer.parseInt(st.nextToken());
            for(int j=0;j<num;j++){
                yun[idx++] = i;
            }
        }

        b = new int[N-1];
        v = new boolean[N-1];

        perm(0);
        System.out.println(max);
        System.out.println(min);

    }
    public static void perm(int cnt){
        if(cnt == N-1){
            int result = a[0];
            for(int i=0;i<N-1;i++){
                int op = b[i];
                int num = a[i+1];
                if(op == 0) result +=num;
                else if(op==1) result -= num;
                else if(op==2) result *= num;
                else result/=num;
            }
            min = Math.min(min,result);
            max = Math.max(max,result);
            return;
        }

        for(int i=0;i<N-1;i++){
            if(v[i]) continue;
            v[i] = true;
            b[cnt] = yun[i];
            perm(cnt+1);
            v[i] = false;
        }

    }
}
