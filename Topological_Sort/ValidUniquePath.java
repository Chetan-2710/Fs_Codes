// Imagine you are designing a treasure hunt that takes participants through 
// n unique landmarks, each identified by a distinct number from 1 to n. 
// The official treasure map provides an itinerary—called the route—which is a 
// complete ordering (a permutation) of these landmarks. Along the way, m clues 
// are given in the form of several smaller landmark sequences. Each clue is a pair
// of landmarks that appear in the route in the same order, though not necessarily 
// consecutively.

// Your challenge is to determine whether the provided route is both the shortest 
// possible itinerary that incorporates all the clues and the only such itinerary. 
// The shortest itinerary is defined as one that contains every clue as an ordered 
// subsequence while including no extra landmarks beyond what is necessary. Although
// there might be multiple itineraries that include all clues, the route must be 
// unique and minimal for your treasure hunt to be considered well-defined.

// Display valid if the official route is the only shortest itinerary that fits all 
// the clues, or invalid otherwise.


// Input format:
// -------------
// Line 1: n m, space seperated 2 integers
// Line 2: n space seperated integers, representing official route
// Line 3: m lines of clues, each clue has 2 space separated integers

// Output format:
// ---------------
// official route is valid or official route is invalid.


// Example 1:  
// input=
// 3 2
// 1 3 2
// 1 2
// 1 3
// output=
// [1, 3, 2] is invalid

// Explanation: 
// - There are two possible itineries: [1,2,3] and [1,3,2].
// - The clue [1,2] is a subsequence of both: [1,2,3] and [1,3,2].
// - The clue [1,3] is a subsequence of both: [1,2,3] and [1,3,2].
// - Since there are multiple valid shortest itineraries, the official route is not unique.

// Example 2: 
// input=
// 3 1
// 1 2 3
// 1 2
// output=
// [1, 2, 3] is invalid

// Explanation: 
// - The shortest possible itinerary is [1,2].
// - The clue [1,2] is a subsequence of it: [1,2].
// - Since official route is not the shortest itinerary, we return false.

// Example 3:
// input=
// 3 3
// 1 2 3
// 1 2
// 1 3
// 2 3
// Output=
// [1, 2, 3] is valid
  
// Explanation: 
// - The only possible shortest itinerary that contains all the clues is [1, 2, 3]. 
// - No alternative minimal route exists. 


import java.util.*;

class ValidUniquePath{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        
        int n=sc.nextInt();
        int m=sc.nextInt();
        
        int[] path=new int[n];
        int[] inb=new int[n+1];
        int[][] clue=new int[m][2];
        List<List<Integer>> l=new ArrayList<>();
        
        for(int i=0;i<=n;i++) l.add(new ArrayList<>());
        
        for(int i=0;i<n;i++) path[i]=sc.nextInt();
        for(int i=0;i<m;i++){
            int to=sc.nextInt();
            int from=sc.nextInt();
            clue[i][0]=to;
            clue[i][1]=from;
            l.get(from).add(to);
            inb[to]++;
        }
        
        Set<Integer> s=new HashSet<>();
        for(int i=0;i<m;i++){
            if(inb[clue[i][1]]==0) s.add(clue[i][1]);
        }
        
        // System.out.println(s.toString());
        Queue<Integer> q=new LinkedList<>();
        
        for(int i:s){
            q.offer(i);
        }
        
        int j=path.length-1;
        while(!q.isEmpty()){
            if(q.size()>1) break;
            
            int temp=q.peek();
            if(j<0 || temp!=path[j]) break;
            j--;
            temp=q.poll();

            for(int i:l.get(temp)){
                inb[i]--;
                if(inb[i]==0) q.offer(i);
            }
        }
        
        if(q.isEmpty() && j==-1) System.out.print(Arrays.toString(path)+" is valid");
        else System.out.print(Arrays.toString(path)+" is invalid");
        sc.close();
    }
}  