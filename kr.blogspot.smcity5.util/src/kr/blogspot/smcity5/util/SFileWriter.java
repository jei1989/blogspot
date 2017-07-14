package kr.blogspot.smcity5.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class SFileWriter {

	FileOutputStream outstream;
	public SFileWriter()
	{
		
	}
	
	public void fileWrite(String path, String writemsg)
	{
		try{
		File _file = new File(path);
		if( !_file.exists() )
		{
			new File(_file.getParent()).mkdirs();
		}
		
		try {
			FileOutputStream outstream = new FileOutputStream(_file.getAbsolutePath());
			
			try {
				outstream.write( writemsg.getBytes() );
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try {
					outstream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}catch(Exception ex){
			StaticValue.trace(ex.toString());
		}
	}
	

}
