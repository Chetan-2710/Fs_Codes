package Fs_Codes.Trie;

// Imagine you're a digital security analyst reviewing a suspicious email. The email’s 
// content is a continuous string of characters, and you have a list of keywords 
// commonly used in phishing scams. Your mission is to scan the email text and flag 
// every segment that exactly matches one of these keywords. In other words, identify 
// all index pairs [i, j] such that the substring from position i to j in the email 
// text is one of the suspicious keywords. Return these pairs sorted by their starting 
// index, and if two pairs share the same starting index, sort them by their ending index.

// Input Format
// ------------
// Line-1: string STR(without any space)
// Line-2: space separated strings, suspicious keywords[]

// Output Format
// -------------
// Print the pairs[i, j] in sorted order.


// Example 1:
// ----------
// Input:  
// cybersecuritybreachalert
// breach alert cyber

// Output: 
// 0 4
// 13 18
// 19 23

// Example 2:
// ----------
// Input:  
// phishphishingphish
// phish phishing

// Output:
// 0 4
// 5 9
// 5 12
// 13 17


// Explanation: Notice that keywords can overlap—for instance, the word "phish" appears 
// as part of the substring [5,9] in addition to the complete "phishing" substring [5,12].

// Constraints:

// - 1 <= emailText.length <= 100  
// - 1 <= suspiciousWords.length <= 20  
// - 1 <= suspiciousWords[i].length <= 50  
// - emailText and each suspicious word consist of lowercase English letters.  
// - All suspicious words are unique.



import java.util.*;

class CheckKeyWords{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        String s=sc.nextLine();
        String[] keys=sc.nextLine().split(" ");

        Trie t=new Trie();
        // TrieNode root=t.root;
        for(String x:keys){
            t.insert(x);
        }

        t.search(s);
        sc.close();
    }
}

class TrieNode{
    TrieNode[] nums;
    boolean isEnd;
    TrieNode(){
        nums=new TrieNode[26];
        isEnd=false;
    }
}

class Trie{
    public TrieNode root=new TrieNode();

    public void insert(String x){
        TrieNode temp=root;
        for(int i=0;i<x.length();i++){
            int index=x.charAt(i)-'a';

            if(temp.nums[index]==null){
                temp.nums[index]=new TrieNode();
            }

            temp=temp.nums[index];
        }
        temp.isEnd=true;
    }

    public void search(String s){
        for(int i=0;i<s.length();i++){
            TrieNode temp=root;
            for(int j=i;j<s.length();j++){
                int index=s.charAt(j)-'a';
                if(temp.nums[index]!=null){
                    temp=temp.nums[index];
                    if(temp.isEnd==true) System.out.println(i+" "+j);
                }else{
                    break;
                }
            }   
        }
    }
} 