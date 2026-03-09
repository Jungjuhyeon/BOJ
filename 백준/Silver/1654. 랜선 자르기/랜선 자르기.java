
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] a = new int[N];
        long max = 0;
        for(int i=0;i<N;i++){
            int num = Integer.parseInt(br.readLine());
            a[i] = num;
            max = Math.max(max,num);
        }

        long left = 1;
        long right = max;
        right++;

        while(left < right){
            long mid = left + (right - left) / 2;
            long sum = 0;

            for(int num : a){
                sum += num / mid;
            }

            if(sum >= M){
                left = mid + 1;
            }else{
                right = mid;
            }
        }

        System.out.println(left - 1);

    }
}

