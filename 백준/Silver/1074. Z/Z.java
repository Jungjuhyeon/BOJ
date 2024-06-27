import java.io.*;
import java.util.*;
public class Main {
    static int count =0,r,c;

    static void persistant(int row,int col,int size){
        if(row == r && col ==c){
                System.out.println(count);
                return;
        }


        if(r<row+size && r>=row && c<col+size && c>=col){
            int new_size = size/2;

            persistant(row,col,new_size); //1
            persistant(row,col+new_size,new_size); //2
            persistant(row+new_size,col,new_size); //3
            persistant(row+new_size,col+new_size,new_size);  //4
        }else{
            count += size*size;
        }



    }



    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N= Integer.parseInt(st.nextToken());
        r= Integer.parseInt(st.nextToken());
        c= Integer.parseInt(st.nextToken());

        int size = (int) Math.pow(2,N);

        persistant(0,0,size);


    }
}
