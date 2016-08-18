package com.haginonyango.pocketsolver;

import com.haginonyango.pocketsolver.turns.*;
import java.util.*;



/*
  The goal for this program is to go through all the possible combinations of the 2x2x2 rubiks cube 
  and to give you the solution to the scramble you have on your cube so that you can solve it. :) 
  
  there are 9 moves that can be applied to the 2x2 cube it has to go through every combination 11 times
  
  there are 
  3674160 different combinations for the 2x2
  
 */
public class PocketSolver {
	
	public int saved_cube[][] = new int [6][4];
	 void print_sides(int cube [][], int first_side, int side_count) {
		char ColorNames [] = {'W','O','G','R','B','Y'};	
		for(int line = 0; line < 2; line++) { 
			for(int side = first_side; side < side_count + first_side; side++) {
				System.out.print(" ");
				if(side_count == 1 || side_count == 6) {
						System.out.print("   ");
					}
				for(int column = 0; column < 2; column++) {
					int sticker = (2 * line) + column;
					System.out.print(ColorNames[cube[side][sticker]]);
				}
			}
		System.out.println();
		}
	}
		
	
	 void print_cube(int[][] cube) {
		print_sides(cube, 0, 1);
		print_sides(cube, 1, 4);
		print_sides(cube, 5, 1);
	} 
		
	//Ui Li U Fi U2 F Ui Li F2 L2
	
	
	public int[][] scan_cube(){
	//input is the colors that we get and will be returned as is
		int input[][] = new int[6][4];
		//Initiate the counter 
		int counter0 = 0;
		
		Scanner in = new Scanner(System.in);
		//Collect the data
		
			System.out.println("Welcome to the 2x2x2 cube solver :)\n \n"
					+ "Please enter your cube");
			
			
			System.out.println(" 0 = white \n 1 = orange \n 2 = green \n 3 = red\n 4 = blue\n 5 = yellow\n");
			System.out.println("Enter the colors for the TOP side\n");
		
			while(counter0 < 4){
				input[0][counter0] = Integer.parseInt(in.nextLine());
				counter0++;	
				
			}

		
		
		
		
			System.out.println(" 0 = white \n 1 = orange \n 2 = green \n 3 = red\n 4 = blue\n 5 = yellow\n");
			System.out.println("Enter the colors for the LEFT side");
			
			//reset the counter
			counter0 = 0;
			while(counter0 < 4){
				input[1][counter0] = Integer.parseInt(in.nextLine());
				counter0++;
			}
			System.out.println(" 0 = white \n 1 = orange \n 2 = green \n 3 = red\n 4 = blue\n 5 = yellow\n");
			System.out.println("Enter the colors for the FRONT side");
			//reset the counter
			counter0 = 0;
			while(counter0 < 4){
				input[2][counter0] = Integer.parseInt(in.nextLine());
				counter0++;
			}
			System.out.println(" 0 = white \n 1 = orange \n 2 = green \n 3 = red\n 4 = blue\n 5 = yellow\n");
			System.out.println("Enter the colors for the RIGHT side");
			//reset the counter
			counter0 = 0;
			while(counter0 < 4){
				input[3][counter0] = Integer.parseInt(in.nextLine());
				counter0++;
			}
			System.out.println(" 0 = white \n 1 = orange \n 2 = green \n 3 = red\n 4 = blue\n 5 = yellow\n");
			System.out.println("Enter the colors for the BACK SIDE");
			//reset the counter
			counter0 = 0;
			while(counter0 < 4){
				input[4][counter0] = Integer.parseInt(in.nextLine());
				counter0++;
			}
			System.out.println("NOTE: Rotate cube back to starting position before rotating the cube\n"
					+ "for the bottom side input\n");
			
			System.out.println(" 0 = white \n 1 = orange \n 2 = green \n 3 = red\n 4 = blue\n 5 = yellow\n");
			System.out.println("Enter the colors for the BOTTOM side");
			//reset the counter
			counter0 = 0;
			while(counter0 < 4){
				input[5][counter0] = Integer.parseInt(in.nextLine());
				counter0++;
			}
		return input;
	}
	   		

	
	
	
	
