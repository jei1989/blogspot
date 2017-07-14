package kr.blogspot.smcity5.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

public class SFileReader {

	String[] spiltVal = {"\\ ","\\,","\\|","\\;","\\:","\\	"};
	Vector vec;
	
	public SFileReader()
	{
		
	}
	
	
	//return Vector(String[]);
	public Vector sFileRead(String path){
		
		File _file = new File(path);
		if( _file.exists() )
		{
			
			if( vec != null  )
			{
				vec.removeAllElements();
			}
			vec = new Vector();
			
			String _readline = "";
			String ssplit = "";
			BufferedReader buffreader =null;
			try {
				buffreader = new BufferedReader(new FileReader(path));
				
				
				try {
					_readline = buffreader.readLine();
					ssplit = checkSpilt(_readline);
					
					String[] _temp = _readline.split(ssplit);
					vec.addElement(_temp);
					
					try {
						while( ( _readline = buffreader.readLine()) != null ){
							
							_temp = _readline.split(ssplit);
							vec.addElement(_temp);
							
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally{
					
					try {
						buffreader.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	

			
		}
		return vec;
	}
	
	
	private String checkSpilt(String _line)
	{
		
		
		int[] checkNum = new int[spiltVal.length];
		int compare = 0;
		int count = 0;
		
		for( int i=0 ; i< spiltVal.length ; i++)
		{
			checkNum[i] = (_line.split(spiltVal[i])).length;
			if( checkNum[i] > compare ){
				compare = checkNum[i];
				count = i;
			}
		}
		
		return spiltVal[count];
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
