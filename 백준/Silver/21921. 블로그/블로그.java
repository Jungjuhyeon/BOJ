
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] ar = new int[N];

        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            int num = Integer.parseInt(st.nextToken());
            ar[i] = num;
        }

        int count =1;
        int sum = 0;

        for(int i=0;i<X;i++){
            sum += ar[i];
        }
        int max = sum;

        for(int i=1;i<=ar.length-X;i++){
            sum -= ar[i-1];
            sum += ar[i+X-1];

            if(sum == max){
                count++;
            } else if(sum > max){
                max = sum;
                count =1;
            }
        }


        if(max ==0){
            System.out.println("SAD");
        }else{
            System.out.println(max);
            System.out.println(count);
        }
    }
}
