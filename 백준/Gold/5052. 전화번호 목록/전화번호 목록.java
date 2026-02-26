
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while(t-->0){
            Trie trie = new Trie();
            int n = Integer.parseInt(br.readLine());
            boolean answer = true;
            for(int i=0;i<n;i++){
                String s = br.readLine();
                if(answer && !trie.insert(s)){
                    answer = false;
                }
            }
            System.out.println(answer ? "YES" : "NO");
        }
    }

    static class TrieNode{
        Map<Character,TrieNode> child = new HashMap<>();
        boolean isEnd;
    }

    static class Trie{

        TrieNode root = new TrieNode();

        public boolean insert(String word){
            TrieNode node = root;
            for(char c : word.toCharArray()){
                if(node.isEnd) return false;
                node = node.child.computeIfAbsent(c,k-> new TrieNode());
            }

            if(!node.child.isEmpty()) return false;
            node.isEnd = true;
            return true;
        }

    }
}
