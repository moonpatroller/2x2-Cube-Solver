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
		// TODO Auto-generated method stub

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
		// TODO Auto-generated method stub
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
				System.out.println("You clicked the button0");

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
	}

}
