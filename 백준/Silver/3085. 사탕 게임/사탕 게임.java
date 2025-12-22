
import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static char[][] a;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        a = new char[N][N];

        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<N;j++){
                a[i][j] = str.charAt(j);
            }
        }
        int max = 0;

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++) {
                if (j+1<N && a[i][j] != a[i][j + 1]) {
                    swap(i, j, i, j + 1);
                    int count = check();
                    max = Math.max(count, max);
                    swap(i, j, i, j + 1);

                }
                if (i + 1 < N && a[i][j] != a[i + 1][j]) {
                    swap(i, j, i + 1, j);
                    int count = check();
                    max = Math.max(count, max);
                    swap(i, j, i + 1, j);
                }
            }
        }
        System.out.println(max);

    }
    public static int check(){
        int max = 1;
        for(int i=0;i<N;i++){
            int count =1;
            for(int j=0;j<N-1;j++){
                if(a[i][j] == a[i][j+1]){
                    count++;
                }else{
                    count =1;
                }
                max = Math.max(count,max);
            }
        }

        for(int i=0;i<N;i++){
            int count =1;
            for(int j=0;j<N-1;j++){
                if(a[j][i] == a[j+1][i]){
                    count++;
                }else{
                    count =1;
                }
                max = Math.max(count,max);
            }
        }

        return max;
    }
    static void swap(int x1, int y1, int x2, int y2) {
        char temp = a[x1][y1];
        a[x1][y1] = a[x2][y2];
        a[x2][y2] = temp;
    }
}
