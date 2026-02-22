
import java.util.*;
import java.io.*;

public class Main {
    static int start,end,stEnd,answer =0 ;
    static Set<String> set;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        line = br.readLine();
        String[] part = line.split(" ");

        start = Integer.parseInt(part[0].substring(0,2) + part[0].substring(3,5));
        end = Integer.parseInt(part[1].substring(0,2) + part[1].substring(3,5));
        stEnd = Integer.parseInt(part[2].substring(0,2) + part[2].substring(3,5));

        set = new HashSet<>();

        while((line = br.readLine()) != null){
            String[] parts = line.split(" ");
            int time = Integer.parseInt(parts[0].substring(0,2) + parts[0].substring(3,5));
            String name = parts[1];
            count(time,name);
        }
        System.out.println(answer);
    }
    private static void count(int time, String name){
        if(time <= start){
            set.add(name);
        }
        else if(time >= end && time <= stEnd){
            if(set.remove(name)){
                answer++;
            }
        }
    }
}
