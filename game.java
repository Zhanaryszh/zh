package game;
import javax.swing.JOptionPane;

public class game {

	public static void main(String[] args) {
		
		String choise = JOptionPane.showInputDialog(null, "Choose the difficulty of the game from 1 to 7","Game difficulty",1);
		
		int  hard = choise.charAt(0)-'0';
		if ((hard>=1)&&(hard<=7)) {
			okno window = new okno(hard);
		}  // ny rain game
		
	}

}
