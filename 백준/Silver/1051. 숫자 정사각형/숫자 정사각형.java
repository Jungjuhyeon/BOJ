
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] a = new int[N][M];

        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<M;j++){
                a[i][j] = str.charAt(j) - '0';
            }
        }
        int max = 1;

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                for(int k=1;k<M;k++){
                    int newI = i+k;
                    int newJ = j+k;
                    if(newI>=N || newJ>=M ){
                        break;
                    }
                    if(a[i][j] == a[newI][j] &&
                            a[i][j] == a[i][newJ] &&
                            a[i][j] == a[newI][newJ]){
                        max = Math.max((k+1)*(k+1),max);
                    }
                }
            }
        }
        System.out.println(max);
    }
}
