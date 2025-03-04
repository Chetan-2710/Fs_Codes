// You are a database integrity engineer working for a global cloud company. 
// Your team maintains a distributed database network, where each server either:
//     - Stores equivalent data to another server (serverX == serverY).
//     - Stores different data from another server (serverX != serverY).

// The transitive consistency rule must be followed:
//     - If A == B and B == C, then A == C must be true.
//     - If A == B and B != C, then A != C must be true.

// Your task is to analyze the given constraints and determine whether they 
// follow transitive consistency. If all relations are consistent, return true; 
// otherwise, return false

// Input Format:
// -------------
// Space separated strnigs, list of relations

// Output Format:
// --------------
// Print a boolean value, whether transitive law is obeyed or not.


// Sample Input-1:
// ---------------
// a==b c==d c!=e e==f

// Sample Output-1:
// ----------------
// true


// Sample Input-2:
// ---------------
// a==b b!=c c==a

// Sample Output-2:
// ----------------
// false

// Explanation:
// ------------
// {a, b} form one equivalence group.
// {c} is declared equal to {a} (c == a), which means {a, b, c} should be equivalent.
// However, b != c contradicts b == a and c == a.

// Sample Input-3:
// ---------------
// a==b b==c c!=d d!=e f==g g!=d

// Sample Output-3:
// ----------------
// true


import java.util.*;

class Solution{
    
    private static int find(int[] p,int z){
        if(p[z]!=z){
            p[z]=find(p,p[z]);
        }
        return p[z];
    }
    
    private static void union(int[] p,int a,int b){
        int x=find(p,a);
        int y=find(p,b);
        
        if(x==y) return;
        
        if(x<y) p[y]=x;
        else p[x]=y;
        
    }
    
    private static boolean helper(String[] s){
        int[] p=new int[26];
        for(int i=0;i<26;i++) p[i]=i;
        
        for(int i=0;i<s.length;i++){
            if(s[i].charAt(1)=='=') union(p,s[i].charAt(0)-'a',s[i].charAt(3)-'a');
        }
        
        for(int i=0;i<s.length;i++){
            int x=find(p,s[i].charAt(0)-'a');
            int y=find(p,s[i].charAt(3)-'a');
            if(s[i].charAt(1)=='!'){
                if(x==y) return false;
            }else{
                if(x!=y) return false;
            }
        }
        return true;
        
    }
    public static void main(String[] args){
        String[] s=new Scanner(System.in).nextLine().split(" ");
        
        System.out.print(helper(s));
    }
}