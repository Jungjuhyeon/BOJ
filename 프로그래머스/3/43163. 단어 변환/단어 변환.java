import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        HashSet<String> set = new HashSet<>();
        
        for(String s : words){
            set.add(s);
        }
        
        if(!set.contains(target)){
            return 0;
        }
        return bfs(begin,target,set);
        
    }
    public int bfs(String begin, String target, HashSet<String> set){
        ArrayDeque<Name> q = new ArrayDeque<>();
        Set<String> v = new HashSet<>();
        q.offer(new Name(begin,0));
        v.add(begin);
        
        while(!q.isEmpty()){
            Name cur = q.poll();
            
            String curS = cur.s;
            int curSize = cur.size;
            
            if(curS.equals(target)){
                return curSize;
            }
            
            for(String str : set){
                int count =0;
                if(v.contains(str)) continue;
                for(int i=0;i<curS.length();i++){
                    
                    if(curS.charAt(i) != str.charAt(i)){
                        count++;
                    }
                }
                if(count ==1) {
                    q.offer(new Name(str,curSize+1));
                    v.add(str);
                }
            }
        }
        return 0;
    }  
}
    


class Name{
        String s;
        int size;
        public Name(String s, int size){
            this.s = s;
            this.size =size;
        }
}

//set으로 words 중복제거
//BFS로 1개만 다른거 뽑아서 넣고 방문처리
//넣을떄 depth 같이 넣기.
//Target찾으면 리턴