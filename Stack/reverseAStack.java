import java.util.*;

public class Demo{
    
	public static void reverseStack(Stack<Integer> stack) {
		// write your code here
		if(stack.size() == 0){
            return ;
        }
        int val = stack.pop();
        
        reverseStack(stack);
        
       insert_at_bottom(stack,val);
        
	}
    static void insert_at_bottom(Stack<Integer> stack,int data){

		if(stack.size() == 0){
			stack.add(data);
			return;
		}

		int val = stack.pop();

		insert_at_bottom(stack,data);

		stack.add(val);

	}

}
