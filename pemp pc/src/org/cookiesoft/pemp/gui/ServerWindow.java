package org.cookiesoft.pemp.gui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.cookiesoft.proxy.UDPProxy;

public class ServerWindow implements MouseListener{
	JLabel phoneiptext = new JLabel("Your phone-server IP:");
	JLabel startontext = new JLabel("Your Hamachi etc. IP:");
	
	JButton start = new JButton("start");
	JTextField phoneip = new JTextField();
	JTextField starton = new JTextField();
	
	public void create(){
		JFrame Window = new JFrame();
		Window.setTitle("Minecraft PeMp - Server");
		Window.setLayout(null);
		
		phoneiptext.setBounds(10, 10, 140, 20);
		startontext.setBounds(10, 40, 140, 20);
		
		phoneip.setSize(100, 30);
		phoneip.setBounds(150, 10, 150, 20);
		
		starton.setSize(100, 30);
		starton.setBounds(150, 40, 150, 20);
		
		start.setSize(100, 20);
		start.setBounds(50, 70, 100, 20);
		start.addMouseListener(this);
		
		Window.add(start);
		Window.add(startontext);
		Window.add(phoneiptext);
		Window.add(starton);
		Window.add(phoneip);
		Window.setSize(350, 150);
		Window.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		new Thread(new UDPProxy(phoneip.getText(), 19132, starton.getText(), 19132)).start();
		starton.setEnabled(false);
		phoneip.setEnabled(false);
		start.setEnabled(false);
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
