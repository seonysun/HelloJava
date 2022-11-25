package com.sist.list;
import java.util.*;

/*
 * 	- Stack
 * 		- 저장(push) 출력(pop)
 * 	- Queue
 * 		- 저장(offer) 출력(poll)
 * */

public class Stack_Queue_ {
	private int s_index;
	private int e_index;
	private int[] arr=new int[5];
	public Stack_Queue_() {
		s_index=0;
		e_index=arr.length-1;
	}
	public void push(int a) {
		arr[s_index]=a;
		s_index++;
	}
	public void pop() {
		for(int i=e_index;i>=0;i--) {
			System.out.println(arr[i]);
		}
	}
	public static void main(String[] args) {
		Stack_Queue_ sq= new Stack_Queue_();
		sq.push(1);
		sq.pop();
		sq.push(2);
		sq.pop();
		sq.push(3);
		sq.pop();

		//
		Stack s=new Stack();
		s.push(1);
		s.push(2);
		s.push(3);
		while(!s.empty())
			System.out.println(s.pop()); //역순 출력
		
		System.out.println();
		
		Queue q=new LinkedList();
		q.offer(1);
		q.offer(2);
		q.offer(3);
		while(!q.isEmpty())
			System.out.println(q.poll()); //순차 출력
		
	}

}
