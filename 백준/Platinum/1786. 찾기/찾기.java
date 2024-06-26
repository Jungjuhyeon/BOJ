import java.io.*;
import java.util.*;

public class Main {

    static String t,p;
    static int[] F;
    static List<Integer> ans =new ArrayList<>();

    static void makeTable(){

        int idx =0; // 패턴의 현재 위치를 가리키는 인덱스

        for(int i=1; i<p.length(); i++){
            // 패턴의 문자가 일치하지 않을 때, idx를 F 값으로 갱신
            while(idx>0 && p.charAt(i)!=p.charAt(idx)){
                idx = F[idx-1];
            }
            // 패턴의 문자가 일치할 때, idx를 증가시키고 F에 값 설정
            if(p.charAt(i)==p.charAt(idx)){
                F[i]=++idx;
            }
        }
    }
    static void solve(){

        int idx = 0;

        for(int i=0; i<t.length(); i++){

            while(idx>0 && t.charAt(i)!=p.charAt(idx)){// 텍스트와 패턴의 문자가 일치하지 않을 때 idx를 F 값으로 갱신
                idx = F[idx-1];
            }
            if(t.charAt(i)==p.charAt(idx)) { // 텍스트와 패턴의 문자가 일치할 때
                if (idx == p.length() - 1) { //패턴의 끝에 도착했을떄,
                    ans.add(i-idx+1);
                    idx = F[idx]; // idx를 실패 F 값으로 갱신
                } else {
                    idx += 1; // idx를 증가시켜 계속 탐색
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