package interviewprep;

// Optimal substructure
// L(i) = { 1 + Max ( L(j) ) } where j < i and arr[j] < arr[i] and 
// if there is no such j then L(i) = 1

// Memoirization is the L(j) answer.
// Isn't this still O(n^2)?
// https://en.wikipedia.org/wiki/Longest_increasing_subsequence
public class LongestIncresingSubsequence {
  
}
