
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine()," ");
        int[] a = new int[N];

        int max = 0;
        for(int i=0;i<N;i++){
            a[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max,a[i]);
        }

        int M = Integer.parseInt(br.readLine());

        int left = 0;
        int right = max+1;

        while(left<right){
            int mid = left+ (right-left)/2;

            int sum=0;
            for(int num:a){
                if(num>=mid){
                    sum+= mid;
                }else{
                    sum+=num;
                }
            }

            if(sum <= M){
                left = mid+1;
            }else{
                right = mid;
            }
        }

        System.out.println(left-1);
    }
}
