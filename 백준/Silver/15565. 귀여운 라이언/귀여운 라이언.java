
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

        int start = 0;
        int count = 0;
        int min = Integer.MAX_VALUE;

        for(int end=0;end<N;end++){
            if(a[end]==1) count++;

            while(count>=K){
                min = Math.min(min,end-start+1);
                if(a[start]==1)count--;
                start++;
            }
        }


        if(min == Integer.MAX_VALUE){
            System.out.println(-1);
        }else {
            System.out.println(min);
        }


    }
}
