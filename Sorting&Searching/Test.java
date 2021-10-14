
import java.io.*;
import java.util.*;
import java.math.*;
import java.util.Random;
import java.util.StringTokenizer;

public class Test {
    
    static long MOD  = (long)1e9+7;
    public static void main(String[] args) {
        FastReader scan = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        Task solver = new Task();
        
        int t = 1;
        //int t = scan.nextInt();

        for(int tt = 1; tt <= t; tt++) solver.solve(tt, scan, out);
        out.close();
    }

    static class Task {


        public void solve(int testNumber, FastReader sc, PrintWriter out) {
       
          int[] arr = {2,4,10,10,10,18,22};

          int key = 10;
          int ans = -1;

          int low = 0,high = arr.length-1;

          while(low <= high){

            int mid = (low+high)/2;

            // for firstOccurunce of element;
            if(arr[mid] == key){
                ans = mid;
                high = mid-1;
                continue;
            }

            if(arr[mid] < key){
                low = mid+1;
            }else{
                high = mid-1;
            }

          }

          out.println("lower bound  for "+key+" is "+ans);

         low = 0;
         high = arr.length-1;
         ans = -1;

         while(low<=high){

             int mid = (low+high)/2;

            // for lastOccurunce of element;
            if(arr[mid] == key){
                ans = mid;
                low = mid+1;
                continue;
            }

            if(arr[mid] < key){
                low = mid+1;
            }else{
                high = mid-1;
            }


         }

        out.println("upper bound  for "+key+" is "+ans);



           
        } // solve end

    }// end 

   
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

} 