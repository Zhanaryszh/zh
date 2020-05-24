package game;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class podar {
	public Image img;
	public int x, y;
	public Boolean act;
	private Timer timerUpdate;
	
	public podar(Image img) {
		
		this.img = img;
		act = false;
		
		timerUpdate = new Timer(500, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				down();
			}
		});
		this.img = img;
		act = false;
	}
	
	public void start() {
		timerUpdate.start();
		y = 0;
		x = (int)(Math.random()*700);
		act = true;
	}
	void down() {
		if (act == true) y+=10;
		if (y + img.getHeight(null)>=480) timerUpdate.stop();
	} 
	
	public void draw(Graphics gr) {
		if (act==true) {
			gr.drawImage(img,x,y,null);
		}
	}

}



