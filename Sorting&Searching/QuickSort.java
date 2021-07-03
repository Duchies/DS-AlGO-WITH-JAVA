class QuickSort 
{ 

    //l -> low , h -> high 
    public int partition(int low , int high,int[] arr){

   
    int pivot = arr[high];
    int i = (low - 1);
 
    for(int j = low; j <= high - 1; j++)
    {
        if (arr[j] < pivot)
        {
            i++;
            swap(arr, i, j);
        }
    }
    swap(arr, i + 1, high);
    return (i + 1);
    
    }

 //    using recursion with base condition l<h;
    public void sort(int l,int h,int[] arr){

        if(l<h){
            
        int pivot = partition(l,h,arr);
         sort(l,pivot-1,arr);
         sort(pivot+1,h,arr);
        }
    }
    
        static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
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
