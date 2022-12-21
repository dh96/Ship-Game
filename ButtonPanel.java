package games.examples.Ship;

import java.awt.*;
import javax.swing.*;

public class ButtonPanel extends JPanel{
	private JButton btn1;
	private Player p;
	
	ButtonPanel(Player p){
		this.btn1 = new JButton("New Start");
		this.p =p;
		this.setLayout(new BorderLayout());
		this.btn1.addActionListener(event ->{
			this.p.reset();
		});
		
		this.add(btn1);
	}
	
	
	
	
}
