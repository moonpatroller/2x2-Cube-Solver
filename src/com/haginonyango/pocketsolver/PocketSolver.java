package com.haginonyango.pocketsolver;




import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;


/*
  The goal for this program is to go through all the possible combinations of the 2x2x2 rubiks cube 
  and to give you the solution to the scramble you have on your cube so that you can solve it. :) 
  
  there are 9 moves that can be applied to the 2x2 cube it has to go through every combination 11 times
  
  there are 
  3674160 different combinations for the 2x2
  
  
  
 */
public class PocketSolver {
	
	public static int cube1[][] = new int [6][4];
	public static int saved_cube[][] = new int [6][4];
	public static boolean solved = false;
	@SuppressWarnings("unused")
	private static boolean ans;
	@SuppressWarnings("unused")
	private static int counter1;
	static void print_sides(int cube [][], int first_side, int side_count) {
		char ColorNames [] = {'W','O','G','R','B','Y'};	
		for(int line = 0; line < 2; line++) { 
			for(int side = first_side; side < side_count + first_side; side++) {
				System.out.print(" ");
				if(side_count == 1 || side_count == 6) {
						System.out.print("   ");
					}
				for(int column = 0; column < 2; column++) {
					int sticker = (2 * line) + column;
					System.out.print(cube[side][sticker]);
				}
			}
		System.out.println();
		}
	}
		

	
	public static int[][] turn_F(int cube[][]){
		 
		 int cube0_2 = cube[0][2];
		 int cube0_3 = cube[0][3];
		 cube[0][2] = cube[1][3];
		 cube[0][3] = cube[1][1];
		 
		 cube[1][1] = cube[5][0];
		 cube[1][3] = cube[5][1];
		 
		 cube[5][0] = cube[3][2];
		 cube[5][1] = cube[3][0];
		 
		 cube[3][2] = cube0_3;
		 cube[3][0] = cube0_2;	 
		System.out.print("F ");
		return cube;
	}
	public static int[][] turn_Fi(int cube[][]){
		 
		 int cube0_2 = cube[0][2];
		 int cube0_3 = cube[0][3];
		 
		 cube[0][2] = cube[3][0];
		 cube[0][3] = cube[3][2];
		 
		 cube[3][0] = cube[5][1];
		 cube[3][2] = cube[5][0];
		 
		 cube[5][1] = cube[1][3];
		 cube[5][0] = cube[1][1];
		 
		 cube[1][3] = cube0_2;
		 cube[1][1] = cube0_3;
		 System.out.print("Fi ");
		 return cube;
	}
	public static int[][] turn_F2(int cube[][]){
	
		int cube0_2 = cube[0][2];
		int cube0_3 = cube[0][3];
		int cube1_1 = cube[1][1];
		int cube1_3 = cube[1][3];
		
		cube[0][2] = cube[5][1];
		cube[0][3] = cube[5][0];
		
		cube[1][1] = cube[3][2];
		cube[1][3] = cube[3][0];
		
		cube[3][2] = cube1_1;
		cube[3][0] = cube1_3;
		
		cube[5][1] = cube0_2;
		cube[5][0] = cube0_3;
		System.out.print("F2 ");
		return cube;
	}
	
	
	static void print_cube(int[][] cube) {
		print_sides(cube, 0, 1);
		print_sides(cube, 1, 4);
		print_sides(cube, 5, 1);
	} 
		
