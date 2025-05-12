// Imagine you're playing a fantasy video game where secret level codes unlock new 
// worlds. These codes are strings made up of letters, and a level code is only 
// considered valid if every shorter code formed by its leading characters has been
// discovered along the journey. In other words, a code is unlockable only when all
// of its prefixes are also present in your collection.

// Given a list of strings representing the level codes you’ve collected, find the 
// longest valid level code such that every prefix of that code is in the list. 
// If there is more than one valid code of the same length, choose the one that 
// comes first in alphabetical order. If no such code exists, return an empty string.

// Input Format
// -------------
// Line1: Space separated codes (strings)
 
// Output Format
// --------------
// string 


// Example 1:
// ----------
// Input:
// m ma mag magi magic magici magicia magician magicw
// Output: 
// "magician"

// Explanation: The code "magician" is unlockable because every 
// prefix—"m", "ma", "mag", "magi", "magic", "magici", and "magicia"—is present in 
// the list. Although "magicw" appears too, it fails since its prefix "magica" is missing.


// Example 2:
// ----------
// Input:
// a banana app appl ap apply apple
// Output: 
// "apple"  

// Explanation: Both "apple" and "apply" have every prefix in the list, but "apple" 
// comes first in alphabetical order.

// Example 3:
// ----------
// Input: 
// abc bc ab abcd
// Output: 
// ""



package Fs_Codes.Trie;

import java.util.*;


class Node{
    Node[] nums;
    boolean isEnd;
    Node(){
        nums=new Node[26];
        isEnd=false;
    }
    
}

class Trie{
    public Node root=new Node();
    
    public String search(Set<String> set){
        List<String> res=new ArrayList<>();
        Queue<Node> q=new LinkedList<>();
        Queue<String> qs=new LinkedList<>();
        q.offer(root);
        qs.offer("");
        while(!q.isEmpty()){
            Node temp=q.poll();
            String sb=qs.poll();
            for(int i=0;i<26;i++){
                String str=sb+(char)(97+i);
                if(set.contains(str)){
                    temp.nums[i]=new Node();
                    q.offer(temp.nums[i]);
                    qs.offer(str);
                    if(res.size()==0){
                        res.add(str);
                    }else{
                        if(res.get(0).length()<str.length()){
                            res=new ArrayList<>(Arrays.asList(str));
                        }
                        if(res.get(0).length()==str.length()) res.add(str);
                    }
                }
            }
        }
        Collections.sort(res);
        return res.size()==0?"":res.get(0);
    }
}
class LongestValidCodeWithPrefix{
    public static void main(String[] args){
        String[] s=new Scanner(System.in).nextLine().split(" ");
        Set<String> set=new HashSet<>(Arrays.asList(s));
        Trie t=new Trie();
        System.out.print(t.search(set));
        
        
        
    }
}