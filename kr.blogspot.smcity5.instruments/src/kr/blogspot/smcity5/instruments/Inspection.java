package kr.blogspot.smcity5.instruments;

import java.io.IOException;
import java.net.Socket;

import kr.blogspot.smcity5.instruments.util.*;
import kr.blogspot.smcity5.util.SocketConn;
import kr.blogspot.smcity5.util.SocketInputStream;
import kr.blogspot.smcity5.util.SocketOutputStream;

import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

public class Inspection implements Runnable{
	
	SocketConn socketconn;
	SocketInputStream instream;
	SocketOutputStream outstream;
	
	Socket socket;
	

	public Inspection(String address, String port)
	{
		socketconn = new SocketConn(address, port);

		socket = socketconn.connect();
		
		outstream = new SocketOutputStream(socket);
		
		instream = new SocketInputStream(socket);
		
		System.out.println("===============");
	}
	
	public void closeAll()
	{
		this.instream.isRunnable = false;
		try {
			this.socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.socket = null;
		
	}
	
	public void run()
	{
		//inspect();
	}
	/**************/
	public void init(String centerfreq, String span, String vbw, String rbw, String atten, String reflevel, String sweep, String average)
	{
		/***********
		this.outstream.sendSocket("SYST:DISP:UPD ON \r\n");
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//this.outstream.sendSocket("*RST \r\n");
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.outstream.sendSocket("FREQ:CENT " + centerfreq + "MHz\r\n");
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.outstream.sendSocket("FREQ:SPAN " + span + "MHz\r\n");
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.outstream.sendSocket("INP:ATT " + atten + "dB\r\n");
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.outstream.sendSocket("DISP:TRAC:Y:RLEV " + reflevel + "dBm\r\n");
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.outstream.sendSocket("BAND:VID " + vbw + "KHz\r\n");
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.outstream.sendSocket("BAND:RES " + rbw + "KHz\r\n");
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.outstream.sendSocket("SWE:TIME " + sweep + "ms\r\n");
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.outstream.sendSocket("DISP:WIND:TRAC:MODE AVER " + average + "\r\n");
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/***********/
		
	}
	
	public void inspect(String tpname, String frequency, String symbol, String fec, String standard, String modulation)
	{
		/***********
		this.outstream.setMessage("SYST:DISP:UPD ON\r\n");
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.outstream.setMessage("FREQ:CENT " + frequency + "MHz\r\n");
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*************/
		this.outstream.setMessage("INIT;*WAI \r\n");
		/*************/
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*************/
		
		this.outstream.setMessage("CALC:MARK:MODE POS\r\n");
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.outstream.setMessage("CALC:MARK:X " + frequency + "MHz\r\n");
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.outstream.setMessage("CALC:MARK:MODE DELT\r\n");
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String temp = String.valueOf(Integer.parseInt(frequency) + 18);
		this.outstream.setMessage("CALC:MARK:X "  + temp +  "MHz\r\n");
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.outstream.setMessage("CALC:DELT:Y? \r\n");
		/*********/
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*********/
		
		//System.out.println(  instream.getRetValue() );
		
	}
	/**************/
	
	
}
