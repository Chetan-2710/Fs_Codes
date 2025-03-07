// "Emphatic Pronunciation" of a given word is where we take the word and
// replicate some of the letter to emphasize their impact.

// Instead of saying 'oh my god', someone may say "ohhh myyy goddd", 
// We define emphatic pronunciation of a word, which is derived by replicating 
// a group (or single) of letters in the original word. 

// So that the replicated group is atleast 3 characters or more and 
// greater than or equal to size of original group. 
// For example Good -> Goood is an emphatic pronunciation,
// but Goodd is not because in Goodd the 'd' are only occuring twice consecutively.
 
// In the question you are given the "Emphatic pronunciation" word, 
// you have to findout how many words can legal result in the 
// "emphatic pronunciation" word.

// Input Format:
// -------------
// Line-1 -> A String contains a single word, Emphatic Pronunciation word
// Line-2 -> Space seperated word/s

// Output Format:
// --------------
// Print an integer as your result


// Sample Input-1:
// ---------------
// goood
// good goodd

// Sample Output-1:
// ----------------
// 1


// Sample Input-2:
// ---------------
// heeelllooo
// hello hi helo

// Sample Output-2:
// ----------------
// 2


import java.util.*;

class Solution{
    
    private static int helper(String ref,String[] s){
        int res=0;
        
        for(String subs:s){
            
            int n=subs.length();
            
            if(ref.length()>=n){
                int i=0,j=0;
                
                while(true){
                    int count=1;
                    
                    while(i<n-1){
                        if(subs.charAt(i)==subs.charAt(i+1)){
                            i++;
                            count++;
                        }else break;
                    }
                    
                    if(i==n-2 && subs.charAt(i)==subs.charAt(i+1)) i++;
                    
                    int temp=0;
                    while(i<n && j<ref.length()){
                        if(subs.charAt(i)==ref.charAt(j)){
                            temp++;
                            j++;
                        }else break;
                        
                    }
                    
                    if(i>=n){
                        if(j==ref.length()) res++;
                        break;
                    } 
                    
                    if(temp<2 && temp<count) break;
                    i++;
                }
            }
        }
        return res;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        
        String ref=sc.nextLine();
        
        String[] s=sc.nextLine().split(" ");
        
        System.out.print(helper(ref,s));
    }
}  