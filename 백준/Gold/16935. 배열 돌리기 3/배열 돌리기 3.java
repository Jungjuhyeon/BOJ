import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws Exception{
        //System.setIn(new FileInputStream("res/input_bj_16935.txt")); //이를 사용하자

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[][] ar = new int[N][M];

        //배열 입력
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M;j++){
                ar[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine()," ");

        for(int i=0;i<R;i++){
            int a = Integer.parseInt(st.nextToken());
            if(a == 1){  //상하 반전
                for(int j=0; j<N/2;j++){
                    int[] refect = ar[j];
                    ar[j] = ar[N-j-1];
                    ar[N-j-1] = refect;

                }
            }else if(a == 2){ //좌우반전
                for(int j=0; j< N;j++){
                    for(int k=0; k<M/2;k++){
                        int c = ar[j][k];
                        ar[j][k] = ar[j][M-k-1];
                        ar[j][M-k-1] = c;
                    }
                }
            }else if(a==3){
                int[][] newsar = new int[M][N];
                for(int j=0; j<N;j++){
                    for(int k=0; k<M;k++){
                        newsar[k][N-j-1] =ar[j][k];
                    }
                }
                ar = newsar;
                int temp = N;
                N = M;
                M = temp;

            }else if(a==4){
                int[][] newsar = new int[M][N];
                for(int j=0; j<N;j++){
                    for(int k=M-1; k>=0;k--){
                        newsar[M-k-1][j] =ar[j][k];
                    }
                }
                ar = newsar;
                int temp = N;
                N = M;
                M = temp;
            }
            else if(a==5){
                int[][] newsar = new int[N][M];
                for(int j=0;j<N/2;j++){
                    for(int k=0;k<M/2;k++){
                        newsar[j][k+M/2]= ar[j][k];
                        newsar[j+N/2][k+M/2] = ar[j][k+M/2];
                        newsar[j+N/2][k] = ar[j+N/2][k+M/2];
                        newsar[j][k] = ar[j+N/2][k];
                    }
                }
                ar = newsar;
            }
            else if(a==6){
                int[][] newsar = new int[N][M];
                for(int j=0;j<N/2;j++){
                    for(int k=0;k<M/2;k++){
                        newsar[j+N/2][k]= ar[j][k];
                        newsar[j+N/2][k+M/2] = ar[j+N/2][k];
                        newsar[j][k+M/2] = ar[j+N/2][k+M/2];
                        newsar[j][k] = ar[j][k+M/2];
                    }
                }
                ar = newsar;

            }
        }


        for(int i=0; i<N;i++) {
            for(int j=0;j<M;j++){
                sb.append(ar[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);

    }
}
