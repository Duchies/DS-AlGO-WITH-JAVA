/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public  class Test
{

	public static void main (String[] args) 
	{
		
		Stack st = new Stack(10,3);

		st.push(1,1);
		st.push(5,1);
		st.push(10,1);
		st.push(11,1);
		st.push(51,1);
		st.push(120,1);
		st.push(1,2);
		st.push(5,2);
		st.push(10,2);
		
		st.pop(2);
		st.pop(2);
		
		
		st.display();

	}

	
}

class Stack{

	int[] arr;
	int[] next;
	int[] top;
	int k;
	int size;
	int free;
	int idx;

	public Stack(int n,int k){
		
		this.size = n;
		this.arr = new int[n];
		this.next = new int[n];
		this.top = new int[k];

		Arrays.fill(top,-1);

		for(int i = 0 ; i<size-1;i++){
			next[i] = i+1;
		}
		next[size-1] = -1;

		this.idx = 0;
		this.free = 0;
		this.k = k;

	}

	public boolean push(int val,int stackID){

		if(free == -1){
			System.out.println("Stack Over flow");
			return false;
		}


		idx= free;
		free = next[idx];
		next[idx] = top[stackID-1]; 
		top[stackID-1] = idx;
		
		arr[idx] = val;

		return true;

	}

	public int pop(int stackID){

		if(top[stackID-1] == -1){
			System.out.println("Stack Under Flow");
			return -1;
		}

		int index_of_prev_top = top[stackID-1];

		top[stackID-1] = next[index_of_prev_top];

		next[index_of_prev_top] = free;

		return  arr[index_of_prev_top];

	}

	public void display(){

		for(int i = this.idx; i>=0;i--){
			System.out.print(arr[i]+" ");
		}

		System.out.println();
	}

}