	public void setForSearch(){
		
		char fail_entry = 'n';
		while(fail_entry == 'n') {
		Scanner input = new Scanner(System.in);
		
		System.out.println();
		StoreState.cube = scan_cube();
		System.out.println("confirm that this is your scramble y/n ");
		print_cube(StoreState.cube);
		
		System.out.print("");
		fail_entry = input.nextLine().charAt(0);
		if(fail_entry == 'n'){
			for(int clear = 0; clear < 5000; clear++){
			     System.out.println() ;
			  	}
			}
		}
		 
	}
	
	public  HashSet<StoreState> combination = new HashSet<StoreState>();
	
	public Rotation BFS_Search(){
		
		Rotation allTurns[] = new Rotation[9];
		allTurns[0] = new Turn_U();
		allTurns[1] = new Turn_Ui();
		allTurns[2] = new Turn_U2();
		allTurns[3] = new Turn_L();
		allTurns[4] = new Turn_Li();
		allTurns[5] = new Turn_L2();
		allTurns[6] = new Turn_F();
		allTurns[7] = new Turn_Fi();
		allTurns[8] = new Turn_F2();
			
	PriorityQueue<Rotation> q = new PriorityQueue<Rotation>();
		
	 StoreState.cube = currState(StoreState.cube);
		while(true)
		{
			if(isUnique()== true){
				for(Rotation rotation :allTurns){
					q.add(rotation);
				}
			}
			else if(isUnique()== false){
				q.remove();
			}
		}
	}
	
	public boolean isUnique(){
		currState(StoreState.cube);
		if(combination.contains(currState(StoreState.cube))){
			return false;
		}
		if(!combination.contains(currState(StoreState.cube))){
			return true;
		}
	return true;
	}
	
	
	public int[][] currState(int [][] cube){
		 
		  return cube;
	}
	
	
	
	
	
	
	/*List<Rotation> listOfTurns = Arrays.asList(allTurns);
	Set<Rotation> combination = new HashSet<Rotation>(listOfTurns);*/
	
	//HashSet<PocketSolver> combination = new HashSet<PocketSolver>();
	
	/*public Rotation BFS_Search(){
			
		while(true)
		{
			if(isUnique()== true){
				for(Rotation rotation :allTurns){
					q.offer(rotation);
				}
			}
			else if(isUnique()== false){
				q.poll();
			}
		}
	}
	
	private int[][] currState;
	public  boolean isUnique(){
		StoreState.cube = currState();
		if(combination.contains(currState())){
			return false;
		}
		else if(!combination.contains(currState())){
			return true;
		}
	return true;
	}
	
	
	private int[][] currState() {
		return null;
	}*/
	
	


		private  boolean isSolved(Rotation testMoves) {

				boolean solved = true;
			
			//check to see if cube is solved
			
				if(StoreState.cube[0][0] != StoreState.cube[0][1] || StoreState.cube[0][0]	!= StoreState.cube[0][2] || StoreState.cube[0][0] != StoreState.cube[0][3]){
					solved = false;
				}
				else if(StoreState.cube[1][0] != StoreState.cube[1][1] || StoreState.cube[1][0] != StoreState.cube[1][2] || StoreState.cube[1][0] != StoreState.cube[1][3]){
					solved = false;
				}
				else if(StoreState.cube[2][0] != StoreState.cube[2][1] || StoreState.cube[2][0] != StoreState.cube[2][2] || StoreState.cube[2][0] != StoreState.cube[2][3]){
					solved = false;
				}
				else if(StoreState.cube[3][0] != StoreState.cube[3][1] || StoreState.cube[3][0] != StoreState.cube[3][2] || StoreState.cube[3][0] != StoreState.cube[3][3]){
					solved = false;
				}
				else if(StoreState.cube[4][0] != StoreState.cube[4][1] || StoreState.cube[4][0] != StoreState.cube[4][2] || StoreState.cube[4][0] != StoreState.cube[4][3]){
					solved = false;
				}
				else if(StoreState.cube[5][0] != StoreState.cube[5][1] || StoreState.cube[5][0] != StoreState.cube[5][2] || StoreState.cube[5][0] != StoreState.cube[5][3]){
					solved = false;
				}
				return solved;
		}	
}
