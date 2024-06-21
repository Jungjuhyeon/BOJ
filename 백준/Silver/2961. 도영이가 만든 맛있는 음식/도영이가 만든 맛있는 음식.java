import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static int[][] ai;

    static int total =Integer.MAX_VALUE;

    static int count=0;
    static void subs(int cnt,int sin_sum,int sun_sum){

        if(cnt ==N){
            if(sin_sum==1&&sun_sum==0) return;
            int sub = Math.abs(sin_sum-sun_sum);
            total = Math.min(total,sub);
            return;
        }


        subs(cnt + 1, sin_sum*ai[cnt][0],sun_sum+ai[cnt][1]); //선택

        subs(cnt + 1, sin_sum,sun_sum); //선택 x



    }



    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        ai = new int[N][2];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            ai[i][0] = Integer.parseInt(st.nextToken());
            ai[i][1] = Integer.parseInt(st.nextToken());
        }
        subs(0,1,0);


        System.out.print(total);
    }
}
