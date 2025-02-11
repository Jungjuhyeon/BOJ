
import java.util.*;
import java.io.*;

public class Main {
    static int N,S;
    static int[] a;
    static int count =0;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken()); //전체갯수
        S = Integer.parseInt(st.nextToken());//합했을댸 구하는 값

        a = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<N;i++){
            int num = Integer.parseInt(st.nextToken());
            a[i] = num;
        }

        sub(0,0);

        if(S==0){
            if(count>0){
                count--;
            }
        }


        br.close();

        System.out.println(count);

    }

    static void sub(int cnt,int sum){
        if(cnt == N){
            if(sum == S){
                count++;
            }
            return;
        }
        sub(cnt+1,sum+a[cnt]);
        sub(cnt+1,sum);
    }
}
