import java.util.concurrent.TimeUnit;
import java.io.*;
import java.awt.*;
import javax.swing.*;
//import java.swing.JFrame;
import java.awt.event.KeyEvent;
import java.lang.*;

public class KeyPress{
	public static void main(String args[]){
		JFrame frm = new JFrame();
		frm.setVisible(true);
		frm.setSize(100, 100);
		JTextField lbl = new JTextField();
		lbl.setSize(100, 100);
		lbl.setText("haha...labelll...!!!");
		lbl.setEditable(false);
		lbl.setBackground(Color.RED);
		frm.add(lbl);
		Color clr;
		Point p;
		try{
			Robot rbt = new Robot();
			while(true){
				try{
					p = MouseInfo.getPointerInfo().getLocation();
					clr = rbt.getPixelColor(p.x, p.y);
					lbl.setBackground(clr);
					lbl.setText("( "+p.x+" ), ( "+p.y+" )\n" +clr.getRed()+" "+clr.getGreen()+" "+clr.getBlue());
					if(clr.getRed()!=255){
					    rbt.keyPress(KeyEvent.VK_SPACE);
					    //TimeUnit.SECONDS.sleep(1);
	        	        rbt.keyRelease(KeyEvent.VK_SPACE);
					}
					
				}catch(Exception eu){
					;
				}

			}
		}catch(AWTException e){
			System.out.println(""+e);
		}
	}
}