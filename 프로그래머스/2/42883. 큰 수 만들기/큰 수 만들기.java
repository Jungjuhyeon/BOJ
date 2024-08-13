class Solution {
    public String solution(String number, int k) {
        
        StringBuilder sb = new StringBuilder();
        int max =0;
        int idx =0;
        
        for(int i=0;i<number.length()-k;i++){
           max =0;
            for(int j=idx;j<=k+i;j++){
                if(max<number.charAt(j)-'0'){
                    max = number.charAt(j)-'0';
                    idx = j+1;
                }
            }
            sb.append(max);
        }
        
        return sb.toString();
        
        
    }
}

//ㅈ같은 문제다.
// 1. number.length()-k 길이만큼 숫자를 뽑아내야한다.
// 2. 범위내에서 한개를 선택해도 뒤에 숫자와 합쳐서 number.length()-k와 같아져야한다. 이를 잘 봐야한다