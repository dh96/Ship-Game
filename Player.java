package games.examples.Ship;

import java.awt.BasicStroke;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


import games.examples.Ship.Schiff;


class Player extends JPanel{
	
	enum Feld {SCHIFF,WASSER,TREFFER};
	
	private Schiff Schiffe[];
	private int anzahl_schiffe;
	private int anzahl_schiffe_versenkt;
	private boolean insert_direction;
	private Feld[][] spielfeld;
	private JButton[][] buttons;
	private GridLayout layout;
	private Schiff EnemySchiffe[];
	private JPanel cards;

	
	Player(Color cl,JPanel cards,JLabel label,ArrayList<Player>player_list){
		this.setBackground(Color.black);
		layout = new GridLayout(9,9);
		this.setLayout(layout);
		this.spielfeld = new Feld[9][9];
		this.buttons = new JButton[9][9];
		this.insert_direction = true;
		this.anzahl_schiffe_versenkt=0;
		this.Schiffe = new Schiff[4];
		this.anzahl_schiffe = 0;
		this.cards = cards;

		
		 for(int i=0; i < 9;i++) {
				for(int k=0;k < 9;k++) {
					this.spielfeld[i][k] = Feld.WASSER;
					this.buttons[i][k] = new JButton();
					this.buttons[i][k].setName("X");
					this.buttons[i][k].setBackground(cl);
					//this.add(this.buttons[i][k]);
				}	
			}
		 
		 //add listener
			for(int i=0; i < 9;i++) {
				for(int k=0;k < 9;k++) {
					this.buttons[i][k].addActionListener(event->{
						JButton source = (JButton)event.getSource();
						for(int n=0;n<9;n++) {
							for(int m=0; m <9;m++) {
								if(source == this.buttons[n][m]) {
									if(this.buttons[n][m].getName() == "X") {
										this.buttons[n][m].setBackground(Color.red);
										
										if(this.getName() == "Player2") {
											label.setText("Player2");
										}
										
										if(this.getName() == "Player1") {
											label.setText("Player1");
										}
										
										CardLayout c = (CardLayout)this.cards.getLayout();
										c.next(this.cards);
										
										
									}
									
									else {
										this.buttons[n][m].setBackground(Color.green);
										this.spielfeld[n][m] = Feld.TREFFER;
										
										for(Schiff s: this.Schiffe) {
											for(int p=0; p < s.getSize();p++) {
												if(s.getXPositions()[p] == n && s.getYPositions()[p] == m) {
													s.hit();
													if(s.getHit() == s.getSize()) {
														JOptionPane.showMessageDialog(this,"Schiff der Größe: " + s.getSize() +" versenkt");
														s.setVersenkt(true);
														this.anzahl_schiffe_versenkt++;
														if(this.anzahl_schiffe_versenkt == 4) {
															if(this.getName() == "Player1") {
															JOptionPane.showMessageDialog(this,"Alle Schiffe wurden versenkt!\n" + "Player 2" + " hat gewonnen.");
															}
															else if(this.getName() == "Player2") {
															JOptionPane.showMessageDialog(this,"Alle Schiffe wurden versenkt!\n" + "Player 1" + " hat gewonnen.");
															}
															
															label.setText("Player1");
															for(Player player: player_list) {
																player.reset();
															}
														}
													}
												}
											}
								
										}
										
										if(this.getName() == "Player2") {
											label.setText("Player2");
										}
										
										if(this.getName() == "Player1") {
											label.setText("Player1");
										}
										
										CardLayout c = (CardLayout)this.cards.getLayout();
										c.next(this.cards);
										
									}
									
									
								}
							}		
						}
					//
						
					});
				}	
			}
			
			
			  int schiff=1; 
			  while(true && schiff < 5){
			    boolean a = setSchiff(this.spielfeld,this.buttons,randomPos(),randomPos(),schiff);

			    if(a == true){
			      System.out.println("Schiff der Groesse " + schiff + " wurde plaziert!");
			      schiff++;
			    }
			    else{
			        System.out.println("Schiff der Groesse " + schiff + " konnte nicht plaziert werden!");

			        while(true){
			            boolean b = setSchiff(spielfeld,this.buttons,randomPos(),randomPos(),schiff);
			            if(b){
			              System.out.println("Schiff der Groesse " + schiff + " konnte replaziert werden!");
			              schiff++;
			              break;
			            }
			        }

			        continue;
			    }
			   
			  	}
			  
			    if(schiff == 5){
				    System.out.println("Schiffe wurden erfolgreich platziert!");
				    show(this.spielfeld);
				    }	
	 }
	

	void setEnemyData(JButton[][] a) {
		for(int i=0; i < 9; i++) {
			for(int k=0;k < 9;k++) {
				this.add(a[i][k]);
			}
		}
	}
	
