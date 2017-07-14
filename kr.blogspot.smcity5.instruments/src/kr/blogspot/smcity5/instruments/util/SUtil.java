package kr.blogspot.smcity5.instruments.util;

import java.io.File;

public class SUtil {

	private static String TPINFO = "tpinfo.txt";
	public static String CONFIGUREDIR = "configure";
	
	public static String getLocalPath()
	{
		return System.getProperty("user.dir");
	}

	public static String getTpInfoFile()
	{
		String tpinfofile = getLocalPath() + "\\" + CONFIGUREDIR + "\\" + TPINFO;
		return tpinfofile;
	}
	
}
