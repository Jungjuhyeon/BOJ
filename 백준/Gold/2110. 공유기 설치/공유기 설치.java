import java.util.*;
import java.io.*;

public class Main {
    static int[] a;
    static int N,C;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        a = new int[N];
        for(int i=0;i<N;i++){
            a[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(a);

        int left = 1;
        int right = a[N-1]-a[0] +1;

        while(left<right){
            int mid = left + (right-left)/2;

            if(check(mid)){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        System.out.println(left-1);
    }

    private static boolean check(int dist){
        int prev = a[0];
        int count =1;

        for(int i=1;i<N;i++){
            if(a[i]-prev>=dist){
                count++;
                prev = a[i];
            }
        }
        if(count>=C) return true;
        else return false;
    }
}
