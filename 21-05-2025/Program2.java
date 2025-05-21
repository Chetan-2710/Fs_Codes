// Indus Infra Ltd purchased a land of size L * W acres, for their upcoming venture.
// The land is divided into rectangular plots, using fences. They have kept some 
// H horizontal fences as hfences[] and V vertical fences as vfences[] on the land,
// where hfence[i] is the distance from the top of the land to the i-th horizontal
// fence and, vfence[j] is the distance from the top of the land to the j-th 
// vertical fence. Each 1*1 cell is one acre plot.

// Mr.RGV wants to purchase the biggest plot available to build a Guest-house.
// Your task is to help Mr.RGV to find the biggest plot vailable after the fences 
// are setup in the venture.
// NOTE: The answer can be a large number, return the modulo of 10^9 + 7.

// Input Format:
// -------------
// Line-1: 4 space separated integers, L,W,H and V
// Line-2: H space separated integers, hfence[] in the range [0, L]
// Line-3: V space sepaarted integers, vfence[] in the range [0, W]

// Output Format:
// --------------
// Print an integer result, the area of biggest plot.


// Sample Input-1:
// ---------------
// 5 6 2 2
// 2 3
// 2 5

// Sample Output-1:
// ----------------
// 6


// Sample Input-2:
// ---------------
// 5 6 1 1
// 3
// 4

// Sample Output-2:
// ----------------
// 12


import java.util.*;

class Program2{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        
        int m=sc.nextInt(),n=sc.nextInt(),h=sc.nextInt(),v=sc.nextInt();
        
        List<Integer> hl=new ArrayList<>();
        hl.add(0);
        for(int i=0;i<h;i++){
            hl.add(sc.nextInt());
        }
        hl.add(m);
        Collections.sort(hl);
        
        List<Integer> vl=new ArrayList<>();
        vl.add(0);
        for(int i=0;i<v;i++){
            vl.add(sc.nextInt());
        }
        vl.add(n);
        Collections.sort(vl);
        
        int res=0;
        for(int i=1;i<hl.size();i++){
            long x=hl.get(i)-hl.get(i-1);
            for(int j=1;j<vl.size();j++){
                int b=(int)((x*vl.get(j))%1_000_000_007);
                int a=(int)((x*vl.get(j-1))%1_000_000_007);
                res=Math.max(res,b-a);
            }
        }
        System.out.print(res);
        sc.close();
    }
}