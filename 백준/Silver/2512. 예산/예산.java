
import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static int[] a;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        a = new int[N];

        st = new StringTokenizer(br.readLine()," ");

        int high = 0;
        int total = 0;

        for(int i=0;i<N;i++){
            a[i] = Integer.parseInt(st.nextToken());
            high = Math.max(high,a[i]);
            total = total+a[i];
        }

        int max = Integer.parseInt(br.readLine()); //총예산

        if(total<=max){
            System.out.println(high);
            return;
        }

        int low = 1;

        while(low < high-1){
            int mid = (low+high)/2;

            if(f(mid)>max){
                high = mid;
            }else{
                low =mid;
            }

        }

        br.close();
        System.out.println(low);


    }

    static int f(int h){
        int total =0;
        for(int i=0;i<N;i++){
            total += Math.min(h,a[i]);
        }
        return total;
    }
}
