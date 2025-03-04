// There are N cities, and M routes[], each route is a path between two cities.
// routes[i] = [city1, city2], there is a travel route between city1 and city2.
// Each city is numbered from 0 to N-1.

// There are one or more Regions formed among N cities.
// A Region is formed in such way that you can travel between any two cities
// in the region that are connected directly and indirectly.

// Your task is to findout the number of regions formed between N cities.

// Input Format:
// -------------
// Line-1: Two space separated integers N and M, number of cities and routes
// Next M lines: Two space separated integers city1, city2.

// Output Format:
// --------------
// Print an integer, number of regions formed.

// Sample Input-1:
// ---------------
// 5 4
// 0 1
// 0 2
// 1 2
// 3 4

// Sample Output-1:
// ----------------
// 2

// Sample Input-2:
// ---------------
// 5 6
// 0 1
// 0 2
// 2 3
// 1 2
// 1 4
// 2 4

// Sample Output-2:
// ----------------
// 1

// Note: Look HINT for explanation.

import java.util.*;

class Solution {

  private static int find(int[] city, int a) {
    if (city[a] != a) {
      city[a] = find(city, city[a]);
    }
    return city[a];
  }

  private static void union(int[] city, int a, int b) {
    int x = find(city, a);
    int y = find(city, b);

    if (x == y)
      return;

    if (x < y) {
      city[y] = x;
    } else {
      city[x] = y;
    }
  }

  private static int helper(int n, int m, int[] city, int[][] route) {
    for (int i = 0; i < n; i++)
      city[i] = i;

    for (int i = 0; i < m; i++)
      union(city, route[i][0], route[i][1]);

    Set<Integer> s = new HashSet<>();
    for (int i = 0; i < n; i++) {
      s.add(find(city, i));
    }

    return s.size();
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] city = new int[n];

    int m = sc.nextInt();
    int[][] route = new int[m][2];

    for (int i = 0; i < m; i++) {
      route[i][0] = sc.nextInt();
      route[i][1] = sc.nextInt();
    }

    System.out.print(helper(n, m, city, route));
  }
}