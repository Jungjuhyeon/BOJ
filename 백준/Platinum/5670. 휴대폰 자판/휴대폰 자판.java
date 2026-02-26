
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;

        while((line=br.readLine()) !=null){
            Trie trie = new Trie();
            int N = Integer.parseInt(line);
            String[] arg = new String[N];
            for(int i=0;i<N;i++){
                String word = br.readLine();
                arg[i] = word;
                trie.insert(word);
            }
            float sum = 0f;
            for(int i=0;i<N;i++){
                int num = trie.search(arg[i]);
                sum+=num;
            }
            float answer = (sum/N);
            System.out.printf("%.2f\n",answer);
        }
    }

    static class TrieNode{
        Map<Character,TrieNode> child = new HashMap<>();
        boolean isEnd;
    }
    static class Trie{
        TrieNode root = new TrieNode();

        public void insert(String word){
            TrieNode node = root;
            for(char c : word.toCharArray()){
                node = node.child.computeIfAbsent(c,k->new TrieNode());
            }
            node.isEnd = true;
        }
        public int search(String word){
            TrieNode node = root;
            int count =0;
            int idx =0;
            for(char c : word.toCharArray()){
                if(idx ==0 || node.child.size() > 1 || node.isEnd){
                    count++;
                }
                node = node.child.get(c);
                idx++;
            }
            return count;
        }
    }
}
