package com.sist.set;
import java.util.*;

public class TreeSet_ {

	public static void main(String[] args) {
		Set set=new HashSet();
		while(true) {
			int r=(int)(Math.random()*100)+1;
			set.add(r);
			if(set.size()==10) break;
		}
		System.out.println(set);
		
		TreeSet set2=new TreeSet(); //자동 sort
		while(true) {
			int r=(int)(Math.random()*100)+1;
			set2.add(r);
			if(set2.size()==10) break;
		}
		System.out.println(set2);
		System.out.println("50보다 작은 수:"+set2.headSet(50));
		System.out.println("50보다 큰 수:"+set2.tailSet(50));
		
	}

}
