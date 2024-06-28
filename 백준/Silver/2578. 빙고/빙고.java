import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[][] ia = new int[5][5];

        for(int i=0;i<5;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<5;j++){
                ia[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] row_count = new int[5];
        int[] col_count = new int[5];
        int d=0;
        int d1=0;
        int bingo =0;

        outerLoop: while(true){
            for(int i=0;i<5;i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<5;j++) {
                    int n = Integer.parseInt(st.nextToken());

                    for(int row =0;row<5;row++){
                        for(int col=0;col<5;col++){
                            if(ia[row][col] == n){
                                row_count[row] +=1;
                                col_count[col] +=1;
                                if( row == col){
                                    d +=1;
                                    if(row==2){
                                        d1+=1;
                                    }
                                }else if(row+col ==4){
                                    d1+=1;
                                }
                            }
                            if(row_count[row] ==5){
                                bingo++;
                                row_count[row] = 0;
                            }
                            if(col_count[col] ==5){
                                bingo++;
                                col_count[col] =0;
                            }
                            if(d1==5){
                                bingo++;
                                d1 =0;
                            }
                            if(d==5){
                                bingo++;
                                d =0;
                            }

                                if( bingo >=3){
                                    System.out.println((i)*5 + (j+1));
                                    break outerLoop ;
                                }
                        }
                    }


                }
            }

        }


    }
}
