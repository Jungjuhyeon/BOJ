import java.util.*;
import java.io.*;

public class Main {
    static int white,blue =0;
    static int[][] ia;

    static void partition(int row,int col,int size){

        if(colorCheck(row,col,size)){
            if(ia[row][col] == 0){
                white++;
            }else{
                blue++;
            }
            return;

        }
        int new_size = size/2;

        partition(row,col,new_size); //1
        partition(row,col+new_size,new_size); //2
        partition(row+new_size,col,new_size); //3
        partition(row+new_size,col+new_size,new_size); //4


    }
    static boolean colorCheck(int row,int col,int size){
        int color = ia[row][col];

        for(int i=row; i<row+size;i++){
            for(int j=col;j<col +size ; j++){
                if(ia[i][j] != color){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        ia = new int[N][N];

        for(int i=0;i<N;i++){
            st= new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                ia[i][j] = Integer.parseInt(st.nextToken());
            }
//            System.out.println(Arrays.toString(ia[i]));
        }

        partition(0,0,N);

        System.out.println(white);
        System.out.println(blue);




    }
}
