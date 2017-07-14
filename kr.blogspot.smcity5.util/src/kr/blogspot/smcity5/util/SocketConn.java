package kr.blogspot.smcity5.util;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class SocketConn implements Runnable {
	
	private Socket socket;
	private String hostaddress;
	private String hostport;
	private Thread socketthread;
	
	public SocketConn(String hostaddress, String hostport)
	{
		socket = new Socket();
		this.hostaddress = hostaddress;
		this.hostport = hostport;
	}
	
	public Socket connect()
	{
		if ( this.socket != null )
		{
			if( !socket.isConnected() )
			{
				try {
					socket.connect(new InetSocketAddress(hostaddress,Integer.parseInt(hostport)));
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return this.socket;
	}
	
	public void close()
	{
		try {
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void mstart()
	{
		connect();
	}
	
	public void run()
	{
		mstart();
	}
	

}
