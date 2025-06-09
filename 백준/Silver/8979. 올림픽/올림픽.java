
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][4];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");

            int num = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int dong =Integer.parseInt(st.nextToken());
            arr[i][0] = num;
            arr[i][1] = gold;
            arr[i][2] = silver;
            arr[i][3] = dong;

        }

        Arrays.sort(arr, (a,b) ->{
            int gold = Integer.compare(b[1],a[1]);
            if(gold !=0) return gold;

            int cmpSilver = Integer.compare(b[2], a[2]); // 은 내림차순
            if (cmpSilver != 0) return cmpSilver;

            return Integer.compare(b[3], a[3]);          // 동 내림차순
        });

        int rank = 1;
        for(int i=0;i<N;i++){
            if(arr[i][0] == K){
                System.out.println(rank);
                break;
            }

            if(i>0 && (arr[i-1][1] != arr[i][1]
            || arr[i-1][2] != arr[i][2]
            || arr[i-1][3] != arr[i][3])){
                rank +=1;
            }
        }

    }
}
