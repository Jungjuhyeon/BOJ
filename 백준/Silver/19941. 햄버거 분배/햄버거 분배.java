
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        String[] arr = new String[N];
        boolean[] v = new boolean[N];

        String input = br.readLine();
        for(int i=0;i<N;i++){
            String c = input.charAt(i)+"";
            arr[i] = c;
        }

        int answer =0;

        for(int i=0;i<N;i++){
            if(arr[i].equals("P")){
                for(int j =-K;j<=K;j++){
                    int idx = i+j;
                    if(idx>=0 && idx<N && !v[idx]&& arr[idx].equals("H") ){

                        answer++;
                        v[idx] = true;
                        break;
                    }
                }
            }
        }

        System.out.println(answer);
    }
}

//HHPHPPHHPPHPPPHPHPHP
// 1 3  67  0   4 6 8
