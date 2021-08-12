/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public  class LRU
{

	public static void main (String[] args) 
	{
			 
		int capacity = 3;		 
		LRU lru = new LRU(capacity);
		lru.put(1,71);
		lru.put(2,10);
		lru.put(5,8);

		int val = lru.get(1);
		System.out.println(val);

		lru.put(10,99);

		System.out.println(lru.get(2));

	}

	public int get(int key){

		if(map.containsKey(key)){
			Node node = map.get(key);
			remove(node);
			insert(node);
			return node.value;
		}else{
			return -1;
		}

	}

	public void remove(Node node){
		map.remove(node.key);
		node.prev.next = node.next;
		node.next.prev = node.prev;
	}		

	public void insert(Node node){
		map.put(node.key,node);
		Node headNext = head.next;

		head.next = node;
		node.prev =  head;
		headNext.prev = node;
		node.next = headNext;
	} 

	public void put(int key,int value){
		if(map.containsKey(key)){
			remove(map.get(key));
		}
		if(map.size() == capacity){
			remove(tail.prev);
		}

		insert(new Node(key,value));

	}

	public LRU(int capacity){

		this.capacity =capacity;
		head.next = tail;
		tail.prev = head;
	}

	Node head = new Node(0,0);
	Node tail = new Node(0,0);
	Map<Integer,Node> map = new HashMap<>();
	int capacity;

	class Node{
		int key,value;
		Node next,prev;
		

		Node(int key,int value){
			this.key = key;
			this.value = value;
		}
	}
}

