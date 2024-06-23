import java.util.*;
import java.io.*;


//조합 + 방문내역 기록(나누기 위해)
public class Main {
    static int N,R=2;
    static int[][] ia;
    static boolean[] v;
    static int min =Integer.MAX_VALUE;


    static void comb(int cnt, int start){
        if(cnt == N/2){
            diff();
            return;
        }
        for(int i=start;i<N;i++){
            if(v[i]) continue;
            v[i] = true;
            comb(cnt+1,i+1);
            v[i] = false;

        }
    }

    static void diff(){
        int false_sum = 0;
        int true_sum =0;
        int differ =0;

        for(int i=0;i<N-1;i++){
            for(int j =i+1;j<N;j++){

                if(v[i]==true && v[j]==true){
                    true_sum += ia[i][j];
                    true_sum += ia[j][i];
                }
                else if(v[i]==false && v[j]==false){
                    false_sum += ia[i][j];
                    false_sum += ia[j][i];
                }
            }
        }
        differ = Math.abs(true_sum-false_sum);
        
         if(differ ==0){
            System.out.print(differ);
            System.exit(0);
        }



        min = Math.min(min,differ);

    }


    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        ia = new int[N][N];
        v = new boolean[N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                ia[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        comb(0,0);

        System.out.print(min);

    }
}
