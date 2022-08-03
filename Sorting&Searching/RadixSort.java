/* Online Java Compiler and Editor */
import java.util.*;
public class RadixSort{

     public static void main(String []args){
         int[] arr = new int[]{2, 24, 45, 66, 75, 90, 170, 802};
         arr = countSort(arr,10);
         System.out.println(Arrays.toString(arr));
     }
  static int[] countSort(int[] arr,int exp){ 
    
    int n = arr.length;
    int[] ans = new int[n]; 
    int[] freq = new int[10];
    
    for(int temp : arr){
        freq[(temp/exp)%10]++;
    }

    for(int i = 1; i < 10;i++){
      freq[i] = freq[i-1] + freq[i];
    }
    
    for(int i = 0; i < 10;i++) freq[i] = freq[i]-1;
    for(int i = n-1;i >=0;i--){
      int val = arr[i];
      int idx = freq[(val/exp)%10];
      ans[idx] = val;
      freq[(val/exp)%10]--;
    }  

    return ans;
  }
}