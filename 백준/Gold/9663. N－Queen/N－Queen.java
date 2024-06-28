import java.io.*;
import java.util.*;

public class Main {
    static int N,ans;
    static int[] col;

    static void nqueen(int rowNo){
//        if(true){
//            가치치기
//            return;
//        }
        if(!isAvailable(rowNo-1)) return ;
        if(rowNo ==N){
            ans++;
            return;
        }
        for(int i=0;i<N;i++){
            col[rowNo] = i;
//            if(isAvailable(rowNo)) nqueen(rowNo+1); 이게 맞기도한데
            nqueen(rowNo+1);
        }
    }
    static boolean isAvailable(int rowNo ){
        for(int j=0; j<rowNo; j++){
            //Math.abs(col[rowNo]-col[j]) == Math.abs(rowNo-j) y=x가 대각선상에 있는 것을 알 수있음.
            if (col[rowNo] == col[j] || Math.abs(col[rowNo] - col[j]) == Math.abs(rowNo - j)) {
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N  = Integer.parseInt(br.readLine());
        col = new int[N];
        ans =0;

        nqueen(0);


        System.out.println(ans);



    }

}
