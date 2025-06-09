
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String st = br.readLine();
            if(st.equals("end")) break;
            if (!checkMo(st)) {
                sb.append("<").append(st).append(">").append(" is not acceptable.").append("\n");
                continue;
            }
            boolean isAcceptable = true;

            if (st.length() >= 3) {
                for (int i = 0; i < st.length() - 2; i++) {
                    int check = 0;
                    String s1 = st.charAt(i) + "";
                    String s2 = st.charAt(i + 1) + "";
                    String s3 = st.charAt(i + 2) + "";
                    if (checkMo(s1)) check++;
                    if (checkMo(s2)) check++;
                    if (checkMo(s3)) check++;

                    if (check == 3 || check == 0) {
                        isAcceptable = false;
                        break;
                    }
                    if(s1.equals(s2) && !s1.equals("e") && !s1.equals("o")){
                        isAcceptable = false;
                        break;
                    }
                    if(s2.equals(s3) && !s2.equals("e") && !s2.equals("o")){
                        isAcceptable = false;
                        break;
                    }
                }
            }
            if(st.length()==2){
                String s1 = st.charAt(0) + "";
                String s2 = st.charAt(1) + "";
                if(s1.equals(s2) && !s1.equals("e") && !s1.equals("o")){
                    isAcceptable = false;
                    continue;
                }
            }

            if(isAcceptable){
                sb.append("<").append(st).append(">").append(" is acceptable.").append("\n");
            }else{
                sb.append("<").append(st).append(">").append(" is not acceptable.").append("\n");

            }
        }
        System.out.println(sb);

    }
    public static boolean checkMo(String str){
        return (str.contains("a") ||str.contains("e") ||str.contains("i") ||str.contains("o") ||str.contains("u"));
    }
}
