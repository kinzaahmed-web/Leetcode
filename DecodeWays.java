public class DecodeWays{
  //We use an array for DP to store the results for subproblems.
  //A cell with index i of the dp array is used to store the numbers of decode
  //ways for substring for s from index 0 to index i-1.
  //We initialize the starting two indices of the dp array
  //1. if the string s is empty or null we return te result as 0
  //2. initialize dp array dp[0] = 1
  //3. If the first character of the string is zero then no decode is possible
  //hence initialize dp[1] to 0, otherwise the first character is valid to pass on the baton, dp[1] = 1.
  //4. Iterate the dp array starting at index 2. The index i of dp is the i-th character of the string s,
  // that is character at index i-1 of s.
  //5. We check if valid single digit decode is possible. This just means the character
  //at index s[i-1] is non-zero. Since we do not have a decoding for zero. If the valid
  //single digit decoding is possible then we add dp[i-1] to dp[i]. Since all the ways up
  //to (i-1)-th character now lead up to i-th character too.
  //6. We check if valid two digit decode is possible. This means the substring s[i-2]s[i-1]
  //is between 10 to 26. If the valid two digit decoding is possible then we add dp[i-2] to dp[i].
  //7. Once we reach the end of the dp array we would have the number of ways of decoding string s.
  public static int numDecodings(String s){
    //dp stores the number of ways to decode a string of length[x]
    int [] dp = new int[s.length()+ 1]; //the + 1 accounts for 0
    dp[0] = 1;
    //if s.charAt(0) is 0 then dp[1] = 0 or else its 1
    dp[1] = s.charAt(0) == '0' ? 0 : 1;
    for(int i = 2; i <= s.length(); i++){
      //get current character, turn it to a Integer and then store in oneDigit
      int oneDigit = Integer.valueOf(s.substring(i - 1, i));
      //get current digit and previous digit and turn it to an integer then
      //store it in twoDigit
      int twoDigit = Integer.valueOf(s.substring(i - 2, i));
      if(oneDigit >= 1){
        //add all the ways to decode the previous subproblem to the current subproblem
        dp[i] += dp[i-1];
      }
      if(twoDigit >= 10 && twoDigit <= 26){
        dp[i] += dp[i-2];
      }
    }
    return dp[s.length()];
  }

  public static void main(String[] args){
    System.out.println(numDecodings("326"));
    //3 2 6
    //3 26
    //expected result: 2
    //Time complexity: O(N) where N is the length of the string.
    // We iterate through the length of dp array which is N + 1
    //Space Complexity: O(N) the length of the DP array
  }
}
