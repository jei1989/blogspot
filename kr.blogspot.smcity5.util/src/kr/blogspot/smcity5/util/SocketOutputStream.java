package kr.blogspot.smcity5.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class SocketOutputStream implements Runnable {

	private OutputStream out;
	private Socket socket;
	private String sendValue;
	private boolean isRunnable;
	
	String message;
	
	public SocketOutputStream(Socket socket)
	{
		this.socket = socket;
		try {
			out = socket.getOutputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setMessage(String message){
		this.message = message;
		new Thread(this).start();
		
	}
	
	public void sendSocket()
	{
		try {
			out.write(this.message.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void run()
	{
		sendSocket();
	}

}
