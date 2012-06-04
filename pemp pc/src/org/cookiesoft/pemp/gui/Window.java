package org.cookiesoft.pemp.gui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

import org.cookiesoft.proxy.UDPProxy;

public class Window implements MouseListener{
	JButton cs = new JButton("Create Server...");
	JTextField ip = new JTextField();
	JTextField port = new JTextField("19132");
	JButton connect = new JButton("Connect");
	Panel p = new Panel();
	JFrame Window = new JFrame();
	
	public void create(){
		Window.setSize(400, 150);
		Window.setTitle("Minecraft PeMp");
		Window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Window.setLayout(null);
		Window.setResizable(false);
		
		connect.setSize(100, 20);
		connect.setBounds(10, 80, 100, 20);
		connect.addMouseListener(this);
		
		cs.setSize(100, 20);
		cs.setBounds(130, 80, 100, 20);
		cs.addMouseListener(new ClickListener());
		
		p.setBounds(0, 0, 400, 200);
		
		port.setSize(50, 20);
		port.setBounds(270, 50, 50, 20);
		
		ip.setSize(250, 20);
		ip.setBounds(10, 50, 250, 20);
		
		Window.add(cs);
		Window.add(connect);
		Window.add(port);
		Window.add(ip);
		Window.add(p);
		Window.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent arg0){
		new Thread(new UDPProxy(ip.getText(), Integer.parseInt(port.getText()))).start();
		connect.setEnabled(false);
		port.setEnabled(false);
		ip.setEnabled(false);
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
