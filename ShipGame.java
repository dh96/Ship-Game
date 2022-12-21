package games.examples.Ship;

import java.awt.*;
import java.util.ArrayList;
import games.basic.gameObjects.moveable.*;
import javax.swing.*;


public class ShipGame {
	private JFrame frame;
	private ShipPanel sp;
	
	ShipGame(){
		this.frame = new JFrame();
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setTitle("ShipGame");
		this.sp = new ShipPanel();
		this.frame.add(this.sp);
		this.frame.pack();
		this.frame.setLocationRelativeTo(null);
		this.frame.setVisible(true);
		
	}
	
	
	public static void main(String[] str) {
		ShipGame game = new ShipGame();
	}
}

