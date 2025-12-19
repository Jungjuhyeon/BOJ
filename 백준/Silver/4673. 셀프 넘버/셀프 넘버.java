
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws Exception{
        Set<Integer> set = new HashSet<>();

        for(int i=1;i<10000;i++){
            String num = String.valueOf(i);
            int len = num.length();
            int n = i;
            for(int j=0;j<len;j++){
                n += num.charAt(j) - '0';
            }
//            System.out.println(n);
            set.add(n);
            if(!set.contains(i)){
                System.out.println(i);
            }
        }
    }
}
