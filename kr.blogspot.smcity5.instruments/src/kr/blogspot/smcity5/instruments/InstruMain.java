package kr.blogspot.smcity5.instruments;

import java.io.File;
import java.util.Vector;

import kr.blogspot.smcity5.util.*;
import kr.blogspot.smcity5.instruments.util.*;

public class InstruMain implements Runnable{

	MainWindows mwindows;
	SFileReader fileReader;
	SFileWriter fileWriter;
	public InstruMain(MainWindows mwindows)
	{
		this.mwindows = mwindows;
		fileReader = new SFileReader();
		fileWriter = new SFileWriter();
		//new Thread(this).run();

	}
	
	
	public void run() {
		// TODO Auto-generated method stub
		
		while(true){
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try{
				checkTpInfoPath();
			}catch(Exception ex){
				ex.printStackTrace();
			}
			
			try{
				checkTpInfoTable();
			}catch(Exception ex){
				ex.printStackTrace();
			}
			
		}
		
		
	}//public void run() {
	
	
	private void checkTpInfoPath()
	{
		if( mwindows != null){
			if( mwindows.txttpinfopath != null ){
				//if( mwindows.txttpinfopath.getText() != "" )
				{
					//Trace.trace(SUtil.getTpInfoFile());
					File _file = new File(SUtil.getTpInfoFile());
					if( _file.exists() ){
						mwindows.getTxtBoxTpInfo();
						if( mwindows.getTpInfoPath().equals("") ){
							mwindows.setTxtBoxTpInfo( SUtil.getTpInfoFile());
						}
					}else{
						
						String msg = "tpname frequency symbol FEC standard modulation\r"+
									 "BS02 997 23500 5/6 DVB-S2 8PSK\r"+
									 "BS04 1035 21300 8/7 DVB-S QPSK\r"+
									 "BS06 1074 23500 5/6 DVB-S2 8PSK\r"+
									 "BS08 1111 23500 5/6 DVB-S2 8PSK\r"+
									 "BS10 1150 21300 2/3 DVB-S2 8PSK\r"+
									 "BS12 1188 23500 5/6 DVB-S2 8PSK\r"+
									 "CS02 1540 29500 3/4 DVB-S2 8PSK\r"+
									 "CS04 1580 29500 3/4 DVB-S2 8PSK\r"+
									 "CS06 1620 29500 3/4 DVB-S2 8PSK\r"+
									 "CS08 1660 29500 3/4 DVB-S2 8PSK\r"+
									 "CS10 1700 27489 3/4 DVB-S2 8PSK\r"+
									 "CS12 1740 29500 3/4 DVB-S2 8PSK\r"+
									 "CS14 1780 27489 3/4 DVB-S2 8PSK\r"+
									 "CS16 1820 29500 3/4 DVB-S2 8PSK\r"+
									 "CS18 1860 29500 3/4 DVB-S2 8PSK\r"+
									 "CS20 1900 29500 3/4 DVB-S2 8PSK\r"+
									 "CS22 1940 29500 3/4 DVB-S2 8PSK\r"+
									 "CS24 1980 29500 3/4 DVB-S2 8PSK";
						
						fileWriter.fileWrite(SUtil.getTpInfoFile(), msg);
					}
					
				}
			}
		}
		
	}//private void checkTpInfoPath()
	
	private void checkTpInfoTable()
	{
		Vector vec = null;
		
		mwindows.getTpInfoTableCount();
		//System.out.println( mwindows.getTpInfoTableColumnCount() );
		if ( mwindows.getTpInfoTableItemCount() == 0 && !mwindows.getTpInfoPath().equals("") )
		{
			vec = fileReader.sFileRead(mwindows.getTpInfoPath());
			String[] header = null;
			if( this.mwindows.getTpInfoTableColumnCount() == 0 )
			{
				header = (String[])vec.elementAt(0);
				mwindows.setTableHeader(header);
			}
			
			for( int i = 1 ; i <vec.size(); i++)
			{
				String[] item = (String[])vec.elementAt(i);
				mwindows.setTableItemn(item);
			}
			
			
		}
	}//private void checkTpInfoTable()

	
}
