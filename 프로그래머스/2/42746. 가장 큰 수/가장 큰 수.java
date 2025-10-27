import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        
        String[] strArr = new String[numbers.length];
        for(int i=0 ; i<numbers.length ; i++){
            strArr[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(strArr, (a,b) -> (b+a).compareTo(a+b));
        
        if(strArr[0].equals("0")) return "0";
        
        StringBuilder sb = new StringBuilder();
        
        for(String str : strArr){
            sb.append(str);
        }
        return sb.toString();
        
    }
    
}


//     static int R;
//     static boolean[] v;
//     static HashSet<String> set = new HashSet<>();
    
//     public String solution(int[] numbers) {
        
//         R = numbers.length;
//         v = new boolean[R];
        
//         perm(0,numbers,"");
        
//         List<Long> list = new ArrayList<>();
        
//         for(String str: set){
//             list.add(Long.valueOf(str));
//         }
        
//         Collections.sort(list, (a,b) -> Long.compare(b,a));
        
//         String answer = String.valueOf(list.get(0));

//         return answer;
//     }
    
//     public static void perm(int cnt,int[] numbers,String str){
        
//         if(cnt == R){
//             set.add(str);
//             return;
//         }
        
//         for(int i=0;i<R;i++){
//             if(v[i]) continue;
//             v[i] = true;
//             perm(cnt+1,numbers,str+ String.valueOf(numbers[i]));
//             v[i] =false;
//         }
//     }


//조합 -> HashSet
//HashSet -> Array 정렬(오름차순)
// Array[0] 정답.
