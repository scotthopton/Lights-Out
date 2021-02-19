import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
public class LightsOut extends Applet{
	String msg = "";
	String msg1 = "";
	String msg2 = "";
	String msg3 = "";
	String msg4 = "";
	String msg5 = "";
	String msg6 = "";
	String msg7 = "";
	String msg8 = "";
	String msg9 = "";
	String msg10 = "";
	String msg11 = "";
	String msg12 = "";
	String msg13 = "";
	String msg14 = "";
	String msg15 = "";
	String msg16 = "";
	Button buttons[] [] = new Button [5] [5]; 
	Button button1 = new Button (); 
	Button button2 = new Button ();
	Button button3 = new Button ();
	Button button4 = new Button ();
	Button button5 = new Button ();
	int count = 0;
	int solve = 0;
	int[][] newArray = new int [5][5];


	public void init () { 
		setLayout (null); 
		setSize (600, 890);
		for (int i = 0 ; i < 5 ; i++){
			for (int j = 0 ; j < 5 ; j++){
				buttons [i] [j] = new Button();
				buttons [i] [j].setBounds (i * 60 + (getSize ().width - 150) / 2,
						j * 60 + (getSize ().height - 150) / 2, 60, 60);
				buttons[i][j].setBackground(Color.yellow);
				add (buttons [i] [j]);
			}
		}

		button1.setLabel("Randomize");
		button1.setBackground(Color.black);
		button1.setBounds(120,490,80,60);
		add(button1);

		button5.setLabel("Solve");
		button5.setBackground(Color.black);
		button5.setBounds(75,560,80,60);
		add(button5);

		try {
			setColour(); //calls method that assigns intial colours to buttons
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		msg1 = "Welcome to LIGHTS OUT";
		msg2 = "The objective is to turn off ALL lights in as few moves as possible.";
		msg3 = "Yellow buttons are on. White buttons are off.";
		msg4 = "When you toggle a light, it and the adjacent lights will switch colours.";
		msg5 = "Let's see if you can turn off all the lights... Bonne Chance!";
		msg6 = "";
		msg7 = "Toggle a light to begin...";
		msg8 = "If you wish to randomize the board, click 'Randomize'.";
		msg9 = "If you wish to see the solution, click 'Solve'.";
	} 


	public int[][] table()throws IOException { 
		String line;
		String desktop=System.getProperty("user.home")+"/Desktop/";
		File myFile=new File(desktop +"data.txt");
		int array[][] = new int [5][5];
		BufferedReader br = new BufferedReader(new FileReader(myFile));
		for (int i=0;i<5;i++) {
			for (int j=0;j<5;j++) {
				array[i][j] = Integer.parseInt(br.readLine());
			}
		}
		br.close();
		return array;
	} 


	public void setColour() throws IOException { 
		int[][] array = new int [5][5];
		array = table();
		for (int i=0;i<5;i++) {
			for (int j=0;j<5;j++) {
				if (array[i][j]==1) {
					buttons[i][j].setBackground(Color.yellow);
					buttons[i][j].setForeground(Color.white);
					newArray[i][j]=1;
				}

				else {
					buttons[i][j].setBackground(Color.white);	
					buttons[i][j].setForeground(Color.white);
					newArray[i][j]=0;
				}
			}
		}
	} 


	public boolean checkColour() { 
		boolean colour = true;
		for (int i = 0 ; i < 5 ; i++) {
			for (int j = 0 ; j < 5 ; j++) {
				if (buttons[i][j].getBackground().equals(Color.yellow)) {
					colour = false;
				}
			}
		}
		return colour;
	} 


	public void addButtonGU () {
		button2.setLabel("Give Up");
		button2.setBackground(Color.black);
		button2.setBounds(120,420,80,60); 
		add(button2);
	} 


	public void addButtonNG () {
		button3.setLabel("New Game");
		button3.setBackground(Color.black);
		button3.setBounds(30,490,80,60); 
		add(button3);
	} 


	public void addButtonSG () {
		button4.setLabel("Replay");
		button4.setBackground(Color.black);
		button4.setBounds(30,420,80,60); 
		add(button4);
	} 


	public void button1 () {
		count=0;
		int rounded=0;
		for (int k=0;k<5;k++) {
			for (int l=0;l<5;l++) { 
				rounded = (int) Math.round((Math.random())*1);

				if (rounded==1) {
					if (k==0&&l==0) {
						switcher(buttons[k][l]);
						switcher(buttons[k+1][l]);
						switcher(buttons[k][l+1]);
					}

					else if (k==4&&l==4) {
						switcher(buttons[k][l]);
						switcher(buttons[k-1][l]);
						switcher(buttons[k][l-1]);
					}

					else if (k==0&&l==4) {
						switcher(buttons[k][l]);
						switcher(buttons[k+1][l]);
						switcher(buttons[k][l-1]);
					}

					else if (k==4&&l==0) {
						switcher(buttons[k][l]);
						switcher(buttons[k-1][l]);
						switcher(buttons[k][l+1]);
					}

					else if (k==0) {
						switcher(buttons[k][l]);
						switcher(buttons[k+1][l]);
						switcher(buttons[k][l+1]);
						switcher(buttons[k][l-1]);
					}

					else if (l==0) {
						switcher(buttons[k][l]);
						switcher(buttons[k+1][l]);
						switcher(buttons[k-1][l]);
						switcher(buttons[k][l+1]);
					}

					else if (k==4) {
						switcher(buttons[k][l]);
						switcher(buttons[k-1][l]);
						switcher(buttons[k][l+1]);
						switcher(buttons[k][l-1]);
					}

					else if (l==4) {
						switcher(buttons[k][l]);
						switcher(buttons[k-1][l]);
						switcher(buttons[k+1][l]);
						switcher(buttons[k][l-1]);
					}

					else {
						for (int x=-1;x<=1;x++) {
							switcher(buttons[k+x][l]);
						}
						switcher(buttons[k][l+1]);
						switcher(buttons[k][l-1]);
					}
				}
			}
		}

		for (int r=0;r<5;r++) {
			for (int c=0;c<5;c++) {
				if (buttons[r][c].getBackground().equals(Color.yellow)) {
					newArray[r][c]=1;
				}

				else if (buttons[r][c].getBackground().equals(Color.white)){
					newArray[r][c]=0;
				}
			}
		}
		button5.setEnabled(true);
		button2.setVisible(false);
	} 


	public void button4 () {
		msg = "Retrying... Good Luck!";
		for (int n = 0 ; n < 5 ; n++) {
			for (int m = 0 ; m < 5 ; m++) {
				buttons[n][m].setEnabled(true);
			}
		}
		button1.setEnabled(true);
		count=0;
		for (int r=0;r<5;r++) {
			for (int c=0;c<5;c++) {
				if (newArray[r][c]==1) {
					buttons[r][c].setBackground(Color.yellow);
				}
				else {
					buttons[r][c].setBackground(Color.white);
				}
			}

		}
		button3.setVisible(false);
		button4.setVisible(false);
		button2.setEnabled(true);
		button2.setVisible(false);
		button5.setEnabled(true);
	} 


	public void win () {
		if (checkColour()==true) { 
			for (int a = 0 ; a < 5 ; a++) {
				for (int b = 0 ; b < 5 ; b++) {
					if (!buttons[a][b].getBackground().equals(Color.red)) {
						buttons[a][b].setBackground(Color.green);
						buttons[a][b].setEnabled(false);
						button1.setEnabled(false);
						addButtonNG();
						button3.setVisible(true);
						addButtonSG();
						button4.setVisible(true);
						msg = "Congratulations, it took "+count+" moves to win!";
						msg11 = "Click 'New Game' to load a new board.";
						msg12 = "To attempt the same board, click 'Replay'.";
					}
				}
			}
			button5.setEnabled(false);
			button2.setVisible(false);
			button2.isVisible();
			button2.setEnabled(false);
			repaint();
		}
	} 


	public void button2 () {
		msg = "That's too bad. Kudos to you for trying!";
		msg11 = "Click 'New Game' to load a new board.";
		msg12 = "To attempt the same board, click 'Replay'.";
		for (int n = 0 ; n < 5 ; n++) {
			for (int m = 0 ; m < 5 ; m++) {
				buttons[n][m].setBackground(Color.red);
				buttons[n][m].setEnabled(false);
			}
		}
		button1.setEnabled(false);
		button2.setVisible(false);
		button3.setVisible(true);
		button4.setVisible(true);
		addButtonNG();
		addButtonSG();
		button5.setEnabled(false);
	} 


	public boolean action (Event e, Object o) {
		for (int i = 0 ; i < 5 ; i++) {
			for (int j = 0 ; j < 5 ; j++) {
				if (e.target == buttons [i] [j]) {
					msg = "You have pressed "+(count+1)+" buttons.";
					count++;

					if (buttons[i][j].getBackground().equals(Color.white)) {
						buttons[i][j].setBackground(Color.yellow);
						repaint ();
					}

					else {
						buttons[i][j].setBackground(Color.white);
						repaint ();
					}

					if (i>0) {
						if (buttons[i-1][j].getBackground().equals(Color.white)) {
							buttons[i-1][j].setBackground(Color.yellow);
							repaint ();
						}

						else {
							buttons[i-1][j].setBackground(Color.white);
							repaint ();
						}
					}

					if (j>0) {
						if (buttons[i][j-1].getBackground().equals(Color.white)) {
							buttons[i][j-1].setBackground(Color.yellow);
							repaint ();
						}

						else {
							buttons[i][j-1].setBackground(Color.white);
							repaint ();
						}
					}

					if (i<4) {
						if (buttons[i+1][j].getBackground().equals(Color.white)) {
							buttons[i+1][j].setBackground(Color.yellow);
							repaint ();
						}

						else {
							buttons[i+1][j].setBackground(Color.white);
							repaint ();
						}
					}

					if (j<4) {
						if (buttons[i][j+1].getBackground().equals(Color.white)) {
							buttons[i][j+1].setBackground(Color.yellow);
							repaint ();
						}

						else {
							buttons[i][j+1].setBackground(Color.white);
							repaint ();
						}
					}

				}

				if (e.target == button1) {
					button1();
				}


				win();


				if (count>=5) {
					addButtonGU();
					msg10 = "If you wish to quit, click 'Give Up', otherwise continue.";
					button2.setVisible(true);
					if (e.target == button2) {
						button2();
					}
				}


				if (e.target == button3) {
					msg = "Try this one!";
					for (int n = 0 ; n < 5 ; n++) {
						for (int m = 0 ; m < 5 ; m++) {
							buttons[n][m].setEnabled(true);
						}
					}
					button1.setEnabled(true);
					button1();
					button3.setVisible(false);
					button4.setVisible(false);
					button2.setEnabled(true);
					button2.setVisible(false);
					button5.setEnabled(true);
				}

				if (e.target == button4) {
					button4();
				}

				if (e.target==button5||solve==1) {
					msg = "Solving...";
					count=0;
					msg13 = "1. Click on the blue dots starting with the second row.";
					msg14 = "2. Once the dots from that row are gone, repeats the steps with the next rows.";
					msg15 = "3. This allows you to chase the lights to the bottom row.";  
					msg16 = "A dot will appear at top. Press button and chase light down again.";
					solve = 1;
					for (int n=0;n<5;n++) {
						for (int m=0;m<5;m++) {
							buttons[n][m].setForeground(Color.blue);
							buttons[n][m].setLabel("");
						}
					}

					for (int n=0;n<5;n++) {
						for (int m=0;m<5;m++) {
							buttons[n][m].setForeground(Color.blue);
							if (buttons[n][m].getBackground().equals(Color.yellow)) {
								if(m<4) {
									buttons[n][m+1].setLabel(".");
								}
							}
						}
					}


					for (int n=0;n<5;n++) {
						for (int m=0;m<4;m++) {
							if (buttons[n][m].getBackground().equals(Color.white)) {
								if (buttons[0][4].getBackground().equals(Color.yellow)&&buttons[1][4].getBackground().equals(Color.yellow)&&buttons[2][4].getBackground().equals(Color.yellow)) {
									buttons[1][0].setLabel(".");
								}

								else if (buttons[0][4].getBackground().equals(Color.yellow)&&buttons[1][4].getBackground().equals(Color.yellow)&&buttons[3][4].getBackground().equals(Color.yellow)&&buttons[4][4].getBackground().equals(Color.yellow)) {
									buttons[2][0].setLabel(".");
								}

								else if (buttons[0][4].getBackground().equals(Color.yellow)&&buttons[2][4].getBackground().equals(Color.yellow)&&buttons[3][4].getBackground().equals(Color.yellow)) {
									buttons[4][0].setLabel(".");
								}

								else if (buttons[0][4].getBackground().equals(Color.yellow)&&buttons[4][4].getBackground().equals(Color.yellow)) {
									buttons[0][0].setLabel(".");
									buttons[1][0].setLabel(".");
								}

								else if (buttons[1][4].getBackground().equals(Color.yellow)&&buttons[2][4].getBackground().equals(Color.yellow)&&buttons[4][4].getBackground().equals(Color.yellow)) {
									buttons[0][0].setLabel(".");
								}

								else if (buttons[1][4].getBackground().equals(Color.yellow)&&buttons[3][4].getBackground().equals(Color.yellow)) {
									buttons[0][0].setLabel(".");
									buttons[3][0].setLabel(".");
								}

								else if (buttons[2][4].getBackground().equals(Color.yellow)&&buttons[3][4].getBackground().equals(Color.yellow)&&buttons[4][4].getBackground().equals(Color.yellow)) {
									buttons[3][0].setLabel(".");
								}
							}
						}
					}


					button5.setEnabled(false);
					button1.setEnabled(false);
					button2.setEnabled(false);
					button4.setVisible(false);
					button3.setVisible(false);

					win();


					if (e.target == button4) {
						button4();
					}

					if (e.target == button3) {
						msg = "Try this one!";
						for (int n = 0 ; n < 5 ; n++) {
							for (int m = 0 ; m < 5 ; m++) {
								buttons[n][m].setEnabled(true);
							}
						}
						button1.setEnabled(true);
						button1();
						button3.setVisible(false);
						button4.setVisible(false);
						button2.setEnabled(true);
						button2.setVisible(false);
						button5.setEnabled(true);
					}


					button5.setEnabled(false);
					button2.setVisible(false);
					button2.isVisible();
					button2.setEnabled(false);
					repaint();
				}

			}

		}
		return false;
	} 


	public static Button switcher(Button buttons) {
		if (buttons.getBackground().equals(Color.white)) {
			buttons.setBackground(Color.yellow);
		}	
		else {
			buttons.setBackground(Color.white);
		}
		return buttons;
	} 


	public void paint (Graphics g) {
		g.drawString (msg, 225, 360);
		g.drawString (msg1, 30, 35);
		g.drawString (msg2, 30, 55);
		g.drawString (msg3, 30, 75);
		g.drawString (msg4, 30, 95);
		g.drawString (msg5, 30, 115);
		g.drawString (msg6, 30, 135);
		g.drawString (msg7, 30, 155);
		g.drawString (msg8, 30, 175);
		g.drawString (msg9, 30, 195);
		g.drawString (msg10, 30, 215);
		g.drawString (msg11, 30, 235);
		g.drawString (msg12, 30, 255);
		g.drawString (msg13, 30, 275);
		g.drawString (msg14, 30, 295);
		g.drawString (msg15, 30, 315);
		g.drawString (msg16, 30, 335);

	} 

} 
