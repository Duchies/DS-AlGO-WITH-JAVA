// problem link
//https://www.geeksforgeeks.org/find-maximum-meetings-in-one-room/


import java.util.*;
import java.lang.*;
import java.io.*;


public class CC{

        static final int MOD = (int) (1E9 + 7);
       
        public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

    //    int t = sc.nextInt();

        int t = 1;
       
    
        while(t-->0){

        int  s[] = {1, 3, 0, 5, 8, 5}, f[] = {2, 4, 6, 7, 9, 9}; 
          
        maxMeeting(s,f);
      
      //  System.out.println(ans);

       }


     }

    
    static class meeting
  {
    int start;
    int end;
    int pos;
     
    meeting(int start, int end, int pos)
    {
        this.start = start;
        this.end = end;
        this.pos = pos;
    }
  }


  static void maxMeeting(int[] s , int[] f ){ 


    ArrayList<meeting> tempAns = new ArrayList<>();
    ArrayList<Integer> answer = new ArrayList<>();

    int last_meeting_end_time = 0;

    for(int i = 0 ; i< s.length;i++)
      tempAns.add(new meeting(s[i],f[i],i));

    mycomparator  mc = new mycomparator();

    Collections.sort(tempAns,mc);

    answer.add(tempAns.get(0).pos);

    last_meeting_end_time = tempAns.get(0).end;

    for(int i = 1; i <tempAns.size(); i++){

      if(tempAns.get(i).start > last_meeting_end_time){

        answer.add(tempAns.get(i).pos);

        last_meeting_end_time = tempAns.get(i).end;


      }


    }

    System.out.println("possible meeting index "+answer);


  } 
        
        
       

 static class mycomparator implements Comparator<meeting>
{
      @Override
      public int compare(meeting o1 , meeting o2){

         // decreasing order sort         
              
        if(o1.end < o2.end){

             // Return -1 if second object is
            // bigger then first
            return -1;
        }
        if(o1.end > o2.end){

              // Return 1 if second object is
            // smaller then first
          return 1;
        }

        return 0; // when same , on the basis of Insertion order it will sort.


      }
}
       
}
