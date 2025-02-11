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
        S = Integer.parseInt(st.nextToken()); //합했을댸 구하는 값

        a = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<N;i++){
            int num = Integer.parseInt(st.nextToken());
            a[i] = num;
        }

        sub(0,0);

        br.close();

        if(S==0){
            System.out.println(count-1);
        }else{
            System.out.println(count);

        }

    }

    static void sub(int depth,int sum){
        if(depth == N){
            if(sum == S){
                count++;
            }
            return;
        }
        sub(depth+1,sum+a[depth]); //포함했을 경우
        sub(depth+1,sum); //포함안했을경우
    }
}