	JButton[][]getButtons() {
		return this.buttons;
	}
	
	 private int randomPos(){
		    Random random = new Random();
		    return random.nextInt(9) + 0;
		  }
	 
	 public void reset() {
		 
		 for(int i=0; i < 9;i++) {
				for(int k=0;k < 9;k++) {
					this.spielfeld[i][k] = Feld.WASSER;
					this.buttons[i][k].setName("X");
					this.buttons[i][k].setBackground(Color.white);
					this.anzahl_schiffe = 0;;
				}	
			}
		 
		 this.Schiffe = null;
		 this.Schiffe = new Schiff[4];
		 this.anzahl_schiffe = 0;
		 this.insert_direction = true;
		 this.anzahl_schiffe_versenkt = 0;
		 
		 
		  int schiff=1; // size 0 != ok
		  while(true && schiff < 5){
		    boolean a = setSchiff(this.spielfeld,this.buttons,randomPos(),randomPos(),schiff);

		    if(a == true){
		      System.out.println("Schiff der Groesse " + schiff + " wurde plaziert!");
		      schiff++;
		    }
		    else{
		        System.out.println("Schiff der Groesse " + schiff + " konnte nicht plaziert werden!");

		        while(true){
		            boolean b = setSchiff(spielfeld,this.buttons,randomPos(),randomPos(),schiff);
		            if(b){
		              System.out.println("Schiff der Groesse " + schiff + " konnte replaziert werden!");
		              schiff++;
		              break;
		            }
		        }

		        continue;
		    }
		   
		  	}
		
		    if(schiff == 5){
			    System.out.println("Schiffe wurden erfolgreich platziert!");
			    show(this.spielfeld);
			    }
		 
		 
	 }
	 
	
	 
	  private void show(Feld[][] spielFeld){
		    System.out.println();
		    for(int n=0; n < spielFeld.length;n++){
		      System.out.print(" "+ n + " ");
		    }
		      System.out.println();

		    for(int n=0; n < spielFeld.length;n++){
		      System.out.print(" _ " );
		    }
		      System.out.println();

		    for(int i=0; i < spielFeld.length;i++){
		      for(int k=0; k < spielFeld[i].length;k++){
		        if(spielFeld[i][k] == Feld.WASSER){
		            System.out.print("|_|"  );
		        }
		        else if(spielFeld[i][k] == Feld.SCHIFF){
		          System.out.print("|O|" ); // oder |_|

		        }
		        else if(spielFeld[i][k] == Feld.TREFFER){
		          System.out.print("|X|"  );

		        }
		      }
		      System.out.println("   " + i);
		    }
		}
	 
	  
	 @Override
		public Dimension getPreferredSize() {
			return new Dimension(400,400);
		}
	 
