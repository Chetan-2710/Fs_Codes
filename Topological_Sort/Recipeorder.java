// Imagine you're the master chef in a renowned kitchen, tasked with preparing a 
// spectacular dinner consisting of numDishes unique dishes, labeled from 
// 0 to numDishes - 1. However, the recipes have dependencies—certain dishes can 
// only be prepared after completing others. You’re given a list called dependecies, 
// where each element dependencies[i] = [Xi, Yi] means that you must finish 
// preparing dish Yi before starting dish Xi.

// For instance, the pair [2, 1] implies that to create dish 2, 
// dish 1 must be prepared first.

// Return the ordering of dishes that a chef should take to finish all dishes.
// 	- the result set should follow the given order of conditions.
// 	- If it is impossible to complete all dishes, return an empty set.


// Input Format:
// -------------
// Line-1: An integer numDishes, number of Dishes.
// Line-2: An integer m, number of dependencies.
// Next m lines: Two space separated integers, Xi and Yi.

// Output Format:
// --------------
// Return a list of integers, the ordering of dishes that a chef should finish.

// Example 1:
// ------------
// Input=
// 4
// 3
// 1 2
// 3 0
// 0 1
// Output=
// [2, 1, 0, 3]


// Explanation: There are 4 dishes. Since dish 1 requires dish 2, dish 3 requires 
// dish 0 and dish 0 requires dish 1, you can prepare dishes in the order 2 1 0 3.


// Example 2:
// ----------
// Input=
// 2
// 2
// 1 0
// 0 1
// Output=
// []

// Explanation: There are 2 dishes, but dish 1 depends on dish 0 and dish 0 depends 
// on dish 1. This circular dependency makes it impossible to prepare all dishes.

// Constraints:

// - 1 <= numDishes <= 2000  
// - 0 <= m <= 5000  
// - dependencies[i].length == 2  
// - 0 <= Xi, Yi < numDishes  
// - All the dependency pairs are unique.


// Use adjacency List instead of looping every time

import java.util.*;

class Solution{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        
        int n=sc.nextInt();
        int[] inb=new int[n];
        
        int nd=sc.nextInt();
        int[][] d=new int[nd][2];
        for(int i=0;i<nd;i++){
            d[i][0]=sc.nextInt();
            d[i][1]=sc.nextInt();
            inb[d[i][1]]++;
        }
        
        List<Integer> res=new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<inb.length;i++){
            if(inb[i]==0){
                q.offer(i);
                res.add(i);
            }
        }
        
        while(!q.isEmpty()){
            int temp=q.poll();
            for(int i=0;i<nd;i++){
                if(d[i][0]==temp){
                    inb[d[i][1]]--;
                    if(inb[d[i][1]]==0){
                        q.offer(d[i][1]);
                        res.add(d[i][1]);
                    }
                }
            }
        }
        
        Collections.reverse(res);
        
        System.out.print(res);
        sc.close();
    }
} 