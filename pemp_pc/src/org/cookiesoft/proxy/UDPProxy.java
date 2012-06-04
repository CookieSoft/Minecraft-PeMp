package org.cookiesoft.proxy;

import java.io.*;
import java.net.*;

public class UDPProxy implements Runnable{
	private String ServerIP;
	private int ServerPort;
	
	private String ClientIP;
	private int ClientPort;
	
	private String ServerIP2;
	private int ServerPort2;
	
	private DatagramSocket server;
	
	public UDPProxy(String ServerIP, int ServerPort){
		this.ServerIP = ServerIP;
		this.ServerPort = ServerPort;
	}

	public UDPProxy(String ServerIP, int ServerPort, String ServerIP2, int ServerPort2){
		this.ServerIP = ServerIP;
		this.ServerPort = ServerPort;
		this.ServerIP2 = ServerIP2;
		this.ServerPort2 = ServerPort2;
	}

	@Override
	public void run() {
		try{
			if(ServerIP2 == null){
				server = new DatagramSocket(19132);
			}else{
				server = new DatagramSocket(19132, InetAddress.getByName(ServerIP2));
			}
			while(true){
				DatagramPacket packet = new DatagramPacket(new byte[1024], new byte[1024].length);
				server.receive(packet);
				
				if((packet.getAddress().getHostName().equals(ServerIP)) && (packet.getPort() == ServerPort)){
					packet.setAddress(InetAddress.getByName(ClientIP));
					packet.setPort(ClientPort);
				}else{
					ClientIP = packet.getAddress().getHostName();
					ClientPort = packet.getPort();
					
					packet.setAddress(InetAddress.getByName(ServerIP));
					packet.setPort(ServerPort);
				}
				server.send(packet);
			}
		}catch(IOException e){
			
		}
	}
}
