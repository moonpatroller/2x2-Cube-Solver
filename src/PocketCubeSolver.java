import java.util.Scanner;

/*
  The goal for this program is to go through all the possible combinations of the 2x2x2 rubiks cube 
  and to give you the solution to the scramble you have on your cube so that you can solve it. :) 
  
  ther are 9 moves that can be applied to the 2x2 cube it has to go through every combination 11 times
  
  there are 
  3674160 different combinations for the 2x2
  
  
  
 */
public class PocketCubeSolver {
	public static int cube[][] = new int [6][4];
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
					System.out.print(ColorNames [cube[side][sticker]]);
				}
			}
		System.out.println();
			}
	}
	public static void turn_CW(int cube[][], int side_num){
		  
			  int cube0_0 = cube[side_num][0];
		cube[side_num][0] = cube[side_num][2];
		cube[side_num][2] = cube[side_num][3];
		cube[side_num][3] = cube[side_num][1];
		cube[side_num][1] = cube0_0;		
		}
	public static void turn_CC(int cube[][], int side_num){
		
			  int cube0_0 = cube[side_num][0];
		cube[side_num][0] = cube[side_num][1];
		cube[side_num][1] = cube[side_num][3];
		cube[side_num][3] = cube[side_num][2];
		cube[side_num][2] = cube0_0;
	}
	public static void turn_C2(int cube[][], int side_num){
		
			  int cube0_1 = cube[side_num][1];
			  int cube0_3 = cube[side_num][3];  
		cube[side_num][1] = cube[side_num][2];
		cube[side_num][3] = cube[side_num][0];
		cube[side_num][2] = cube0_1;
		cube[side_num][0] = cube0_3;
	}
	public static int[][] turn_U(int cube [][]){
		 turn_CW(cube, 0);
		int cube2_0 = cube[2][0];
		int cube2_1 = cube[2][1];
		cube[2][0] = cube[3][0];
		cube[2][1] = cube[3][1];
		
		cube[3][0] = cube[4][0];
		cube[3][1] = cube[4][1];
		
		cube[4][0] = cube[1][0];
		cube[4][1] = cube[1][1];
		
		cube[1][0] = cube2_0;
		cube[1][1] = cube2_1;
		System.out.print("U ");
		
		return cube;
		}
	public static int[][] turn_Ui(int cube[][]){
		 turn_CC(cube,0);
		 int cube2_0 = cube[2][0];
		 int cube2_1 = cube[2][1];
		 
		 cube[2][0] = cube[1][0];
		 cube[2][1] = cube[1][1];
		 
		 cube[1][0] = cube[4][0];
		 cube[1][1] = cube[4][1];
		 
		 cube[4][0] = cube[3][0];
		 cube[4][1] = cube[3][1];
		 
		 cube[3][0] = cube2_0;
		 cube[3][1] = cube2_1;
		 System.out.print("Ui ");
		 
		 return cube;
		 }
	public static int[][] turn_U2(int cube[][]){
		turn_C2(cube,0);
		int cube2_0 = cube[2][0];
		int cube2_1 = cube[2][1];
		
		int cube1_0	= cube[1][0];
		int cube1_1 = cube[1][1];
		
		cube[2][0] = cube[4][0];
		cube[2][1] = cube[4][1];
		
		cube[1][0] = cube[3][0];
		cube[1][1] = cube[3][1];
		
		cube[3][0] = cube1_0;
		cube[3][1] = cube1_1;
		
		cube[4][0] = cube2_0;
		cube[4][1] = cube2_1;
		System.out.print("U2 ");	
		return cube;
	}
	public static int[][] turn_F(int cube[][]){
		 turn_CW(cube, 2);
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
		 turn_CC(cube,2);
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
		turn_C2(cube,2);
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
	
	public static int[][] turn_L(int cube[][]){
		 turn_CW(cube,1);
		 int cube0_0 = cube[0][0];
		 int cube0_2 = cube[0][2];
		 
		 cube[0][0] = cube[4][1];
		 cube[0][2] = cube[4][3];
		 
		 cube[4][1] = cube[5][2];
		 cube[4][3] = cube[5][0];
		 
		 cube[5][2] = cube[2][2];
		 cube[5][0] = cube[2][0];
		 
		 cube[2][2] = cube0_2;
		 cube[2][0] = cube0_0;
		 System.out.print("L ");
		 return cube;
	}
	public static int[][] turn_Li(int cube[][]){
		turn_CC(cube, 1);
		int cube0_0 = cube[0][0];
		int cube0_2	= cube[0][2];
		
		cube[0][0] = cube[2][0];
		cube[0][2] = cube[2][2];
		
		cube[2][0] = cube[5][0];
		cube[2][2] = cube[5][2];
		
		cube[5][0] = cube[4][3];
		cube[5][2] = cube[4][1];
		
		cube[4][1] = cube0_2;
		cube[4][3] = cube0_0;
		System.out.print("Li ");
		return cube;
	}
	public static int[][] turn_L2(int cube[][]){
		turn_C2(cube,1);
		int cube0_0 = cube[0][0];
		int cube0_2 = cube[0][2];
		int cube2_0	= cube[2][0];
		int cube2_2	= cube[2][2];
		
		cube[0][0] = cube[5][0];
		cube[0][2] = cube[5][2];
		
		cube[2][0] = cube[4][3];
		cube[2][2] = cube[4][1];
		
		cube[5][0] = cube0_0;
		cube[5][2] = cube0_2;
		
		cube[4][3] = cube2_0;
		cube[4][1] = cube2_2;
		System.out.print("L2 ");
		return cube;
	}
		
	//Ui Li U Fi U2 F Ui Li F2 L2
	
	
	public static int[][] scan_cube(){
	//input is the colors that we get and will be returned as is
		int input[][] = new int[6][4];
		//Initiate the counter 
		int counter0 = 0;
		counter1 = 0;
		
		Scanner in = new Scanner(System.in);
		//Collect the data
			System.out.println("Welcome to the 2x2x2 cube solver :)\n \n"
					+ "Hold the cube in a position that you will remember \n"
					+ "and won't change because the 2x2 has no centers.\nRemembering "
					+ "block colors would be helpful\nE.I: RED 1x1x2 block on top of blue piece\n \n");
			
			
			System.out.println(" 0 = white \n 1 = orange \n 2 = green \n 3 = red\n 4 = blue\n 5 = yellow\n");
			System.out.println("Enter the colors for the TOP side\n");
		
			while(counter0 < 4){
				counter1 = 0;
				
				input[0][counter0] = Integer.parseInt(in.nextLine());
				counter0++;
			}
			
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
			
			//get colors for the red side
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
	
	public static boolean test(int a, int b, int c, int d, int e, int f, int g, int h, int i, int j, int k){
		boolean result1 = true;
		
		
		if(a == 0){
			cube = turn_U(cube);
		}
		else if(a == 1){
			cube = turn_Ui(cube);
		}
		else if(a == 2){
			cube = turn_U2(cube);
		}
		else if(a == 3){
			cube = turn_L(cube);
		}
		else if(a == 4){
			cube = turn_Li(cube);
		}
		else if(a == 5){
			cube = turn_L2(cube);
		}
		else if(a == 6){
			cube = turn_F(cube);
		}
		else if(a == 7){
			cube = turn_Fi(cube);
		}
		else if(a == 8){
			cube = turn_F2(cube);
		}
		
		
		if(b == 0){
			cube = turn_U(cube);
		}
		else if(b == 1){
			cube = turn_Ui(cube);
		}
		else if(b == 2){
			cube = turn_U2(cube);
		}
		else if(b == 3){
			cube = turn_L(cube);
		}
		else if(b == 4){
			cube = turn_Li(cube);
		}
		else if(b == 5){
			cube = turn_L2(cube);
		}
		else if(b == 6){
			cube = turn_F(cube);
		}
		else if(b == 7){
			cube = turn_Fi(cube);
		}
		else if(b == 8){
			cube = turn_F2(cube);
		}
		
		
		if(c == 0){
			cube = turn_U(cube);
		}
		else if(c == 1){
			cube = turn_Ui(cube);
		}
		else if(c == 2){
			cube = turn_U2(cube);
		}
		else if(c == 3){
			cube = turn_L(cube);
		}
		else if(c == 4){
			cube = turn_Li(cube);
		}
		else if(c == 5){
			cube = turn_L2(cube);
		}
		else if(c == 6){
			cube = turn_F(cube);
		}
		else if(c == 7){
			cube = turn_Fi(cube);
		}
		else if(c == 8){
			cube = turn_F2(cube);
		}
		
		
		if(d == 0){
			cube = turn_U(cube);
		}
		else if(d == 1){
			cube = turn_Ui(cube);
		}
		else if(d == 2){
			cube = turn_U2(cube);
		}
		else if(d == 3){
			cube = turn_L(cube);
		}
		else if(d == 4){
			cube = turn_Li(cube);
		}
		else if(d == 5){
			cube = turn_L2(cube);
		}
		else if(d == 6){
			cube = turn_F(cube);
		}
		else if(d == 7){
			cube = turn_Fi(cube);
		}
		else if(d == 8){
			cube = turn_F2(cube);
		}
		
		
		if(e == 0){
			cube = turn_U(cube);
		}
		else if(e == 1){
			cube = turn_Ui(cube);
		}
		else if(e == 2){
			cube = turn_U2(cube);
		}
		else if(e == 3){
			cube = turn_L(cube);
		}
		else if(e == 4){
			cube = turn_Li(cube);
		}
		else if(e == 5){
			cube = turn_L2(cube);
		}
		else if(e == 6){
			cube = turn_F(cube);
		}
		else if(e == 7){
			cube = turn_Fi(cube);
		}
		else if(e == 8){
			cube = turn_F2(cube);
		}
		
		if(f == 0){
			cube = turn_U(cube);
		}
		else if(f == 1){
			cube = turn_Ui(cube);
		}
		else if(f == 2){
			cube = turn_U2(cube);
		}
		else if(f == 3){
			cube = turn_L(cube);
		}
		else if(f == 4){
			cube = turn_Li(cube);
		}
		else if(f == 5){
			cube = turn_L2(cube);
		}
		else if(f == 6){
			cube = turn_F(cube);
		}
		else if(f == 7){
			cube = turn_Fi(cube);
		}
		else if(f == 8){
			cube = turn_F2(cube);
		}
		
		
		if(g == 0){
			cube = turn_U(cube);
		}
		else if(g == 1){
			cube = turn_Ui(cube);
		}
		else if(g == 2){
			cube = turn_U2(cube);
		}
		else if(g == 3){
			cube = turn_L(cube);
		}
		else if(g == 4){
			cube = turn_Li(cube);
		}
		else if(g == 5){
			cube = turn_L2(cube);
		}
		else if(g == 6){
			cube = turn_F(cube);
		}
		else if(g == 7){
			cube = turn_Fi(cube);
		}
		else if(g == 8){
			cube = turn_F2(cube);
		}
		
		
		if(h == 0){
			cube = turn_U(cube);
		}
		else if(h == 1){
			cube = turn_Ui(cube);
		}
		else if(h == 2){
			cube = turn_U2(cube);
		}
		else if(h == 3){
			cube = turn_L(cube);
		}
		else if(h == 4){
			cube = turn_Li(cube);
		}
		else if(h == 5){
			cube = turn_L2(cube);
		}
		else if(h == 6){
			cube = turn_F(cube);
		}
		else if(h == 7){
			cube = turn_Fi(cube);
		}
		else if(h == 8){
			cube = turn_F2(cube);
		}
				
		if(i == 0){
			cube = turn_U(cube);
		}
		else if(i == 1){
			cube = turn_Ui(cube);
		}
		else if(i == 2){
			cube = turn_U2(cube);
		}
		else if(i == 3){
			cube = turn_L(cube);
		}
		else if(i == 4){
			cube = turn_Li(cube);
		}
		else if(i == 5){
			cube = turn_L2(cube);
		}
		else if(i == 6){
			cube = turn_F(cube);
		}
		else if(i == 7){
			cube = turn_Fi(cube);
		}
		else if(i == 8){
			cube = turn_F2(cube);
		}
		
		
		if(j == 0){
			cube = turn_U(cube);
		}
		else if(j == 1){
			cube = turn_Ui(cube);
		}
		else if(j == 2){
			cube = turn_U2(cube);
		}
		else if(j == 3){
			cube = turn_L(cube);
		}
		else if(j == 4){
			cube = turn_Li(cube);
		}
		else if(j == 5){
			cube = turn_L2(cube);
		}
		else if(j == 6){
			cube = turn_F(cube);
		}
		else if(j == 7){
			cube = turn_Fi(cube);
		}
		else if(j == 8){
			cube = turn_F2(cube);
		}
		
		
		if(k == 0){
			cube = turn_U(cube);
		}
		else if(k == 1){
			cube = turn_Ui(cube);
		}
		else if(k == 2){
			cube = turn_U2(cube);
		}
		else if(k == 3){
			cube = turn_L(cube);
		}
		else if(k == 4){
			cube = turn_Li(cube);
		}
		else if(k == 5){
			cube = turn_L2(cube);
		}
		else if(k == 6){
			cube = turn_F(cube);
		}
		else if(k == 7){
			cube = turn_Fi(cube);
		}
		else if(k == 8){
			cube = turn_F2(cube);
		}
		
		//check to see if cube is solved
	     
		
			if(cube[0][0] != cube[0][1] || cube[0][0] != cube[0][2] || cube[0][0] != cube[0][3]){
				result1 = false;
			}
			else if(cube[1][0] != cube[1][1] || cube[1][0] != cube[1][2] || cube[1][0] != cube[1][3]){
				result1 = false;
			}
			else if(cube[2][0] != cube[2][1] || cube[2][0] != cube[2][2] || cube[2][0] != cube[2][3]){
				result1 = false;
			}
			else if(cube[3][0] != cube[3][1] || cube[3][0] != cube[3][2] || cube[3][0] != cube[3][3]){
				result1 = false;
			}
			else if(cube[4][0] != cube[4][1] || cube[4][0] != cube[4][2] || cube[4][0] != cube[4][3]){
				result1 = false;
			}
			else if(cube[5][0] != cube[5][1] || cube[5][0] != cube[5][2] || cube[5][0] != cube[5][3]){
				result1 = false;
			}
		return result1;
	}
	public static void resetColors(){
		for(int x = 0; x < 4; x++){
			cube[0][x] = cube1[0][x];
		}
		for(int x = 0; x < 4; x++){
			cube[1][x] = cube1[1][x];
		}
		for(int x = 0; x < 4; x++){
			cube[2][x] = cube1[2][x];
		}
		
		for(int x = 0; x < 4; x++){
			cube[3][x] = cube1[3][x];
		}
		for(int x = 0; x < 4; x++){
			cube[4][x] = cube1[4][x];
		}
		for(int x = 0; x < 4; x++){
			cube[5][x] = cube1[5][x];
		}
	}
		
	static void print_cube(int[][] cube) {
		print_sides(cube, 0, 1);
		print_sides(cube, 1, 4);
		print_sides(cube, 5, 1);
	} 
	
	public static void call_turn(int [][] cube, int not_sure){
		
	}
	
	public static boolean continue_sequence(int x, int y){

        if(x >= 0 && y == -1){
            return false;
        }
        else if(x >= 0 && side_number(x) == side_number(y)){
        	return false;
        }
        	return true;
    	}
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
	
	public static void store_combination(int cube[][]){
		
		
		
	}
	
	public static void main(String[] args){
	
		Scanner input = new Scanner(System.in);
		 
		ans = true;
		long counter = 0;
		char valid_cube;
		
		System.out.println();
		cube = scan_cube();
		System.out.println("confirm that this is your scramble y/n ");
		print_cube(cube);
		
		valid_cube = input.next().charAt(0);
		
		ans = (valid_cube == 'y');
		if (valid_cube == 'n'){
			System.out.println("Please retry entering your cube");
			System.exit(0);
		}
		//setting cube1 to main cubes' colors for testing solution
		for(int x = 0; x < 4; x++){
			cube1[0][x] = cube[0][x];
		}
		for(int x = 0; x < 4; x++){
			cube1[1][x] = cube[1][x];
		}
		for(int x = 0; x < 4; x++){
			cube1[2][x] = cube[2][x];
		}
		for(int x = 0; x < 4; x++){
			cube1[3][x] = cube[3][x];
		}
		for(int x = 0; x < 4; x++){
			cube1[4][x] = cube[4][x];
		}
		for(int x = 0; x < 4; x++){
			cube1[5][x] = cube[5][x];
		}
		
		//save cube position for user in case orientation is forgotten.
		for(int x = 0; x < 4; x++){
			saved_cube[0][x] = cube[0][x];
		}
		for(int x = 0; x < 4; x++){
			saved_cube[1][x] = cube[1][x];
		}
		for(int x = 0; x < 4; x++){
			saved_cube[2][x] = cube[2][x];
		}
		for(int x = 0; x < 4; x++){
			saved_cube[3][x] = cube[3][x];
		}
		for(int x = 0; x < 4; x++){
			saved_cube[4][x] = cube[4][x];
		}
		for(int x = 0; x < 4; x++){
			saved_cube[5][x] = cube[5][x];
		}
		
		//9 ways the cube can be turned 
		for(int a = -1; a < 10; a++){
			for(int b = -1; b < 10; b++){
				if(continue_sequence(a,b))
				for(int c = -1; c < 10;c++ ){
					if(continue_sequence(b,c))
					for(int d = -1; d < 10; d++){
						if(continue_sequence(c,d))
						for(int e = -1; e < 10; e++){
							if(continue_sequence(d,e))
							for(int f = -1; f < 10; f++){
								if(continue_sequence(e,f))
								for(int g = -1; g < 10; g++){
									if(continue_sequence(f,g))
									for(int h = -1; h < 10; h++){
										if(continue_sequence(g,h))
										for(int i = -1; i < 10; i++){
											if(continue_sequence(h,i))
											for(int j = -1; j < 10; j++){
												if(continue_sequence(i,j))
												for(int k = -1;k < 10; k++){
													if(continue_sequence(j,k)){
										System.out.println("Testing combination:"+ counter);
										solved = test(a,b,c,d,e,f,g,h,i,j,k);
										
										if(solved){
											
											System.out.println();
											System.out.println("Your cube has been solved, the solution is above this line");
											System.out.println("In case you forgot the position of your cube here it is ;) ");
											
											cube = saved_cube;
											print_cube(cube);
														}
													
											resetColors();
											counter++;
													}
												if(solved){
													break;
												}
											}
											if(solved){
												break;
												}
											}
										if(solved){
											break;
											}
										}
									if(solved){
										break;
										}	
									}
								if(solved){
									break;
									}	
								}
							if(solved){
								break;
								}	
							}
						if(solved){
							break;
							}	
						}
					if(solved){
						break;
						}	
					}
			if(solved){
				break;
				}	
			}
		if(solved){
			break;
			}	
		}
	if(solved){
		break;
	}
		
}	
	}	
}
