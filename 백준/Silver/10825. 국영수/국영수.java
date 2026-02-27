
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        String[][] arg = new String[N][4];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            arg[i][0] = st.nextToken();
            arg[i][1] = st.nextToken();
            arg[i][2] = st.nextToken();
            arg[i][3] = st.nextToken();
        }

        Arrays.sort(arg,(a,b)->
        {
            int korA = Integer.parseInt(a[1]);
            int korB = Integer.parseInt(b[1]);
            int engA = Integer.parseInt(a[2]);
            int engB = Integer.parseInt(b[2]);
            int mathA = Integer.parseInt(a[3]);
            int mathB = Integer.parseInt(b[3]);

            if(korA != korB) return korB - korA;          // 국어 내림차순
            if(engA != engB) return engA - engB;          // 영어 오름차순
            if(mathA != mathB) return mathB - mathA;      // 수학 내림차순
            return a[0].compareTo(b[0]);                  // 이름 사전순
        });

        for(int i=0;i<N;i++){
            System.out.println(arg[i][0]);
        }
    }
}
