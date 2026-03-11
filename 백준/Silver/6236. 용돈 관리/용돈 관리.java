
import java.util.*;
import java.io.*;

public class Main {
    static int N,M;
    static int[] a;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        a = new int[N];
        int max =0;
        for(int i=0;i<N;i++){
            a[i] = Integer.parseInt(br.readLine());
            max = Math.max(a[i],max);
        }
        int sum = 0;
        for(int i=0;i<N;i++){
            sum += a[i];
        }
        int left =max;
        int right=sum;

        while(left<right){
            int mid = left+ (right-left)/2;

            int count = count(mid);

            if(count <= M){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        System.out.println(left);

    }
    private static int count(int money){
        int count = 1;
        int remindMoney = money;

        for(int i=0;i<N;i++){
            if(remindMoney>=a[i]){
                remindMoney = remindMoney-a[i];
            }
            else{
                remindMoney = money-a[i];
                count++;
            }
        }
        return count;
    }
}
