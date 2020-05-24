package game;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class okno extends JFrame {
	private pole gameP;
	private int hard;
	
	private class myKey implements KeyListener {
		public void keyPressed(KeyEvent e) {
			int key_ = e.getKeyCode();
			if(key_==27)System.exit(0);
			else if(key_==37) {
				if(gameP.x-30>-48)gameP.x -=30;
				else gameP.x = 752;
			}
			else if(key_==39) {
				if(gameP.x+30<732)gameP.x +=30;
				else gameP.x = -48;
			}
		}
		public void keyReleased(KeyEvent e) {}
		public void keyTyped(KeyEvent e) {}
	}
	
	public okno(int hard) {
		this.hard = hard;
		addKeyListener(new myKey());
		setFocusable(true);
		setBounds(0, 0, 800, 600);
		setTitle("Game: New Year s Rain");
		
		gameP = new pole(hard);
		Container cont = getContentPane();
		cont.add(gameP);
		
		setVisible(true);
	}
}





