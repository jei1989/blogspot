package kr.blogspot.smcity5.util;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class SocketInputStream implements Runnable {

	private InputStream in;
	private BufferedInputStream buffin;
	private Socket socket;
	private String retValue;
	public boolean isRunnable;
	
	public SocketInputStream(Socket socket)
	{
		this.socket = socket;
		try {
			in = socket.getInputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			buffin = new BufferedInputStream(in);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		isRunnable = true;
		new Thread(this).start();
	}
	
	private void setRetValue(String retValue)
	{
		//System.out.println(retValue);
		//Math.abs(Math.round(Double.parseDouble(this.c_inputStream.getInputMsg()) * 100d) / 100d);
		this.retValue = retValue;
	}
	
	public String getRetValue()
	{

		return this.retValue;
	}
	
	public void run()
	{
		receive();
	}
	
	public void receive()
	{
		while(isRunnable){
			
			
			byte[] buf = new byte[1024];
			StringBuffer strbuff = new StringBuffer(1024);
			
			int mread = 0;
			try {
				
				System.out.println( "==================  " + socket.isConnected() + " :: " + socket.getInetAddress().getHostAddress() );
				
				System.out.println( String.valueOf( (char)buffin.read() ) );
				/**********
				//while( (mread = buffin.read() ) != -1 )
				{
					
					if( mread == -1 ){
						strbuff = new StringBuffer(1024);
					}
					strbuff.append( new Character((char)mread).toString() );
					//System.out.println( (char)read);
					
				}
				setRetValue(strbuff.toString());
				/**********/
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}//while(isRunnable){
	}
}
