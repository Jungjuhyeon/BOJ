
import java.util.*;
import java.io.*;
public class Main {
    static int len;
    static String str;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();

        len = str.length();
        int answer =0;

        for(int i=0;i<len;i++){
            if(pal(i,len-1)){
                answer = len+i;
                break;
            }
        }
        System.out.println(answer);
    }

    private static boolean pal(int left,int right){
        while(left<=right){
            if(str.charAt(left) != str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
