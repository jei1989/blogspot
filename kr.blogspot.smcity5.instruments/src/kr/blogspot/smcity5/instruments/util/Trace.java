package kr.blogspot.smcity5.instruments.util;

import java.io.PrintStream;

public class Trace {

	static PrintStream oOut = System.out;
	public static void trace(String msg)
	{
		oOut.println(msg);
	}
	
}