	//Ui Li U Fi U2 F Ui Li F2 L2
	
	
	public static int[][] scan_cube(){
	//input is the colors that we get and will be returned as is
		int input[][] = new int[6][4];
		//Initiate the counter 
		int counter0 = 0;
		counter1 = 0;
		int x = 1; 
		
		Scanner in = new Scanner(System.in);
		//Collect the data
		do{
			try{
			System.out.println("Welcome to the 2x2x2 cube solver :)\n \n"
					+ "Please enter your cube");
			
			
			System.out.println(" 0 = white \n 1 = orange \n 2 = green \n 3 = red\n 4 = blue\n 5 = yellow\n");
			System.out.println("Enter the colors for the TOP side\n");
		
			while(counter0 < 4){
				counter1 = 0;
				
				input[0][counter0] = Integer.parseInt(in.nextLine());
				counter0++;	
				
			}
			x++;
		}catch(Exception e){
			
		}
		}while(x == 4);
		
		
		
			System.out.println(" 0 = white \n 1 = orange \n 2 = green \n 3 = red\n 4 = blue\n 5 = yellow\n");
			System.out.println("Enter the colors for the LEFT side");
			
			//reset the counter
			counter0 = 0;
			while(counter0 < 4){
				counter1 = 0;
				input[1][counter0] = Integer.parseInt(in.nextLine());
				counter0++;
			}
			System.out.println(" 0 = white \n 1 = orange \n 2 = green \n 3 = red\n 4 = blue\n 5 = yellow\n");
			System.out.println("Enter the colors for the FRONT side");
			//reset the counter
			counter0 = 0;
			while(counter0 < 4){
				counter1 = 0;
				input[2][counter0] = Integer.parseInt(in.nextLine());
				counter0++;
			}
			System.out.println(" 0 = white \n 1 = orange \n 2 = green \n 3 = red\n 4 = blue\n 5 = yellow\n");
			System.out.println("Enter the colors for the RIGHT side");
			//reset the counter
			counter0 = 0;
			while(counter0 < 4){
				counter1 = 0;
				input[3][counter0] = Integer.parseInt(in.nextLine());
				counter0++;
			}
			System.out.println(" 0 = white \n 1 = orange \n 2 = green \n 3 = red\n 4 = blue\n 5 = yellow\n");
			System.out.println("Enter the colors for the BACK SIDE");
			//reset the counter
			counter0 = 0;
			while(counter0 < 4){
				counter1 = 0;
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
				counter1 = 0;
				input[5][counter0] = Integer.parseInt(in.nextLine());
				counter0++;
			}
		return input;
	}
	    

	public static boolean continue_sequence(int x, int y){

        if(x >= 0 && y == -1 || y == 0){
            return false;
        }
        else if(x >= 0 && side_number(x) == side_number(y)){
        	return false;
        }
        	return true;
        	}
		
	
	public static int side_number(int x){
		
		if(x == 0 || x == 1 || x == 2){
			return 0;
		}
		else if(x == 3 || x == 4 || x == 5){
			return 1;
		}
		else if(x == 6 || x == 7 || x == 8){
			return 2;
		}
			
		return x;
	}	
	
	public static void main(String args []) {
	
		long counter = 0;
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
		//setting cube1 to main cubes' colors for testing solution
		for(int x = 0; x < 4; x++){
			cube1[0][x] = StoreState.cube[0][x];
		}
		for(int x = 0; x < 4; x++){
			cube1[1][x] = StoreState.cube[1][x];
		}
		for(int x = 0; x < 4; x++){
			cube1[2][x] = StoreState.cube[2][x];
		}
		for(int x = 0; x < 4; x++){
			cube1[3][x] = StoreState.cube[3][x];
		}
		for(int x = 0; x < 4; x++){
			cube1[4][x] = StoreState.cube[4][x];
		}
		for(int x = 0; x < 4; x++){
			cube1[5][x] = StoreState.cube[5][x];
		}
		
		//save cube position for user in case orientation is forgotten.
		for(int x = 0; x < 4; x++){
			saved_cube[0][x] = StoreState.cube[0][x];
		}
		for(int x = 0; x < 4; x++){
			saved_cube[1][x] = StoreState.cube[1][x];
		}
		for(int x = 0; x < 4; x++){
			saved_cube[2][x] = StoreState.cube[2][x];
		}
		for(int x = 0; x < 4; x++){
			saved_cube[3][x] = StoreState.cube[3][x];
		}
		for(int x = 0; x < 4; x++){
			saved_cube[4][x] = StoreState.cube[4][x];
		}
		for(int x = 0; x < 4; x++){
			saved_cube[5][x] = StoreState.cube[5][x];
		}
		//this is in Main 
		
		
		
/*		String[] things ={"eggs", "lasers","hats","pie"};
		List<String> list1 = new ArrayList<String>();
		*/
	
		HashSet<PocketSolver> combinations = new HashSet<PocketSolver>();
		System.out.println(combinations);
	
		
		 List<Rotation> backtrack(StoreState state, int depth, int maxDepth){
			    if(depth >= maxDepth){ return null;}
			    if(isSolved(state)){ return new ArrayList(depth);}
			    for(Rotation rotation: rotations){
			        StoreState rotated = rotation.apply(state);
			        List<Rotation> sequence = backtrack(rotate, depth+1, maxDepth){
			        if(sequence!= null){
			        	if(isSolved = false){
			        		StoreState.add(StoreState.cube);
			             sequence.add(rotation);
			             return sequence;
			        	} 
			        	}
			        }
			        return null;
		  }
	 }
	}


		private boolean isSolved(StoreState state) {

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
