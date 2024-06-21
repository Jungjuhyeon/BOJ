import java.io.*;
import java.util.*;

public class Main {
    static int[] ia;
    static int[] b = new int[7];
    static int sum;

    static void comb(int cnt,int start){
        sum =0;
        if(cnt ==7){
            for(int i=0;i<7;i++){
                sum+=b[i];
            }
            return;
        }
        for(int i=start ; i<9 ; i++){
            b[cnt] = ia[i];
            comb(cnt+1,i+1);
            if(sum==100) {
                return;
            }
        }
    }

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        ia = new int[9];

        for(int i=0;i<9;i++){
            ia[i] = Integer.parseInt( br.readLine());
        }
        comb(0,0);

        for(int i=0;i<7;i++){
            sb.append(b[i]).append("\n");
        }

        System.out.print(sb);


    }
}
