
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] a = new int[N];

        st= new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            a[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);

        int start = 0;
        int end = N-1;
        int count = 0;
        int sum = 0;
        while(start<end){
            sum = a[start]+a[end];

            if(sum == M){
                count++;
                start++;
                end--;
            }
            else if(sum<M){
                start++;
            }else{
                end--;
            }
        }

        System.out.println(count);
    }
}
