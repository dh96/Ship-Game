package games.examples.Ship;
import java.awt.*;
import javax.swing.*;


import java.util.*;

 class ShipPanel extends JPanel {
	
	private JPanel cards;
	private final static String PLAYER1 = "Player1";
	private final static String PLAYER2 = "Player2";
	private JLabel label;
	private ArrayList<Player>player_list;
	private JButton btn_restart;
	
	ShipPanel(){
		this.setLayout(new BorderLayout());
		this.btn_restart = new JButton("New Game");
		this.label 		= new JLabel("Player1",SwingConstants.CENTER);
		this.label.setFont(new Font("Serif",Font.PLAIN,20));
		this.label.setForeground(Color.white);
		this.label.setBackground(Color.black);
		this.label.setOpaque(true);
		this.player_list = new ArrayList<Player>();
		this.cards		= new JPanel(new CardLayout());
		
		this.player_list.add(new Player(Color.white,this.cards,this.label,this.player_list));
		this.player_list.add(new Player(Color.white,this.cards,this.label,this.player_list));
		
		this.player_list.get(0).setName("Player1");
		this.player_list.get(1).setName("Player2");

		
		this.cards.add(this.player_list.get(0),PLAYER1);
		this.cards.add(this.player_list.get(1),PLAYER2);
	
		this.player_list.get(0).setEnemyData(this.player_list.get(1).getButtons());
		this.player_list.get(1).setEnemyData(this.player_list.get(0).getButtons());
		
		this.btn_restart.setBackground(Color.black);
		this.btn_restart.setFont( new Font("Serif",Font.PLAIN,20));
		this.btn_restart.setForeground(Color.white);
		this.btn_restart.setBorderPainted(false);
		this.btn_restart.setFocusPainted(false);
		this.btn_restart.addActionListener(event->{
			for(Player pl : this.player_list) {
				pl.reset();
			}
		});
		
		this.add(this.label,BorderLayout.PAGE_START);
		this.add(this.cards,BorderLayout.CENTER);
		this.add(this.btn_restart,BorderLayout.PAGE_END);
		
	}
	

}
