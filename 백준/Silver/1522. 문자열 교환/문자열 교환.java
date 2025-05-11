
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        char[] c = new char[input.length()];

        int count =0;

        for(int i=0;i<input.length();i++){
            c[i] = input.charAt(i);
            if(c[i] == 'a'){
                count++;
            }
        }

        int bCount =0;
        //초기세팅
        for(int i=0;i<count;i++){
            if(c[i] == 'b'){
                bCount++;
            }
        }

        int min = bCount;

        for(int i=1;i<input.length();i++){

            int remove = c[i-1];
            if(remove == 'b') bCount--;

            int add = c[(i+count-1)%input.length()];
            if(add == 'b') bCount++;

            min = Math.min(bCount,min);
        }

        System.out.println(min);


    }
}
