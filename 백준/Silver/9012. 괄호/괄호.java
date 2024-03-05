import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int count = 0;

        for(int i =0; i<N ; i++){
            String str = br.readLine();

            if(str.charAt(0) == '('){
                count =1;
                int l = str.length();

                for(int j=1 ;j <l;j++){
                    if(str.charAt(j) == '('){
                        count++;
                    }
                    else if(count == 0){
                        count = 100; //NO를 주기 위함.
                        break;
                    }
                    else{
                        count--;
                    }
                }
                if(count ==0){
                    sb.append("YES");
                }else{
                    sb.append("NO");
                }
            }
            else{
                sb.append("NO");
            }
            sb.append("\n");

        }

        System.out.println(sb);

    }
}

