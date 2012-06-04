package org.cookiesoft.pemp.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Panel extends JPanel{
	public void paint(Graphics g){
		g.setFont(new Font("Arial", 20, 20));
		g.setColor(Color.GREEN);
		g.drawString("Minecraft", 10, 20);
		g.setColor(Color.RED);
		g.drawString("Pe", 95, 20);
		g.setColor(Color.BLUE);
		g.drawString("Mp", 119, 20);
		g.setFont(new Font("Arial", 10, 10));
		g.setColor(Color.GRAY);
		g.drawString("Stop playing local!", 10, 30);
		
		g.drawString("IP-Address:", 10, 47);
		g.drawString("Port:", 270, 47);
		
		g.setColor(Color.RED);
		g.drawString("WARNING: Only one client can join per server!", 10, 115);
	}
}
