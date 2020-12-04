package assignment5;


// A Java memoization based recursive program to count  
// numbers with sum of n as given 'sum' 
class sum_dig 
{ 
    // A lookup table used for memoization 
    static int lookup[][] = new int[1001][5001]; 
      
    // Memoization based implementation of recursive 
    // function 
    static int countRec(int n, int sum) 
    { 
        // Base case 
        if (n == 0) 
        return sum == 0 ? 1 : 0; 
      
        // If this subproblem is already evaluated, 
        // return the evaluated value 
        if (lookup[n][sum] != -1) 
        return lookup[n][sum]; 
      
        // Initialize answer 
        int ans = 0; 
      
        // Traverse through every digit and 
        // recursively count numbers beginning 
        // with it 
        for (int i= n==18?1:0; i<10; i++) 
        if (sum-i >= 0) 
            ans += countRec(n-1, sum-i); 
      
        return lookup[n][sum] = ans; 
    } 
      
    // This is mainly a wrapper over countRec. It 
    // explicitly handles leading digit and calls 
    // countRec() for remaining n. 
    static int finalCount(int n, int sum) 
    { 
        // Initialize all entries of lookup table 
        for(int i = 0; i <= 1000; ++i){ 
            for(int j = 0; j <= 5000; ++j){ 
                lookup[i][j] = -1; 
            } 
        } 
      
        // Initialize final answer 
        int ans = 0; 
      
        // Traverse through every digit from 1 to 
        // 9 and count numbers beginning with it 
        for (int i = 1; i <= 9; i++) 
        if (sum-i >= 0) 
            ans += countRec(n-1, sum-i); 
        return ans; 
    } 
  
    /* Driver program to test above function */
    public static void main (String args[]) 
    { 
        int n = 18, sum = 162; 
        System.out.println(countRec(n, sum)); 
    } 
}