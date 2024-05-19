import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String N = br.readLine();
        long[] dp = new long[N.length()+1];

        dp[0] = 1;
        dp[1] = 1;

        if(N.charAt(0) == '0'){
            System.out.println(0);
            return;
        }
        else{
            for(int i =2; i<=N.length();i++){
                if(N.charAt(i-1) == '0'){
                    if(N.charAt(i-2) =='1' || N.charAt(i-2) =='2' ){
                        dp[i] = dp[i-2]%1000000;
                    }else{
                        System.out.println(0);
                        return;
                    }
                }else{

                    int number = Integer.parseInt(N.substring(i - 2, i));
                    if(number > 9 && number < 27){
                        dp[i] = (dp[i-1]+dp[i-2])%1000000;
                    }else if(number<=9){
                        dp[i] = dp[i-1]%1000000;
                    }else{
                        dp[i] = dp[i-1]%1000000;}

                }
            }
        }
        System.out.println(dp[N.length()]);
    }
}
