import java.util.*;
import java.lang.*;
import java.io.*;

public class CC
{
	public static void main (String[] args) 
	{
	    Scanner sc=new Scanner(System.in);
		long t;
	    t  = 1;
		//t=sc.nextLong();
    	while(t-->0)
    	{
    	
		 String txt = "ABABDABACDABABCABAB";
       	 String pat = "ABABCABAB";

		int M = pat.length();
        int N = txt.length();

		int[] lps = computeLPS(pat);		

		  int i = 0,j = 0 ; // index for txt[]
        while (i < N) {
            if (pat.charAt(j) == txt.charAt(i)) {
                j++;
                i++;
            }
            if (j == M) {
                System.out.println("Found pattern "
                                   + "at index " + (i - j));
                j = lps[j - 1];
            }
  
            // mismatch after j matches
            else if (i < N && pat.charAt(j) != txt.charAt(i)) {
                // Do not match lps[0..lps[j-1]] characters,
                // they will match anyway
                if (j != 0)
                    j = lps[j - 1];
                else
                    i = i + 1;
            }
        }	

    	}
    	sc.close();
	}

	
public static int[] computeLPS(String s){
    //get lookup table
    int[] table = new int[s.length()];
    
    //pointer that points to matched char in prefix part
    
    int index = 0;
    //skip index 0, we will not match a string with itself
    for(int i = 1; i < s.length(); i++){
        if(s.charAt(index) == s.charAt(i)){
            //we can extend match in prefix and postfix
            table[i] = table[i-1] + 1;
            index ++;
        }else{
            //match failed, we try to match a shorter substring
            
            //by assigning index to table[i-1], we will shorten the match string length, and jump to the 
            //prefix part that we used to match postfix ended at i - 1
            index = table[i-1];
            
            while(index > 0 && s.charAt(index) != s.charAt(i)){
                //we will try to shorten the match string length until we revert to the beginning of match (index 1)
                index = table[index-1];
            }
            
            //when we are here may either found a match char or we reach the boundary and still no luck
            //so we need check char match
            if(s.charAt(index) == s.charAt(i)){
                //if match, then extend one char 
                index ++ ;
            }
            
            table[i] = index;
        }
        
    }
    
    return table;
}
}