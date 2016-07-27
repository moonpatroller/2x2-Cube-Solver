package gui;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;

public class GUI_input {

	public static JPanel panel = new JPanel();
    public static JButton button0 = new JButton("");
    public static JButton button1 = new JButton("");
    public static JButton button2 = new JButton("");
    public static JButton button3 = new JButton("");
     static JButton next = new JButton("Next");
    public static JButton done = new JButton("Done");
    public static JFrame window = new JFrame();
    public static JLabel sideLabel = new JLabel("");
    public static int Side = 0;
    public static int cube[][] = new int[6][4];
    

	public static void main(String[] args) {

		final int WINDOW_HEIGHT = 208;
		final int WINDOW_WIDTH =350;
		
		//creat a window
		
		window.setTitle("First Window");
		
		window.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		window.setVisible(true);
		
		window.setResizable(false);
		
		Componenets();
	}


	private static void Componenets() {
		panel.setLayout(null);
		window.add(panel);
		
		//add the test to tell the user what side is being worked on 
		sideLabel.setText("The top side");
		
		sideLabel.setLocation(205, 20);
		panel.add(sideLabel);
		sideLabel.setSize(200,14);
		
		//add the buttons and put them in the right place 
		
		panel.add(button0);
		button0.setBounds(20,20,60,60);
		
		panel.add(button1);	
		button1.setBounds(96, 20, 60, 60);
		
		panel.add(button2);
		button2.setBounds(20, 96, 60, 60);
		
		panel.add(button3);
		button3.setBounds(96, 96, 60, 60);
		
		panel.add(next);
		next.setBounds(195,98,100,30);
		
		panel.add(done);
		done.setBounds(195, 138, 100, 30);
		
		final int[] side = {0,0,0,0};
		button0.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				//Execute when FIRST button is pressed	
				System.out.println("You clicked on button0");

				//NOTE: this changes that occur when you click it multiple times
				if(side[0] == 5){
					side[0] = 0;
					button0.setBackground(Color.WHITE);
					cube[Side][0] = 0;
				}
				else if(side[0] == 0){
					side[0] = 1;
					button0.setBackground(Color.ORANGE);
					cube[Side][0] = 1;
				}
				else if(side[0] == 1){
					side[0] = 2;
					button0.setBackground(Color.GREEN);
					cube[Side][0] = 2;
				}
				else if(side[0] == 2){
					side[0] = 3;
					button0.setBackground(Color.RED);
					cube[Side][0] = 3;
				}
				else if(side[0] == 3){
					side[0] = 4;
					button0.setBackground(Color.BLUE);
					cube[Side][0] = 4;
				}
				else if(side[0] == 4){
					side[0] = 5;
					button0.setBackground(Color.YELLOW);
					cube[Side][0] = 5;
				}
				
			}
		});
		button1.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				
				System.out.println("You clicked on button1");
				if(side[1] == 5){
					side[1] = 0;
					button1.setBackground(Color.WHITE);
					cube[Side][1] = 0;
				}
				else if(side[1] == 0){
					side[1] = 1;
					button1.setBackground(Color.ORANGE);
					cube[Side][1] = 1;
				}
				else if(side[1] == 1){
					side[1] = 2;
					button1.setBackground(Color.GREEN);
					cube[Side][1] = 2;
				}
				else if(side[1] == 2){
					side[1] = 3;
					button1.setBackground(Color.RED);
					cube[Side][1] = 3;
				}
				else if(side[1] == 3){
					side[1] = 4;
					button1.setBackground(Color.BLUE);
					cube[Side][1] = 4;
				}
				else if(side[1] == 4){
					side[1] = 5;
					button1.setBackground(Color.YELLOW);
					cube[Side][1] = 5;
				}	
			}
		});
		button2.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				
				System.out.println("You clicked on button2");
				if(side[2] == 5){
					side[2] = 0;
					button2.setBackground(Color.WHITE);
					cube[Side][2] = 0;
				}
				else if(side[2] == 0){
					side[2] = 1;
					button2.setBackground(Color.ORANGE);
					cube[Side][0] = 1;
				}
				else if(side[2] == 1){
					side[2] = 2;
					button2.setBackground(Color.GREEN);
					cube[Side][2] = 2;
				}
				else if(side[2] == 2){
					side[2] = 3;
					button2.setBackground(Color.RED);
					cube[Side][2] = 3;
				}
				else if(side[2] == 3){
					side[2] = 4;
					button2.setBackground(Color.BLUE);
					cube[Side][2] = 4;
				}
				else if(side[2] == 4){
					side[2] = 5;
					button2.setBackground(Color.YELLOW);
					cube[Side][2] = 5;
				}
	
			}
				
		});
		button3.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				if(side[3] == 5){
					side[3] = 0;
					button3.setBackground(Color.WHITE);
					cube[Side][3] = 0;
				}
				else if(side[3] == 0){
					side[3] = 1;
					button3.setBackground(Color.ORANGE);
					cube[Side][3] = 1;
				}
				else if(side[3] == 1){
					side[3] = 2;
					button3.setBackground(Color.GREEN);
					cube[Side][3] = 2;
				}
				else if(side[3] == 2){
					side[3] = 3;
					button3.setBackground(Color.RED);
					cube[Side][3] = 3;
				}
				else if(side[3] == 3){
					side[3] = 4;
					button3.setBackground(Color.BLUE);
					cube[Side][3] = 4;
				}
				else if(side[3] == 4){
					side[3] = 5;
					button3.setBackground(Color.YELLOW);
					cube[Side][3] = 5;
				}

			}
		});
		next.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				
				if(Side == 0){
					sideLabel.setText("The top side");
					Side++;
				}
				else if(Side == 1){
					sideLabel.setText("The left side");
					Side++;
				}
				else if(Side == 2){
					sideLabel.setText("The front side");
					Side++;
				}
				else if(Side == 3){
					sideLabel.setText("The right side");
					Side++;
				}
				else if(Side == 4){
					sideLabel.setText("The back side");
					Side++;
				}
				else if(Side == 5){
					sideLabel.setText("The bottom side");
					Side++;
				}
				System.out.println(Side);
			}
		});
		done.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				
				System.out.println("Complete");
			}
		});
		
	}
}
