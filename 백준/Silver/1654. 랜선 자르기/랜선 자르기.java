import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine()," ");

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] a = new int[K];

        long right = 0;

        for(int i=0;i<K;i++){
            a[i] = Integer.parseInt(br.readLine());
            if(right<a[i]){
                right = a[i];
            }
        }
        right++;
        long left = 0;
        long count;

        while(left<right){
            long mid = (left+right)/2;
            count =0;

            for(int i=0;i< a.length;i++){
                count +=(a[i]/mid);
            }

            if(count >= N){
                left = mid+1;
            }else{
                right = mid;
            }

        }

        System.out.println(left-1);

    }
}
