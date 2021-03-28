import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class DP
{

	static int getMinDiff(int[] arr, int n, int k) {
         Arrays.sort(arr);
        int min_elem, max_elem;
        int ans = arr[n-1] - arr[0];
        
        for (int i=1 ; i< n; i++){
            
            if(arr[i] < k)
                continue;
         
            max_elem = Math.max(arr[i-1] + k, arr[n-1] - k );
            min_elem = Math.min(arr[0] + k, arr[i] - k );
            ans = Math.min(ans, max_elem - min_elem);
        }
        return ans;
    }

	public static void main (String[] args) 
	{
		
		    // K = 3, N = 5
			// Arr[] = {3, 9, 12, 16, 20}
		
			int k = 3,n = 5;

			int[] arr = {3, 9, 12, 16, 20};

			System.out.println(getMinDiff(arr,n,k));

	}
}