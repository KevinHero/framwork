package com.flyong.interview.corejava;

public class SwapNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=2147483647;
		int b=2;
		
		
		float af=1.47234f;
		float bf=1.98145f;
		swap(a,b);
		swap(af,bf);
	}

	
	//在边界值：这样交换会造成数值溢出
	public static void swap(int a,int b){
		System.out.println("int：swap before/"+"a="+a+" b="+b);
		b=a+b;
		a=b-a;
		b=b-a;
		
		System.out.println("int:swap after/"+"a="+a+" b="+b);
	}
	
	public static void swap(float a,float b){
		System.out.println("float:swap before/"+"a="+a+" b="+b);
		b=a+b;
		a=b-a;
		b=b-a;
		
		System.out.println("float:swap after/"+"a="+a+" b="+b);
	}
}
