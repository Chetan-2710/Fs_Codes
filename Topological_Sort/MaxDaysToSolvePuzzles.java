// Imagine you're hosting a mystery treasure hunt with n puzzles numbered from 1 to n. 
// Some puzzles have hidden clues that can only be uncovered after solving certain 
// earlier puzzles. You’re provided with m number of dependencies, where each dependency
// is given as [earlierPuzzle, laterPuzzle]—meaning you must solve the puzzle 
// earlierPuzzle before attempting laterPuzzle. Additionally, you can work on at most k
// puzzles in a single day, but only if you’ve already solved all the prerequisite 
// puzzles on previous days.

// Determine the minimum number of days required to solve all the puzzles. It is 
// guaranteed that the dependencies allow every puzzle to eventually be solved.


// Input format:
// Line 1: 3 space separated integers n m & k
// Line 2: m lines of dependencies

// Output format:
// An integer, minimum number of days.

// Example 1:
// input=
// 4 3 2
// 2 1
// 3 1
// 1 4
// output=
// 3

// Explanation:  
// - On Day 1, you solve puzzles 2 and 3.  
// - On Day 2, having unlocked the clue, you solve puzzle 1.  
// - On Day 3, you solve puzzle 4.

// Example 2:
// input=
// 5 4 2
// 2 1
// 3 1
// 4 1
// 1 5
// output=
// 4

// Explanation:  
// - On Day 1, you can solve puzzles 2 and 3 (you can’t solve more than two in a day).  
// - On Day 2, you solve puzzle 4.  
// - On Day 3, you solve puzzle 1.  
// - On Day 4, you finally solve puzzle 5.

// Constraints:
// • 1 <= n <= 15  
// • 1 <= k <= n  
// • 0 <= m <= n * (n-1) / 2  
// • Each dependency has exactly two elements  
// • 1 <= earlierPuzzle, laterPuzzle <= n  
// • earlierPuzzle != laterPuzzle  
// • All dependency pairs are unique  
// • The dependency graph forms a directed acyclic graph


// two ways are present

import java.util.*;

class Solution{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        
        int n=sc.nextInt();
        int[] ind=new int[n+1];
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<=n;i++) graph.add(new ArrayList<>());
        
        int nd=sc.nextInt();
        int k=sc.nextInt();
        
        int[] d=new int[nd];
        for(int i=0;i<nd;i++){
            int from=sc.nextInt();
            int to=sc.nextInt();
            graph.get(from).add(to);
            ind[to]++;
        }
        
        int res=0;
        Queue<Integer> q=new LinkedList<>();
        
        for(int i=1;i<=n;i++){
            if(ind[i]==0){
                q.offer(i);
            }
        }
        
        
        // while(!q.isEmpty()){
        //     res++;
        //     int min=Math.min(k,q.size());
        //     for(int i=0;i<min;i++){
        //         int temp=q.poll();
                
        //         for(int x:graph.get(temp)){
        //             ind[x]--;
        //             if(ind[x]==0){
        //                 q.add(x);
        //             }
        //         }
        //     }
            
        // }
        
        int count=0;
        while(!q.isEmpty()){
            int temp=q.poll();
            count++;
            
            if(q.isEmpty() || count==k){
                count=0;
                res++;
            }
            
            for(int x:graph.get(temp)){
                ind[x]--;
                if(ind[x]==0){
                    q.add(x);
                }
            }
        }
        System.out.print(res);
    }
} 