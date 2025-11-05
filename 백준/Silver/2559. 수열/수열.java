
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] a = new int[N];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            a[i] = Integer.parseInt(st.nextToken());
        }

        int sum=0;
        int count =0;
        int max = Integer.MIN_VALUE;

        for(int i=0;i<N;i++){
            sum += a[i];
            count++;

            if(count>=K){
                max = Math.max(max,sum);
                sum -= a[i-K+1];
                count--;
            }
        }
        System.out.println(max);

    }
}