	 private boolean setSchiff(Feld[][]spielFeld,JButton[][] buttons,int posx,int posy,int schiffsGroesse){
		   
		 	
		    switch(schiffsGroesse) {
		    case 1:
		    	if(spielFeld[posx][posy] == Feld.WASSER) {
		    		spielFeld[posx][posy] = Feld.SCHIFF;
		    		buttons[posx][posy].setName("S1");
		    		Schiff S = new Schiff(posx,posy,schiffsGroesse);
		    		Schiffe[anzahl_schiffe] = S;
		    		anzahl_schiffe++;	
		    		this.insert_direction = !this.insert_direction;
		    		return true;
		    		}
		    		else
		    			return false;   		
		    case 2:
		    	if(posx+1 < spielfeld.length && posy+1 < spielfeld.length) {
		    		if(this.insert_direction) {
		    			if(spielFeld[posx][posy] == Feld.WASSER && spielFeld[posx+1][posy] == Feld.WASSER){
		    				spielFeld[posx][posy] = Feld.SCHIFF;
		    				spielFeld[posx+1][posy] = Feld.SCHIFF;
		    				buttons[posx][posy].setName("S2");
		    				buttons[posx+1][posy].setName("S2");
		    				Schiff S = new Schiff(posx,posy,posx+1,posy,schiffsGroesse);
		    				Schiffe[anzahl_schiffe] = S;
		    				anzahl_schiffe++;
		    				this.insert_direction = !this.insert_direction;
		    				return true;
		    			}
		    			else
		    				return false;
		    			}
		    		else {
		    			if(spielFeld[posx][posy] == Feld.WASSER && spielFeld[posx][posy+1] == Feld.WASSER){
		    				spielFeld[posx][posy] = Feld.SCHIFF;
		    				spielFeld[posx][posy+1] = Feld.SCHIFF;
		    				buttons[posx][posy].setName("S2");
		    				buttons[posx][posy+1].setName("S2");
		    				Schiff S = new Schiff(posx,posy,posx,posy+1,schiffsGroesse);
		    				Schiffe[anzahl_schiffe] = S;
		    				anzahl_schiffe++;
		    				this.insert_direction = !this.insert_direction;
		    				return true;
		    			}
		    			else
		    				return false;
		    			}
		    		}
		    		
		    case 3:
		    	if(posx+2 < spielfeld.length && posy+2 < spielfeld.length) {
		    		if(this.insert_direction) {
		    		if(spielFeld[posx][posy] == Feld.WASSER && spielFeld[posx+1][posy] == Feld.WASSER && spielFeld[posx+2][posy] == Feld.WASSER) {
		    			spielFeld[posx][posy] = Feld.SCHIFF;
		    			spielFeld[posx+1][posy] = Feld.SCHIFF;
		    			spielFeld[posx+2][posy] = Feld.SCHIFF;
		    			buttons[posx][posy].setName("S3");
		    			buttons[posx+1][posy].setName("S3");
		    			buttons[posx+2][posy].setName("S3");
		    			Schiff S = new Schiff(posx,posy,posx+1,posy,posx+2,posy,schiffsGroesse);
		    			Schiffe[anzahl_schiffe] = S;
		    			anzahl_schiffe++;
		    			this.insert_direction = !this.insert_direction;
		    			return true;
		    		}
		    		else
		    			return false;
		    		}
		    		else {
		    			if(spielFeld[posx][posy] == Feld.WASSER && spielFeld[posx][posy+1] == Feld.WASSER && spielFeld[posx][posy+2] == Feld.WASSER) {
			    			spielFeld[posx][posy] = Feld.SCHIFF;
			    			spielFeld[posx][posy+1] = Feld.SCHIFF;
			    			spielFeld[posx][posy+2] = Feld.SCHIFF;
			    			buttons[posx][posy].setName("S3");
			    			buttons[posx][posy+1].setName("S3");
			    			buttons[posx][posy+2].setName("S3");
			    			Schiff S = new Schiff(posx,posy,posx,posy+1,posx,posy+2,schiffsGroesse);
			    			Schiffe[anzahl_schiffe] = S;
			    			anzahl_schiffe++;
			    			this.insert_direction = !this.insert_direction;
			    			return true;
			    		}
			    		else
			    			return false;
			    		}
		    		}
		    case 4:
		    	if(posx+3 < spielfeld.length && posy+3 < spielfeld.length) {
		    		if(this.insert_direction) {
		    			if(spielFeld[posx][posy] == Feld.WASSER && spielFeld[posx+1][posy] == Feld.WASSER && spielFeld[posx+2][posy] == Feld.WASSER && spielFeld[posx+3][posy] == Feld.WASSER) {
		    				spielFeld[posx][posy] = Feld.SCHIFF;
		    				spielFeld[posx+1][posy] = Feld.SCHIFF;
		    				spielFeld[posx+2][posy] = Feld.SCHIFF;
		    				spielFeld[posx+3][posy] = Feld.SCHIFF;
		    				buttons[posx][posy].setName("S4");
		    				buttons[posx+1][posy].setName("S4");
		    				buttons[posx+2][posy].setName("S4");
		    				buttons[posx+3][posy].setName("S4");
		    				Schiff S = new Schiff(posx,posy,posx+1,posy,posx+2,posy,posx+3,posy,schiffsGroesse);
		    				Schiffe[anzahl_schiffe] = S;
		    				anzahl_schiffe++;
		    				this.insert_direction = !this.insert_direction;
		    				return true;
		    			}
		    			else
		    				return false;
		    			}
		    			else {
		    				if(spielFeld[posx][posy] == Feld.WASSER && spielFeld[posx][posy+1] == Feld.WASSER && spielFeld[posx][posy+2] == Feld.WASSER && spielFeld[posx][posy+3] == Feld.WASSER) {
			    				spielFeld[posx][posy] = Feld.SCHIFF;
			    				spielFeld[posx][posy+1] = Feld.SCHIFF;
			    				spielFeld[posx][posy+2] = Feld.SCHIFF;
			    				spielFeld[posx][posy+3] = Feld.SCHIFF;
			    				buttons[posx][posy].setName("S4");
			    				buttons[posx][posy+1].setName("S4");
			    				buttons[posx][posy+2].setName("S4");
			    				buttons[posx][posy+3].setName("S4");
			    				Schiff S = new Schiff(posx,posy,posx,posy+1,posx,posy+2,posx,posy+3,schiffsGroesse);
			    				Schiffe[anzahl_schiffe] = S;
			    				anzahl_schiffe++;
			    				this.insert_direction = !this.insert_direction;
			    				return true;
			    			}
			    			else
			    				return false;
			    			}
		    			}
		    		}
	
		    return false;
	 
	 }
	 
	 		
	} 