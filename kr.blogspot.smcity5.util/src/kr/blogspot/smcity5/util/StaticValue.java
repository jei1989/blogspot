package kr.blogspot.smcity5.util;

import java.io.PrintStream;

public class StaticValue {

	static PrintStream oOut = System.out;
	
	public static void trace(String msg)
	{
		oOut.println(msg);
	}
	
	
	
	

}
