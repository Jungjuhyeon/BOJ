import java.io.*;
import java.util.*;
public class Main {
    static int N,M;
    static int[] a,b=new int[3];

    static int max =0;
    static int sum =0;

    static void comb(int cnt, int start){
        if(cnt ==3){
            sum =0;
            for(int i=0;i<3;i++){
                sum += b[i];
            }
            if(sum <= M) {
                max = Math.max(max, sum);
            }
            return;
        }
        ;
        for(int i=start; i<N;i++){
            b[cnt] = a[i];
            comb(cnt+1,i+1);
        }
    }

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st= new StringTokenizer(br.readLine()," ");

        a= new int[N];

        for(int i=0; i<N;i++){
            a[i] = Integer.parseInt(st.nextToken());
        }

        comb(0,0);

        System.out.print(max);

    }
}
