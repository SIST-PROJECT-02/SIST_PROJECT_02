package com.sist.controller;
import java.util.*;
public class A {
	Map map=new HashMap();
	public A()
	{
		map.put("b", new B());
	}
	public static void main(String[] args) {
			
		A a=new A();
		B b=(B)a.map.get("b"); //B b=new B();
		B c=(B)a.map.get("b"); //B b=new B();
		
		System.out.println("b="+b);
		System.out.println("c="+c);
		//주소값이 동일 = 싱글턴: 객체 하나를 가지고 여러군데에서 사용. 싱글턴과 싱글턴패턴은 다르다.
	}
}

class B
{
	public void display()
	{
		System.out.println("display call");
	}
}
