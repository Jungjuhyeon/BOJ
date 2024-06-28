import java.io.*;
import java.util.*;

public class Main {
    static int N,R=6;
    static int[] a,b;
    static StringBuilder sb = new StringBuilder();

    static void subs(int cnt,int start){

        if(cnt == R){
            for(int i=0; i<b.length;i++){
                sb.append(b[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=start;i<N;i++){
            b[cnt] = a[i];
            subs(cnt+1,i+1);

        }
    }

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            if( N ==0 ) break;
            a = new int[N];
            b = new int[R];

            for(int i=0;i<N;i++){
                a[i] = Integer.parseInt(st.nextToken());
            }

//           System.out.println(Arrays.toString(a));

            subs(0,0);
            sb.append("\n");
        }
        System.out.println(sb);

    }
}
