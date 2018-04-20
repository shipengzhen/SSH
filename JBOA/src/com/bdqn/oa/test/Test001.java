package com.bdqn.oa.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test001 {
	
	public static void main(String[] args) {
		
		Set<user> s=new HashSet<user>();
		
		List<user> list=new ArrayList<user>();
		user u1=new user("小明");
		user u2=new user("小x");
		user u3=new user("小2");
		list.add(u1);
		list.add(u2);
		list.add(u3);
		
		s.addAll(list);
		
	}
}
