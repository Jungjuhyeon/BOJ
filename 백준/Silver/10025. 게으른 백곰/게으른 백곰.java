
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] a = new int[1000001];
        int maxIdx = 0;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            int g = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            a[x] = g;
            maxIdx = Math.max(x,maxIdx);
        }

        int max = 0;
        int sum= 0;
        int start =0;

        for(int end=0;end<=maxIdx;end++){
            sum += a[end];

            if(end-start> 2*K){
                sum -= a[start];
                start++;
            }
            max = Math.max(sum,max);

        }
        System.out.println(max);
    }
}
