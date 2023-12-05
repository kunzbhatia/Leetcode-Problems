//prashant404 solution
class Solution
{
public int countSubstrings(String s) 
{
	var count = 0;
    var n = s.length();
	
    for (var i = 0; i < n; i++)
	    count += countSubstrings(s, n, i, i) + countSubstrings(s, n, i, i + 1); 
    
    return count;
}

private int countSubstrings(String s, int n, int start, int end) {
	var count = 0;

	while (start >= 0 && end < n && s.charAt(start--) == s.charAt(end++))
        count++;
	
    return count;
}
}