
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] a = new int[N];

        st = new StringTokenizer(br.readLine()," ");

        int left = 0;
        int right = -1;

        for(int i=0;i<N;i++) {
            a[i] = Integer.parseInt(st.nextToken());
            right = Math.max(right, a[i]);
        }
        while(left<=right){
            int mid = (left+ right)/2;
            long tree = 0;
            for(int i=0;i<N;i++){
                if(a[i]>mid) tree+= a[i]-mid;
            }
            if(tree>=M){
                left = mid+1;
            }else if(tree<M){
                right = mid -1;
            }
        }
        System.out.println(right);
    }
}
