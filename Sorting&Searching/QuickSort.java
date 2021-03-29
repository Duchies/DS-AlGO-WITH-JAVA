class QuickSort 
{ 

    //l -> low , h -> high 
    public int partition(int l , int h,int[] arr){

        int pivot = h;
        int i=l-1;
       for(int j=l;j<=h;j++)
        if(arr[j] <= arr[pivot]) {
            i++;

            int temp = arr[i];
            arr[i] = arr[j];
            arr[j]= temp; 
        }   
        return i;
    }

 //    using recursion with base condition l<h;
    public void sort(int l,int h,int[] arr){

        if(l<h){
            
        int pivot = partition(l,h,arr);
         sort(l,pivot-1,arr);
         sort(pivot+1,h,arr);
        }
    }
     
   
    static void printArray(int arr[]) 
    { 
        for(int temp : arr){
            System.out.print(temp+" ");
        }
         System.out.println(); 
    } 
  
    
    public static void main(String args[]) 
    { 
        int arr[] = {10, 7, 8, 9, 1, 2}; 
        int n = arr.length; 

        System.out.println("given array");
        for(int temp : arr){
            System.out.print(temp+" ");
        }
  
        QuickSort obj = new QuickSort(); 
        obj.sort( 0, n-1,arr); 
    
        System.out.println("\nsorted array"); 
        printArray(arr); 
    } 
} 
