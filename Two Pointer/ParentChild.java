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
        
        for(int i=0;i<s.length;i++){
            if(ref.length()<s[i].length()) continue;
            int x=0,out=1,j;
            for(j=1;j<s[i].length();j++){
                if(s[i].charAt(j)!=s[i].charAt(j-1)){
                    // System.out.println("out "+out);
                    int count=0;
                    while(x<ref.length()){
                        if(ref.charAt(x)==s[i].charAt(j-1)){
                            x++;
                            count++;
                        }else break;
                    }
                    
                    if(out<=count && (count==1 || count>=3)){
                        out=1;
                        continue;
                    }else{
                        // System.out.println(1);
                        out=1;
                        break;
                    }
                }else out++;
            }
            
            if(j==s[i].length()-1) j++;
            
            int count=0;
            while(x<ref.length()){
                if(ref.charAt(x)==s[i].charAt(j-1)){
                    x++;
                    count++;
                }else break;
            }
            
            if(out<=count && (count==1 || count>=3)){
                
            }else{
                continue;
            }
            
            while(x<ref.length()){
                if(ref.charAt(x)!=ref.charAt(x-1)) break;
                x++;
            }
            // System.out.println(j+" "+x);
            if(j==s[i].length() && x==ref.length()) res++;
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