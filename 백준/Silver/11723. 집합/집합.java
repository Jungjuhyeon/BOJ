
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            String type = st.nextToken();
            if(type.equals("add")){
                int num = Integer.parseInt(st.nextToken());
                list.add(num);
            }else if(type.equals("remove")){
                int num = Integer.parseInt(st.nextToken());
                list.remove(Integer.valueOf(num));
            }else if(type.equals("check")){
                int num = Integer.parseInt(st.nextToken());
                if(list.contains(num)){
                    sb.append(1).append("\n");
                }else{
                    sb.append(0).append("\n");;
                }
            }else if(type.equals("toggle")){
                int num = Integer.parseInt(st.nextToken());
                if(list.contains(num)){
                    list.remove(Integer.valueOf(num));
                }else{
                    list.add(num);
                }
            }else if(type.equals("all")){
                list.clear();
                for(int j=1;j<21;j++){
                    list.add(j);
                }
            }else if(type.equals("empty")){
                list.clear();
            }
        }

        System.out.println(sb);
    }
}
