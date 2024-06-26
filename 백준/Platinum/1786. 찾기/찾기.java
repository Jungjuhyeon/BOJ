import java.io.*;
import java.util.*;

public class Main {

    static String t,p;
    static int[] F;
    static List<Integer> ans =new ArrayList<>();


    static void makeTable(){
        int n = p.length();

        int idx =0;

        for(int i=1; i<n; i++){
            while(idx>0 && p.charAt(i)!=p.charAt(idx)){
                idx = F[idx-1];
            }

            if(p.charAt(i)==p.charAt(idx)){
                F[i]=++idx;
            }
        }
    }
    static void solve(){

        int idx = 0;
        for(int i=0; i<t.length(); i++){
            while(idx>0 && t.charAt(i)!=p.charAt(idx)){
                idx = F[idx-1];
            }
            if(t.charAt(i)==p.charAt(idx)) {
                if (idx == p.length() - 1) { //패턴의 끝에 도착했을떄,
                    ans.add(i-idx+1);
                    idx = F[idx];
                } else {
                    idx += 1;
                }
            }
        }
    }

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        t = br.readLine();
        p = br.readLine();

        F = new int[p.length()];

        makeTable();
        solve();

        System.out.println(ans.size());

        for(Integer answer: ans){
            System.out.println(answer);
        }
    }
}
