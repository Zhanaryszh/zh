package game;
import javax.imageio.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

class pole extends JPanel {
	private Image hat;
	private Image background;
	private Image endGame;
	public int x = 400;
	private int hard;
	private podar[] gameGifts;
	public Timer timerUpdate, timerDraw;
	
	
	
	public pole(int hard) {
		this.hard = hard;
		try {
			hat = ImageIO.read(new File("img/shapka1.png"));
		}
		catch(IOException ex) {System.out.println("Cant load \"hat\" image");}
		try {
			background = ImageIO.read(new File("img/snow1.jpg"));
		}
		catch(IOException ex) {System.out.println("Can t load \"background\" image");}
		try {
			endGame = ImageIO.read(new File("img/end_game.png"));
		}
		catch(IOException ex) {System.out.println("Can t load \"end game\" image");}
		
		gameGifts = new podar[7];
				for (int i=0;i<7;i++) {
					try {
						gameGifts[i] = new podar(ImageIO.read(new File("img/p"+i+".png" )));
					}
					catch(IOException ex) {System.out.println("Can t load \"gift\" image");}
				}
		 timerUpdate = new Timer(3000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateStart();
			}
		});
		timerUpdate.start();
		
		 timerDraw = new Timer(50, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				repaint();
			}
		});
		timerDraw.start();
	}
	
	public void paintComponent(Graphics gr) {
		super.paintComponent(gr);
		gr.drawImage(background, 0, 0, null);
		gr.drawImage(hat, x, 465, null);
		
		for(int i=0; i<7; i++) {
			gameGifts[i].draw(gr);
			if(gameGifts[i].act==true) {
				if((gameGifts[i].y+gameGifts[i].img.getHeight(null))>=400) {
					if(Math.abs(gameGifts[i].x-x) > 75) {
						gr.drawImage(endGame, 300, 300, null);
						timerDraw.stop();
						timerUpdate.stop();
						break;
					}else gameGifts[i].act=false;
				}
			}
		}
	}


private void updateStart() {
	int giftsNumber = 0;
	for(int i=0; i<7; i++) {
		if(gameGifts[i].act==false) {
			if(giftsNumber < hard) {
				gameGifts[i].start();
				break;
			}
		}
		else giftsNumber++;
	   }
	}
}






