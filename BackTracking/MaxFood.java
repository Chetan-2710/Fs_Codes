// You are a bird living in a vast forest. Every day, you fly across different locations 
// to collect food and store it in various nests. However, you must return to your home 
// nest before sunset to rest safely.  

// Your objective is to collect as much food as possible within a given time limit 
// while following the forest rules:
// 1. Each food location contains only one unit of food.  
// 2. The bird can carry only one unit of food at a time.  
// 3. The bird must deposit food into a nest before collecting more.  
// 4. Distance Calculation: The time taken to fly between two locations using 
// the Euclidean distance formula:  d = sqrt{(x_2 - x_1)^2 + (y_2 - y_1)^2}
// 5. The total time spent is the sum of:  
//    - Travel time between locations.  
//    - Fixed time to deposit food in a nest (each nest has a different deposit 
//    time).  
// 6. The bird must return to the home nest before the total time limit.  

// Your goal is to determine the maximum number of food units that the bird
// can collect and store in different nests before sunset.  

// Input Format:
// -------------
// An integer representing the number of food locations.  
// An integer representing the number of nests.  
// A 2D array containing the coordinates of each food location as pairs (x, y) 
// A 2D array containing the coordinates of each nest as pairs (x, y).  
// A 1D array containing the starting coordinates (home nest) (x, y).  
// A floating-point number representing the total time available (before sunset).  

// Output Format:
// ---------------  
// The function must return an integer, representing the maximum number of 
// food units that can be collected and stored in nests within the given time.  

// Sample Input:
// --------------
// 2
// 2
// 3 3
// 4 6
// 5 5
// 6 1
// 1 4
// 13

// Sample Output:
// ---------------
// 2

// Explanation:
// ---------------
// The bird starts at (1,4).
// Moves to food location (3,3) (distance = sqrt(5)).
// Deposits food at a nest (5,5) (distance = sqrt(8)).
// Moves to food location (4,6) (distance = sqrt(2))
// and collects another unit of food.
// Deposits it at a nest (5,5) (distance = sqrt(2)). 
// Returns to the starting point (1,4) (distance = sqrt(17)).
// Total distance is: sqrt(5) + sqrt(8) + sqrt(2) + sqrt(2)+ sqrt(17) = 12.0160278526
// Since the total distance is within the allowed time (13), 
// the maximum food units collected are 2.


// Sample Input:
// --------------
// 4
// 1
// 3 3
// 5 7
// 7 8
// 8 4
// 7 7
// 1 5
// 22

// Sample Output:
// ---------------
// 3


// sample Input:

// 5
// 2
// 1 1
// 2 2
// 3 3
// 4 4
// 5 5
// 6 6
// 7 7
// 0 0
// 30

// output:- 3


import java.util.*;

class MaxFood{
    
    private static void helper(List<int[]> food,List<int[]> nests,int[] home,float time,int[] start,int[] end,double[] internal,int[] vis,int[] res){
        
        if(start[0]!=-1){
            
            double dis1=Math.sqrt(Math.pow((home[0]-start[0]),2)+Math.pow((home[1]-start[1]),2));
            double dis2=Math.sqrt(Math.pow((home[0]-end[0]),2)+Math.pow((home[1]-end[1]),2));
            
            if(dis1+dis2+internal[0]>time) return;
            res[0]=Math.max(res[0],(int)internal[1]);
            
        }
        for(int i=0;i<food.size();i++){
            
            if(vis[i]==0){
                
                int[] x=food.get(i);
                int flag=0;
                
                if(start[0]==-1){
                    start[0]=x[0];
                    start[1]=x[1];
                    flag=1;
                }else{
                    double dis1=Math.sqrt(Math.pow((end[0]-x[0]),2)+Math.pow((end[1]-x[1]),2));
                    internal[0]+=dis1;
                }
                
                vis[i]=1;
                
                for(int[] y:nests){
                    end[0]=y[0];
                    end[1]=y[1];
                    
                    double dis=Math.sqrt(Math.pow((x[0]-y[0]),2)+Math.pow((x[1]-y[1]),2));
                    
                    internal[0]+=dis;
                    internal[1]+=1;
                    
                    helper(food,nests,home,time,start,end,internal,vis,res);
                    
                    internal[0]-=dis;
                    internal[1]-=1;
                    
                }
                
                if(flag==1){
                        start[0]=-1;
                        start[1]=-1;
                        end[0]=-1;
                        end[1]=-1;
                }else{
                        double dis1=Math.sqrt(Math.pow((end[0]-x[0]),2)+Math.pow((end[1]-x[1]),2));
                        internal[0]-=dis1;
                }
                    
                vis[i]=0;
            }
        }
    }
    
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        
        int n=sc.nextInt();
        int nestcount=sc.nextInt();
        
        List<int[]> food=new ArrayList<>();
        List<int[]> nests=new ArrayList<>();
        int[] vis=new int[n];
        
        for(int i=0;i<n;i++){
            int x=sc.nextInt();
            int y=sc.nextInt();
            food.add(new int[]{x,y});
        }
        
        for(int i=0;i<nestcount;i++){
            int x=sc.nextInt();
            int y=sc.nextInt();
            nests.add(new int[]{x,y});
        }
        
        int[] home=new int[2];
        
        home[0]=sc.nextInt();
        home[1]=sc.nextInt();
        
        float time=sc.nextFloat();
        
        double[] internal=new double[]{0,0};
        int[] res=new int[]{0};
        
        int[] start=new int[]{-1,-1};
        int[] end=new int[]{-1,-1};
        
        helper(food,nests,home,time,start,end,internal,vis,res);
        System.out.println(res[0]);
        
    }
}
