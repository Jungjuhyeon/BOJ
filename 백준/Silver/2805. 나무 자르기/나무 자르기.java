import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] v = new int[N];

        st = new StringTokenizer(br.readLine()," ");

        long right = 0;
        for(int i=0;i<N;i++){
            v[i]= Integer.parseInt(st.nextToken());
            right = Math.max(right,v[i]);
        }

        long left = 0;

        while(left+1<right){
            long sum =0;
            long mid = (left+right)/2;

            for (int i = 0; i < N; i++) {
                if (v[i] > mid) sum += v[i] - mid;
            }

            if(sum>=M){
                left =mid;
            }else{
                right =mid;
            }
        }
        System.out.println(left);
    }
}


