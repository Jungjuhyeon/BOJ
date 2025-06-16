
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken());
        int score = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int rank =1;
        int count =0;
        if(N!=0) {
            st = new StringTokenizer(br.readLine()," ");

            for (int i = 0; i < N; i++) {
                int num = Integer.parseInt(st.nextToken());
                if (num > score) {
                    rank++;
                    count++;
                } else if (num == score) {
                    count++;
                } else {
                    break;
                }
            }
        }
        count++;

        if(count >P){
            System.out.println(-1);
        }else{
            System.out.println(rank);
        }




    }
}
